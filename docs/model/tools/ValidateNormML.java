import java.nio.file.Path;
import java.util.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.*;
import org.eclipse.emf.ecore.xmi.impl.*;
import org.eclipse.ocl.ecore.OCL;

/** Standalone validation using the EMF/OCL jars bundled with Eclipse Modeling Tools. */
public class ValidateNormML {
    static int checked;
    static final OCL ocl = OCL.newInstance();
    static void require(boolean ok, String message) {
        if (!ok) throw new AssertionError(message);
    }
    static void structural(EObject object) {
        Diagnostic d = Diagnostician.INSTANCE.validate(object);
        require(d.getSeverity() < Diagnostic.ERROR, d.toString());
    }
    static List<String> constraints(EObject root) throws Exception {
        List<String> failures = new ArrayList<>();
        List<EObject> objects = new ArrayList<>(); objects.add(root);
        root.eAllContents().forEachRemaining(objects::add);
        for (EObject object : objects) {
            List<EClass> types = new ArrayList<>(object.eClass().getEAllSuperTypes());
            types.add(object.eClass());
            for (EClass type : types) {
                EAnnotation a = type.getEAnnotation("http://www.eclipse.org/emf/2002/Ecore/OCL/LPG");
                if (a == null) continue;
                for (var entry : a.getDetails()) {
                    var helper = ocl.createOCLHelper(); helper.setContext(type);
                    var query = ocl.createQuery(helper.createInvariant(entry.getValue()));
                    checked++;
                    if (!query.check(object)) failures.add(type.getName() + "." + entry.getKey());
                }
            }
        }
        return failures;
    }
    public static void main(String[] args) throws Exception {
        Path dir = Path.of(args.length == 0 ? "docs/model" : args[0]).toAbsolutePath();
        ResourceSet rs = new ResourceSetImpl();
        org.eclipse.ocl.ecore.delegate.OCLDelegateDomain.initialize(rs, "http://www.eclipse.org/emf/2002/Ecore/OCL/LPG");
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        for (String file : List.of("normml.ecore")) {
            EPackage ep = (EPackage) rs.getResource(URI.createFileURI(dir.resolve(file).toString()), true).getContents().get(0);
            rs.getPackageRegistry().put(ep.getNsURI(), ep);
        }
        EPackage pkg = (EPackage) rs.getResource(URI.createFileURI(dir.resolve("normml.ecore").toString()), true).getContents().get(0);
        EcoreUtil.resolveAll(rs);
        require(EcoreUtil.UnresolvedProxyCrossReferencer.find(rs).isEmpty(), "Unresolved metamodel references");
        structural(pkg);
        int invariants = 0;
        for (EClassifier c : pkg.getEClassifiers()) if (c instanceof EClass type) {
            EAnnotation a = type.getEAnnotation("http://www.eclipse.org/emf/2002/Ecore/OCL/LPG");
            if (a != null) for (var entry : a.getDetails()) {
                var helper = ocl.createOCLHelper(); helper.setContext(type);
                helper.createInvariant(entry.getValue()); invariants++;
            }
        }
        EObject valid = rs.getResource(URI.createFileURI(dir.resolve("normml-valid.xmi").toString()), true).getContents().get(0);
        structural(valid);
        require(constraints(valid).isEmpty(), "Valid model fails: " + constraints(valid));
        // Roundtrip through an in-memory stream at the same URI preserves local references.
        java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
        valid.eResource().save(bytes, Map.of());
        Resource copy = new XMIResourceImpl(valid.eResource().getURI());
        rs.getResources().add(copy);
        copy.load(new java.io.ByteArrayInputStream(bytes.toByteArray()), Map.of());
        structural(copy.getContents().get(0));
        require(constraints(copy.getContents().get(0)).isEmpty(), "Roundtrip changes validity");
        EObject invalid = rs.getResource(URI.createFileURI(dir.resolve("normml-invalid-between.xmi").toString()), true).getContents().get(0);
        require(Diagnostician.INSTANCE.validate(invalid).getSeverity() == Diagnostic.ERROR, "Invalid model accepted by EMF/OCL delegate");
        var failures = constraints(invalid);
        require(failures.equals(List.of("Between.DistinctDateBoundaries")), "Unexpected failures: " + failures);
        EObject composite = null, atomic = null;
        var all = valid.eAllContents();
        while (all.hasNext()) {
            EObject o = all.next();
            if (o.eClass().getName().equals("CompositeAction")) composite = o;
            if (o.eClass().getName().equals("AtomicAction")) atomic = o;
        }
        @SuppressWarnings("unchecked") var children = (List<EObject>) composite.eGet(composite.eClass().getEStructuralFeature("subordinateActions"));
        children.add(composite);
        require(constraints(valid).contains("CompositeAction.AcyclicComposition"), "Composite cycle accepted");
        children.remove(composite);
        EStructuralFeature kind = atomic.eClass().getEStructuralFeature("kind");
        Object old = atomic.eGet(kind);
        atomic.eSet(kind, ((EEnum)pkg.getEClassifier("AtomicActionKind")).getEEnumLiteral("AtomicSend").getInstance());
        require(constraints(valid).contains("AtomicAction.CompatibleResource"), "Sending an attribute accepted");
        atomic.eSet(kind, old);
        require(constraints(valid).isEmpty(), "Model did not recover after negative cases");
        System.out.println("PASS: " + pkg.getEClassifiers().size() + " classifiers; " + invariants + " OCL invariants compiled; independent fixture with Condition and roundtrip; negative date window, composite cycle and incompatible action.");
        require(rs.getResources().stream().noneMatch(r -> r.getURI().toString().matches(".*(csl|bpmn|istar)\\.ecore")), "External metamodel loaded");
        ocl.dispose();
    }
}
