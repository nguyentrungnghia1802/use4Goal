grammar NormML;

@header { package org.vnu.sme.goal.dsl.normml.parser; }

// ============================================================================
// NormML concrete syntax
//
// Every declaration below maps to one concrete EClass in docs/model/normml.ecore.
// Abstract EClasses Resource, Action and NormConstraint cannot be declared.
// NormModel is represented by the outer `normml <name> { ... }` block.
//
// References are local identifiers prefixed by '@'. Opposite references and the
// root containment/model links are completed by NormModelFactory. Property order
// is deliberately free; Ecore lower/upper bounds and OCL invariants are checked
// after parsing.
// ============================================================================

model
    : 'normml' IDENT '{' declaration* '}' EOF
    ;

declaration
    : organizationDecl
    | agentDecl
    | roleDecl
    | dataTypeDecl
    | entityResourceDecl
    | attributeResourceDecl
    | associationEndResourceDecl
    | agentActionDecl
    | messageResourceDecl
    | atomicActionDecl
    | compositeActionDecl
    | normDecl
    | beforeDecl
    | afterDecl
    | betweenDecl
    | ifDecl
    | dateDecl
    | sanctionDecl
    | conditionDecl
    ;

// ── Normative subjects ───────────────────────────────────────────────────────

organizationDecl
    : 'Organization' IDENT '{' organizationProperty* '}'
    ;

organizationProperty
    : nameProperty
    | subOrganizationsProperty
    | parentProperty
    | rolesProperty
    | normsProperty
    | resourcesProperty
    ;

agentDecl
    : 'Agent' IDENT '{' agentProperty* '}'
    ;

agentProperty
    : nameProperty
    | playsProperty
    | normsProperty
    | resourcesProperty
    ;

roleDecl
    : 'Role' IDENT '{' roleProperty* '}'
    ;

roleProperty
    : nameProperty
    | organizationPropertyRef
    | playersProperty
    | normsProperty
    | resourcesProperty
    ;

dataTypeDecl
    : 'DataType' IDENT '{' nameProperty* '}'
    ;

// ── Resources ────────────────────────────────────────────────────────────────

entityResourceDecl
    : 'EntityResource' IDENT '{' entityResourceProperty* '}'
    ;

entityResourceProperty
    : nameProperty
    | actionsProperty
    ;

attributeResourceDecl
    : 'AttributeResource' IDENT '{' attributeResourceProperty* '}'
    ;

attributeResourceProperty
    : nameProperty
    | actionsProperty
    | dataTypeProperty
    ;

associationEndResourceDecl
    : 'AssociationEndResource' IDENT '{' associationEndResourceProperty* '}'
    ;

associationEndResourceProperty
    : nameProperty
    | actionsProperty
    ;

agentActionDecl
    : 'AgentAction' IDENT '{' agentActionProperty* '}'
    ;

agentActionProperty
    : nameProperty
    | actionsProperty
    ;

messageResourceDecl
    : 'MessageResource' IDENT '{' messageResourceProperty* '}'
    ;

messageResourceProperty
    : nameProperty
    | actionsProperty
    | dataTypeProperty
    ;

// ── Actions ──────────────────────────────────────────────────────────────────

atomicActionDecl
    : 'AtomicAction' IDENT '{' atomicActionProperty* '}'
    ;

atomicActionProperty
    : atomicKindProperty
    | resourceProperty
    | normsProperty
    | conditionProperty
    ;

compositeActionDecl
    : 'CompositeAction' IDENT '{' compositeActionProperty* '}'
    ;

compositeActionProperty
    : compositeKindProperty
    | resourceProperty
    | normsProperty
    | conditionProperty
    | subordinateActionsProperty
    ;

// ── Norms, constraints and sanctions ────────────────────────────────────────

normDecl
    : 'Norm' IDENT '{' normProperty* '}'
    ;

normProperty
    : nameProperty
    | normTypeProperty
    | accessProperty
    | constraintsProperty
    | sanctionsProperty
    | activatedByProperty
    | rolesProperty
    | agentsProperty
    | organizationsProperty
    ;

beforeDecl
    : 'Before' IDENT '{' beforeProperty* '}'
    ;

beforeProperty
    : normPropertyRef
    | datesProperty
    | beforeActionsProperty
    ;

afterDecl
    : 'After' IDENT '{' afterProperty* '}'
    ;

afterProperty
    : normPropertyRef
    | datesProperty
    | afterActionsProperty
    ;

betweenDecl
    : 'Between' IDENT '{' betweenProperty* '}'
    ;

betweenProperty
    : normPropertyRef
    | datesProperty
    | afterActionsProperty
    | beforeActionsProperty
    | startDateProperty
    | endDateProperty
    ;

