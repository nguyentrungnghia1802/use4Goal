package org.vnu.sme.goal.dsl.normml.parser;

import java.util.*;
import javax.xml.datatype.DatatypeFactory;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS;
import org.vnu.sme.goal.dsl.normml.ast.NormModelCS.*;
import org.vnu.sme.goal.dsl.normml.mm.*;
import org.vnu.sme.goal.dsl.normml.mm.NormSchema.Feature;

/** Two passes: declarations/attributes, then references/opposites and containment. */
final class NormModelFactory {
    private final NormSchema schema = NormSchema.INSTANCE;
    private final String sourceName;
    private final List<String> errors;
    private final Map<String, Mutable> elements = new LinkedHashMap<>();
    private record Mutable(String id, String type, Location location, Map<String,List<String>> values) {}
    NormModelFactory(String sourceName, List<String> errors) { this.sourceName=sourceName; this.errors=errors; }
    private void error(Location l, String message) { errors.add(sourceName+":"+l.line()+":"+l.column()+": semantic: "+message); }
    NormModel create(NormModelCS ast, String source) {
        var root = new Mutable("__model", "NormModel", new Location(1,0), new LinkedHashMap<>());
        root.values.put("name", new ArrayList<>(List.of(ast.name()))); elements.put(root.id, root);
        for (var d : ast.declarations()) {
            var type=schema.type(d.type());
            if (type==null || type.abstractType() || type.enumeration() || d.type().equals("NormModel")) {
                error(d.location(), "Cannot instantiate " + d.type()); continue;
            }
            if (elements.containsKey(d.id())) { error(d.location(), "Duplicate or reserved identifier " + d.id()); continue; }
            var e=new Mutable(d.id(),d.type(),d.location(),new LinkedHashMap<>()); elements.put(e.id,e);
            var fs=schema.features(e.type); Set<String> supplied=new HashSet<>();
            for (var p : d.properties()) {
                Feature f=fs.get(p.name());
                if (f==null || p.name().equals("model")) { error(p.location(), "Unknown or automatic feature " + e.type+"."+p.name()); continue; }
                if (!supplied.add(p.name())) { error(p.location(), "Duplicate feature " + p.name()); continue; }
                List<String> values=new ArrayList<>();
                for (Value v : p.values()) {
                    if (v.reference()!=f.reference()) { error(p.location(), f.name()+ (f.reference()?" requires @reference":" requires a value")); continue; }
                    if (!f.reference()) {
                        var t=schema.type(f.type());
                        if (t!=null && t.enumeration() && !t.literals().contains(v.text())) {
                            error(p.location(), "Invalid "+f.type()+" literal "+v.text()); continue;
                        }
                        if (f.type().equals("EDate")) try {
                            var date=DatatypeFactory.newInstance().newXMLGregorianCalendar(v.text());
                            if (!date.isValid() || date.getYear()==Integer.MIN_VALUE || date.getMonth()==Integer.MIN_VALUE || date.getDay()==Integer.MIN_VALUE)
                                throw new IllegalArgumentException();
                        } catch (Exception ex) { error(p.location(), "Invalid date " + v.text()); continue; }
                    }
                    if (values.contains(v.text()) && f.reference()) error(p.location(), "Duplicate reference @"+v.text());
                    else values.add(v.text());
                }
                e.values.put(p.name(),values);
            }
            for (Feature f : fs.values()) if (!e.values.containsKey(f.name())) {
                if (f.defaultValue()!=null) e.values.put(f.name(),new ArrayList<>(List.of(f.defaultValue())));
                else if (f.name().equals("name")) e.values.put("name",new ArrayList<>(List.of(e.id)));
            }
            // Root containment and its model opposite are determined from Ecore.
            for (Feature f : schema.features("NormModel").values())
                if (f.containment() && schema.isA(e.type,f.type())) {
                    add(root,f.name(),e.id); if (!f.opposite().isEmpty()) add(e,f.opposite(),root.id);
                }
        }
        // Snapshot explicit edges before materializing their inverse ends.
        record Edge(Mutable from, Feature feature, String to) {}
        List<Edge> edges=new ArrayList<>();
        for (var e:elements.values()) for (var f:schema.features(e.type).values()) if (f.reference())
            for (String target:e.values.getOrDefault(f.name(),List.of())) edges.add(new Edge(e,f,target));
        for (var edge:edges) {
            Mutable target=elements.get(edge.to);
            if (target==null) { error(edge.from.location,"Unknown reference @"+edge.to); continue; }
            if (!schema.isA(target.type,edge.feature.type())) {
                error(edge.from.location,edge.feature.name()+" expects "+edge.feature.type()+", found "+target.type); continue;
            }
            if (!edge.feature.opposite().isEmpty()) add(target,edge.feature.opposite(),edge.from.id);
        }
        if (!errors.isEmpty()) return null;
        Map<String,String> owners=new HashMap<>();
        for (var e:elements.values()) for (Feature f:schema.features(e.type).values()) {
            var vs=e.values.getOrDefault(f.name(),List.of()); int size=vs.size();
            if (size<f.lower() || (f.upper()!=-1 && size>f.upper()))
                error(e.location,e.id+"."+f.name()+" requires "+f.lower()+".."+(f.upper()==-1?"*":f.upper())+" values; found "+size);
            if (f.containment()) for (String id:vs) {
                String previous=owners.putIfAbsent(id,e.id+"."+f.name());
                if (previous!=null) error(elements.get(id).location,"Multiple containment owners for "+id+": "+previous+" and "+e.id+"."+f.name());
            }
        }
        for (var e:elements.values()) if (e!=root && !owners.containsKey(e.id)) error(e.location,"Uncontained "+e.type+" "+e.id);
        if (!errors.isEmpty()) return null;
        Map<String,NormModel.Element> frozen=new LinkedHashMap<>();
        elements.forEach((id,e)->frozen.put(id,new NormModel.Element(id,e.type,e.values,e.location)));
        NormModel model=new NormModel(ast.name(),frozen,source);
        NormSemanticValidator.validate(model,(e,message)->error(e.location(),message));
        return model;
    }
    private static void add(Mutable e,String feature,String id) {
        var values=e.values.computeIfAbsent(feature,k->new ArrayList<>()); if (!values.contains(id)) values.add(id);
    }
}
