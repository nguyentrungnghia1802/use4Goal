"""Regenerate the Eclipse EcoreTools/Sirius diagram from normml.ecore (requires lxml)."""
from pathlib import Path
import json
from lxml import etree as E

DIR = Path(__file__).resolve().parents[1]
NS = {'xmi':'http://www.omg.org/XMI', 'xsi':'http://www.w3.org/2001/XMLSchema-instance',
      'ecore':'http://www.eclipse.org/emf/2002/Ecore', 'viewpoint':'http://www.eclipse.org/sirius/1.1.0',
      'description':'http://www.eclipse.org/sirius/description/1.1.0',
      'description_1':'http://www.eclipse.org/sirius/diagram/description/1.1.0',
      'diagram':'http://www.eclipse.org/sirius/diagram/1.1.0',
      'style':'http://www.eclipse.org/sirius/diagram/description/style/1.1.0',
      'notation':'http://www.eclipse.org/gmf/runtime/1.0.3/notation'}
BASE = "platform:/plugin/org.eclipse.emf.ecoretools.design/description/ecore.odesign#//@ownedViewpoints[name='Design']"
REP = BASE + "/@ownedRepresentations[name='Entities']"
LAYER = REP + '/@defaultLayer'
count = 0

def node(parent, tag, typ=None, **attrs):
    global count
    e = E.SubElement(parent, tag, **{k:str(v) for k,v in attrs.items()})
    if typ:
        e.set('{'+NS['xmi']+'}type', typ)
        count += 1
        e.set('{'+NS['xmi']+'}id' if typ.startswith('notation:') else 'uid', '_normml' + str(count))
    return e

def link(parent, tag, typ, href):
    e=E.SubElement(parent,tag,href=href);e.set('{'+NS['xmi']+'}type',typ);return e

def semantic(parent,typ,path):
    for tag in ['target','semanticElements']:link(parent,tag,typ,'normml.ecore#//'+path)

root=E.Element('{'+NS['xmi']+'}XMI',nsmap=NS);root.set('{'+NS['xmi']+'}version','2.0')
a=E.SubElement(root,'{'+NS['viewpoint']+'}DAnalysis',uid='_normmlAnalysis',selectedViews='_normmlView',version='15.4.1.202403191723')
for filename in ['normml.ecore','normml.genmodel']:E.SubElement(a,'semanticResources').text=filename
v=node(a,'ownedViews','viewpoint:DView');v.set('uid','_normmlView');link(v,'viewpoint','description:Viewpoint',BASE)
rd=node(v,'ownedRepresentationDescriptors','viewpoint:DRepresentationDescriptor',name='NormMLMetamodel',repPath='#_normmlDiagram')
link(rd,'description','description_1:DiagramDescription',REP);link(rd,'target','ecore:EPackage','normml.ecore#/')
d=E.SubElement(root,'{'+NS['diagram']+'}DSemanticDiagram',uid='_normmlDiagram')
an=node(d,'ownedAnnotationEntries','description:AnnotationEntry',source='GMF_DIAGRAMS')
gmf=node(an,'data','notation:Diagram',type='Sirius',element='_normmlDiagram',measurementUnit='Pixel')
# Historical user layout is the baseline; preserve subsequent Eclipse edits too.
package=E.parse(str(DIR/'normml.ecore')).getroot()
classes=package.findall('eClassifiers'); nodes={}; notation={}
bounds=json.loads((DIR/'tools/normml-layout.json').read_text())
# --restore-layout explicitly restores the recovered user layout.
import sys
if (DIR/'normml.aird').exists() and '--restore-layout' not in sys.argv:
    previous=E.parse(str(DIR/'normml.aird'))
    names={n.get('uid'):n.get('name') for n in previous.findall('.//ownedDiagramElements')}
    for n in previous.findall('.//data/children'):
        b=n.find('layoutConstraint'); name=names.get(n.get('element'))
        if name and b is not None:
            bounds[name]={k:int(b.get(k,'0')) for k in ('x','y','width','height')}
