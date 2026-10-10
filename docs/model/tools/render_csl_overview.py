from lxml import etree as E
from pathlib import Path
S='http://www.w3.org/2000/svg';X='http://www.w3.org/2001/XMLSchema-instance'
r=E.parse('docs/model/csl.ecore');root=E.Element('{'+S+'}svg',nsmap={None:S},width='1480',height='1180',viewBox='0 0 1480 1180')
def el(tag,**attrs):return E.SubElement(root,tag,**{k.replace('_','-'):str(v) for k,v in attrs.items()})
def text(x,y,s,size=14,bold=False):
 e=el('text',x=x,y=y,font_family='sans-serif',font_size=size,fill='#182534',font_weight='bold' if bold else 'normal');e.text=s
el('rect',width=1480,height=1180,fill='white');text(45,45,'CSL — Composite State Language',26,True);text(45,76,'Metamodel from csl.ecore · references and multiplicities shown in each class',15)
pos={'CslModel':(520,120),'Object':(520,320),'Attribute':(990,120),'DataType':(990,430),'Enumeration':(990,600),'Entity':(50,600),'Role':(520,600),'OrgCtx':(520,830),'Association':(50,120),'AssociationEnd':(50,320),'Invariant':(990,830),'AssociationRelKind':(50,890)}
for c in r.findall('eClassifiers'):
 name=c.get('name');x,y=pos[name];lines=[]
 for f in c.findall('eStructuralFeatures'):
  typ=f.get('eType').split('#//')[-1];hi=f.get('upperBound','1');lo=f.get('lowerBound','0');multi=lo+'..'+('*' if hi=='-1' else hi)
  if f.get('{'+X+'}type')=='ecore:EAttribute':lines.append(f.get('name')+' : '+typ+(' = '+f.get('defaultValueLiteral') if f.get('defaultValueLiteral') is not None else ''))
  else:lines.append(('◆ ' if f.get('containment')=='true' else '→ ')+f.get('name')+' : '+typ+' ['+multi+']')
 for l in c.findall('eLiterals'):lines.append(l.get('name'))
 if c.get('eSuperTypes'):lines.insert(0,'extends '+', '.join(t.split('#//')[-1] for t in c.get('eSuperTypes').split()))
 h=52+24*len(lines);el('rect',x=x,y=y,width=420,height=h,rx=6,fill='#ecf5e6' if c.get('{'+X+'}type')=='ecore:EEnum' else '#fffde8',stroke='#34465b',stroke_width=1.5)
 el('line',x1=x,y1=y+37,x2=x+420,y2=y+37,stroke='#34465b');text(x+14,y+25,name+(' «abstract»' if c.get('abstract')=='true' else ''),17,True)
 for j,line in enumerate(lines):text(x+14,y+60+24*j,line,14)
text(45,1150,'◆ containment     → non-containment reference     * unbounded     inherited features appear in the superclass',14)
Path('docs/images/CSLMetamodel.svg').write_bytes(E.tostring(root,xml_declaration=True,encoding='utf-8',pretty_print=True))
