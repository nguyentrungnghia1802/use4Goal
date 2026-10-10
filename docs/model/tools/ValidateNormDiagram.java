import java.nio.file.*;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.*;
import org.eclipse.emf.ecore.xmi.impl.*;
import org.eclipse.emf.ecore.util.*;
public class ValidateNormDiagram {
 static void check(ResourceSet rs) {
  for(int i=0;i<rs.getResources().size();i++) {
   Resource resource=rs.getResources().get(i);
   if (!resource.getURI().isFile()) continue; // EcoreTools external environment resolves inside Eclipse.
   var it=resource.getAllContents();
   while(it.hasNext()) {
    EObject o=it.next();
    for(EReference f:o.eClass().getEAllReferences()) {
     if(f.isDerived() || f.isTransient())continue;
     Object value=o.eGet(f);
     java.util.List<?> values=f.isMany()?(java.util.List<?>)value:java.util.Collections.singletonList(value);
     for(Object v:values)if(v instanceof EObject obj && obj.eIsProxy()) {
      EObject resolved=EcoreUtil.resolve(obj,rs);
      if(resolved.eIsProxy())throw new AssertionError("Unresolved " + EcoreUtil.getURI(obj));
     }
    }
   }
  }
 }
 public static void main(String[] args) throws Exception {
  ResourceSet rs=new ResourceSetImpl();
  EPackage[] packages={org.eclipse.sirius.viewpoint.ViewpointPackage.eINSTANCE,org.eclipse.sirius.diagram.DiagramPackage.eINSTANCE,org.eclipse.sirius.viewpoint.description.DescriptionPackage.eINSTANCE,org.eclipse.sirius.diagram.description.DescriptionPackage.eINSTANCE,org.eclipse.sirius.diagram.description.style.StylePackage.eINSTANCE,org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE,org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage.eINSTANCE};
  for(EPackage p:packages)rs.getPackageRegistry().put(p.getNsURI(),p);
  rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",new XMIResourceFactoryImpl());
  rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",new EcoreResourceFactoryImpl());
  try(var files=Files.list(Path.of(args[0]))) { files.filter(p->p.toString().endsWith(".jar")&&!p.toString().contains(".source_")).forEach(p->{String n=p.getFileName().toString().split("_")[0];rs.getURIConverter().getURIMap().put(URI.createURI("platform:/plugin/"+n+"/"),URI.createURI("archive:"+p.toUri()+"!/"));}); }
  Resource r=rs.getResource(URI.createFileURI(Path.of("docs/model/normml.aird").toAbsolutePath().toString()),true);
  check(rs);
  Resource gm=rs.getResource(URI.createFileURI(Path.of("docs/model/normml.genmodel").toAbsolutePath().toString()),true);
  check(rs);
  System.out.println("PASS: Sirius/GMF diagram and GenModel load with no unresolved references (including EcoreTools mappings).");
 }
}