ifDecl
    : 'If' IDENT '{' ifProperty* '}'
    ;

// If deliberately has no `dates` property: If::NoDateGuard in the Ecore.
ifProperty
    : normPropertyRef
    | conditionProperty
    ;

dateDecl
    : 'Date' IDENT '{' dateValueProperty* '}'
    ;

sanctionDecl
    : 'Sanction' IDENT '{' sanctionProperty* '}'
    ;

sanctionProperty
    : sanctionTypeProperty
    | descriptionProperty
    | sanctionedNormsProperty
    | activatedNormsProperty
    ;

conditionDecl
    : 'Condition' IDENT '{' conditionBodyProperty* '}'
    ;

conditionBodyProperty
    : condExprProperty
    | condLangProperty
    ;

// ── EAttributes ──────────────────────────────────────────────────────────────

nameProperty         : 'name'        ':' STRING             ';' ;
descriptionProperty  : 'description' ':' STRING             ';' ;
dateValueProperty    : 'value'       ':' STRING             ';' ;
condExprProperty     : 'condExpr'    ':' STRING             ';' ;
condLangProperty     : 'condLang'    ':' IDENT              ';' ;

normTypeProperty      : 'type' ':' normType            ';' ;
sanctionTypeProperty  : 'type' ':' sanctionType        ';' ;
atomicKindProperty    : 'kind' ':' atomicActionKind    ';' ;
compositeKindProperty : 'kind' ':' compositeActionKind ';' ;

normType
    : 'NormProhibition'
    | 'NormPermission'
    | 'NormObligation'
    ;

sanctionType
    : 'Punishment'
    | 'Reward'
    ;

atomicActionKind
    : 'AtomicCreate'
    | 'AtomicRead'
    | 'AtomicUpdate'
    | 'AtomicDelete'
    | 'AtomicExecute'
    | 'AtomicSend'
    | 'AtomicReceive'
    ;

compositeActionKind
    : 'EntityRead'
    | 'EntityUpdate'
    | 'EntityFullAccess'
    | 'AttributeFullAccess'
    | 'AssociationEndFullAccess'
    | 'MessageFullAccess'
    ;

// ── EReferences ──────────────────────────────────────────────────────────────

subOrganizationsProperty : 'subOrganizations' ':' referenceList ';' ;
parentProperty            : 'parent'           ':' reference     ';' ;
rolesProperty             : 'roles'            ':' referenceList ';' ;
agentsProperty            : 'agents'           ':' referenceList ';' ;
organizationsProperty     : 'organizations'    ':' referenceList ';' ;
organizationPropertyRef   : 'organization'     ':' reference     ';' ;
playersProperty           : 'players'          ':' referenceList ';' ;
playsProperty             : 'plays'            ':' referenceList ';' ;
resourcesProperty         : 'resources'        ':' referenceList ';' ;
actionsProperty           : 'actions'          ':' referenceList ';' ;
dataTypeProperty          : 'dataType'         ':' reference     ';' ;
resourceProperty          : 'resource'         ':' reference     ';' ;
normsProperty             : 'norms'            ':' referenceList ';' ;
conditionProperty         : 'condition'        ':' reference     ';' ;
subordinateActionsProperty
                           : 'subordinateActions' ':' referenceList ';' ;
accessProperty            : 'access'           ':' referenceList ';' ;
constraintsProperty       : 'constraints'      ':' referenceList ';' ;
sanctionsProperty         : 'sanctions'        ':' referenceList ';' ;
activatedByProperty       : 'activatedBy'      ':' referenceList ';' ;
normPropertyRef           : 'norm'             ':' reference     ';' ;
datesProperty             : 'dates'            ':' referenceList ';' ;
beforeActionsProperty     : 'beforeActions'    ':' referenceList ';' ;
afterActionsProperty      : 'afterActions'     ':' referenceList ';' ;
startDateProperty         : 'startDate'        ':' reference     ';' ;
endDateProperty           : 'endDate'          ':' reference     ';' ;
sanctionedNormsProperty   : 'sanctionedNorms'  ':' referenceList ';' ;
activatedNormsProperty    : 'activatedNorms'   ':' referenceList ';' ;

reference     : '@' IDENT ;
referenceList : '[' (reference (',' reference)*)? ']' ;

// ── Lexer ────────────────────────────────────────────────────────────────────

IDENT  : [a-zA-Z_] [a-zA-Z_0-9]* ;
STRING : '"' ('\\' . | ~["\\\r\n])* '"' ;

LINE_COMMENT  : '//' ~[\r\n]*  -> skip ;
BLOCK_COMMENT : '/*' .*? '*/'  -> skip ;
WS            : [ \t\r\n\f]+ -> skip ;
