package org.vnu.sme.goal.dsl.normml.mm;

import java.util.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;

/** Read the canonical Ecore shipped in the plugin; no dependency on other metamodels. */
public final class NormSchema {
    public record Feature(String name, String type, boolean reference, boolean containment,
                          int lower, int upper, String opposite, String defaultValue) {}
    public record Type(String name, String parent, boolean abstractType, boolean enumeration,
                       Map<String, Feature> features, List<String> literals) {}
    private final Map<String, Type> types = new LinkedHashMap<>();
    public static final NormSchema INSTANCE = new NormSchema();
    private NormSchema() {
        try (var in = NormSchema.class.getResourceAsStream("/metamodel/normml.ecore")) {
            if (in == null) throw new IllegalStateException("Missing metamodel/normml.ecore");
            var factory = DocumentBuilderFactory.newDefaultInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            var root = factory.newDocumentBuilder().parse(in).getDocumentElement();
            for (Element c : children(root, "eClassifiers")) {
                Map<String, Feature> fs = new LinkedHashMap<>();
                for (Element f : children(c, "eStructuralFeatures")) {
                    String target = f.getAttribute("eType");
                    if (!target.startsWith("#//") && !target.startsWith("ecore:EDataType http://www.eclipse.org/emf/2002/Ecore#//"))
                        throw new IllegalStateException("External NormML type: " + target);
                    String opposite = f.getAttribute("eOpposite");
                    fs.put(f.getAttribute("name"), new Feature(f.getAttribute("name"), tail(target),
                        f.getAttribute("xsi:type").equals("ecore:EReference"),
                        f.getAttribute("containment").equals("true"), number(f, "lowerBound", 0),
                        number(f, "upperBound", 1), opposite.isEmpty() ? "" : opposite.substring(opposite.lastIndexOf('/') + 1),
                        f.hasAttribute("defaultValueLiteral") ? f.getAttribute("defaultValueLiteral") : null));
                }
                List<String> literals = children(c, "eLiterals").stream().map(e -> e.getAttribute("name")).toList();
                String name = c.getAttribute("name");
                types.put(name, new Type(name, tail(c.getAttribute("eSuperTypes")),
                    c.getAttribute("abstract").equals("true"), c.getAttribute("xsi:type").equals("ecore:EEnum"),
                    Collections.unmodifiableMap(fs), literals));
            }
        } catch (Exception e) { throw new IllegalStateException("Cannot load NormML metamodel", e); }
    }
    private static String tail(String s) { return s.substring(s.lastIndexOf("#//") + (s.contains("#//") ? 3 : 1)); }
    private static int number(Element e, String key, int fallback) {
        return e.hasAttribute(key) ? Integer.parseInt(e.getAttribute(key)) : fallback;
    }
    private static List<Element> children(Element e, String tag) {
        List<Element> result = new ArrayList<>();
        for (var n = e.getFirstChild(); n != null; n = n.getNextSibling())
            if (n instanceof Element child && child.getTagName().equals(tag)) result.add(child);
        return result;
    }
    public Type type(String name) { return types.get(name); }
    public Map<String, Feature> features(String name) {
        Type t = Objects.requireNonNull(type(name), name);
        Map<String, Feature> result = new LinkedHashMap<>();
        if (!t.parent().isEmpty()) result.putAll(features(t.parent()));
        result.putAll(t.features()); return result;
    }
    public boolean isA(String actual, String expected) {
        for (Type t = type(actual); t != null; t = type(t.parent())) if (t.name().equals(expected)) return true;
        return false;
    }
}