new_names=[c.get('name') for c in classes if c.get('name') not in bounds]
for i,name in enumerate(new_names):
    bounds[name]=dict(x=1600+(i%4)*330,y=180+(i//4)*300,width=260,height=230)
for c in classes:
    for f in c.findall('eStructuralFeatures'):
        assert '.ecore#//' not in f.get('eType',''), 'External metamodel reference'
for c in classes:
    name=c.get('name');enum=c.get('{'+NS['xsi']+'}type')=='ecore:EEnum';kind='EEnum' if enum else 'EClass'
    cm=LAYER+"/@containerMappings[name='EC%20"+kind+"']"
    n=node(d,'ownedDiagramElements','diagram:DNodeList',name=name,width=12,height=10)
    nodes[name]=n;semantic(n,'ecore:'+kind,name)
    style=node(n,'ownedStyle','diagram:FlatContainerStyle',borderSize=1,borderSizeComputationExpression='1',foregroundColor='221,236,202' if enum else ('228,228,228' if c.get('abstract')=='true' else '255,252,216'))
    if c.get('abstract')=='true':E.SubElement(style,'labelFormat').text='italic'
    link(style,'description','style:FlatContainerStyleDescription',cm+'/@style')
    link(n,'actualMapping','description_1:ContainerMapping',cm)
    gn=node(gmf,'children','notation:Node',type='2003',element=n.get('uid'));notation[name]=gn.get('{'+NS['xmi']+'}id')
    node(gn,'children','notation:Node',type='5007')
    compartment=node(gn,'children','notation:Node',type='7004')
    fs=c.findall('eLiterals') if enum else [f for f in c.findall('eStructuralFeatures') if f.get('{'+NS['xsi']+'}type')=='ecore:EAttribute']
    for f in fs:
        fk='EEnumLiteral' if enum else 'EAttribute';fn=f.get('name');text=fn if enum else fn+' : '+f.get('eType').split('#//')[-1]
        child=node(n,'ownedElements','diagram:DNodeListElement',name=text);semantic(child,'ecore:'+fk,name+'/'+fn)
        sm=cm+"/@subNodeMappings[name='EC%20"+fk+"']"
        st=node(child,'ownedStyle','diagram:BundledImage',labelAlignment='LEFT')
        link(st,'description','style:BundledImageDescription',sm+'/@style');link(child,'actualMapping','description_1:NodeMapping',sm)
        gchild=node(compartment,'children','notation:Node',type='3010',element=child.get('uid'))
        node(gchild,'styles','notation:FontStyle',fontName='Sans',fontHeight=10)
        node(gchild,'layoutConstraint','notation:Location')
    node(compartment,'styles','notation:SortingStyle');node(compartment,'styles','notation:FilteringStyle')
    node(gn,'styles','notation:ShapeStyle',fontName='Sans',fontHeight=10)
    node(gn,'layoutConstraint','notation:Bounds',**bounds[name])
seen=set(); edges=[]
for c in classes:
    name=c.get('name')
    # Class inheritance and one edge per opposite-reference pair.
    for supertype in c.get('eSuperTypes','').split():
        target=supertype.split('#//')[-1]
        if target in nodes:edges.append((name,target,name,None,'',True))
    for f in c.findall('eStructuralFeatures'):
        if f.get('{'+NS['xsi']+'}type')!='ecore:EReference':continue
        path=name+'/'+f.get('name');opp=f.get('eOpposite','').removeprefix('#//')
        # Render each bidirectional association only once, from the containment or normative side.
        if opp and opp in seen:continue
        
        seen.add(path)
        target=f.get('diagramTarget',f.get('eType').split('#//')[-1]);hi=f.get('upperBound','1');lo=f.get('lowerBound','0')
        label=f.get('name')+' ['+lo+'..'+('*' if hi=='-1' else hi)+']'
        edges.append((name,target,path,f,label,False))
for src,tgt,path,f,label,inheritance in edges:
    mapping=LAYER+"/@edgeMappings[name='"+('EC%20ESupertypes' if inheritance else 'EC_EReference')+"']"
    edge=node(d,'ownedDiagramElements','diagram:DEdge',name=label,sourceNode=nodes[src].get('uid'),targetNode=nodes[tgt].get('uid'))
    semantic(edge,'ecore:EClass' if inheritance else 'ecore:EReference',path)
    style=node(edge,'ownedStyle','diagram:EdgeStyle',routingStyle='manhattan',strokeColor='65,75,85')
    if inheritance:style.set('targetArrow','InputClosedArrow')
    elif f.get('containment')=='true':style.set('sourceArrow','FillDiamond')
    link(style,'description','style:EdgeStyleDescription',mapping+'/@style')
    node(style,'centerLabelStyle','diagram:CenterLabelStyle',showIcon='false',labelSize=9)
    link(edge,'actualMapping','description_1:EdgeMapping',mapping)
    for name,prop in [(src,'outgoingEdges'),(tgt,'incomingEdges')]:nodes[name].set(prop,(nodes[name].get(prop,'')+' '+edge.get('uid')).strip())
    ge=node(gmf,'edges','notation:Edge',type='4001',element=edge.get('uid'),source=notation[src],target=notation[tgt])
    for typ in ['6001','6002','6003']:
        labelnode=node(ge,'children','notation:Node',type=typ);node(labelnode,'layoutConstraint','notation:Bounds',y=-12)
    node(ge,'styles','notation:ConnectorStyle',routing='Rectilinear');node(ge,'styles','notation:FontStyle',fontName='Sans',fontHeight=9)
    node(ge,'bendpoints','notation:RelativeBendpoints',points='[0, 0, 0, 0]$[0, 0, 0, 0]')
link(d,'description','description_1:DiagramDescription',REP)
node(d,'filterVariableHistory','diagram:FilterVariableHistory')
link(d,'activatedLayers','description_1:Layer',LAYER)
link(d,'target','ecore:EPackage','normml.ecore#/')
(DIR/'normml.aird').write_bytes(E.tostring(root,pretty_print=True,xml_declaration=True,encoding='UTF-8'))
print('Created normml.aird:',len(classes),'nodes,',len(edges),'edges')
