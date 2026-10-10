// Generated from NormML.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.normml.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link NormMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface NormMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link NormMLParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(NormMLParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(NormMLParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#organizationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrganizationDecl(NormMLParser.OrganizationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#organizationProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrganizationProperty(NormMLParser.OrganizationPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#agentDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentDecl(NormMLParser.AgentDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#agentProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentProperty(NormMLParser.AgentPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#roleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleDecl(NormMLParser.RoleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#roleProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleProperty(NormMLParser.RolePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#dataTypeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeDecl(NormMLParser.DataTypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#entityResourceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityResourceDecl(NormMLParser.EntityResourceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#entityResourceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityResourceProperty(NormMLParser.EntityResourcePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#attributeResourceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeResourceDecl(NormMLParser.AttributeResourceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#attributeResourceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeResourceProperty(NormMLParser.AttributeResourcePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#associationEndResourceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociationEndResourceDecl(NormMLParser.AssociationEndResourceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#associationEndResourceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssociationEndResourceProperty(NormMLParser.AssociationEndResourcePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#agentActionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentActionDecl(NormMLParser.AgentActionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#agentActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentActionProperty(NormMLParser.AgentActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#messageResourceDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageResourceDecl(NormMLParser.MessageResourceDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#messageResourceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMessageResourceProperty(NormMLParser.MessageResourcePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#atomicActionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicActionDecl(NormMLParser.AtomicActionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#atomicActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicActionProperty(NormMLParser.AtomicActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#compositeActionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeActionDecl(NormMLParser.CompositeActionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#compositeActionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeActionProperty(NormMLParser.CompositeActionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormDecl(NormMLParser.NormDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormProperty(NormMLParser.NormPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#beforeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeDecl(NormMLParser.BeforeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#beforeProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeProperty(NormMLParser.BeforePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#afterDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterDecl(NormMLParser.AfterDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#afterProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterProperty(NormMLParser.AfterPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#betweenDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenDecl(NormMLParser.BetweenDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#betweenProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenProperty(NormMLParser.BetweenPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#ifDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfDecl(NormMLParser.IfDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#ifProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfProperty(NormMLParser.IfPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#dateDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateDecl(NormMLParser.DateDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionDecl(NormMLParser.SanctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionProperty(NormMLParser.SanctionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#conditionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionDecl(NormMLParser.ConditionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#conditionBodyProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionBodyProperty(NormMLParser.ConditionBodyPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#nameProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNameProperty(NormMLParser.NamePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#descriptionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescriptionProperty(NormMLParser.DescriptionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#dateValueProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateValueProperty(NormMLParser.DateValuePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#condExprProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondExprProperty(NormMLParser.CondExprPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#condLangProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondLangProperty(NormMLParser.CondLangPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normTypeProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormTypeProperty(NormMLParser.NormTypePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionTypeProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionTypeProperty(NormMLParser.SanctionTypePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#atomicKindProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicKindProperty(NormMLParser.AtomicKindPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#compositeKindProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeKindProperty(NormMLParser.CompositeKindPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormType(NormMLParser.NormTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionType(NormMLParser.SanctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#atomicActionKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicActionKind(NormMLParser.AtomicActionKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#compositeActionKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompositeActionKind(NormMLParser.CompositeActionKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#subOrganizationsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubOrganizationsProperty(NormMLParser.SubOrganizationsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#parentProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParentProperty(NormMLParser.ParentPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#rolesProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRolesProperty(NormMLParser.RolesPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#agentsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgentsProperty(NormMLParser.AgentsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#organizationsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrganizationsProperty(NormMLParser.OrganizationsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#organizationPropertyRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrganizationPropertyRef(NormMLParser.OrganizationPropertyRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#playersProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlayersProperty(NormMLParser.PlayersPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#playsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlaysProperty(NormMLParser.PlaysPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#resourcesProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourcesProperty(NormMLParser.ResourcesPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#actionsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActionsProperty(NormMLParser.ActionsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#dataTypeProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataTypeProperty(NormMLParser.DataTypePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#resourceProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitResourceProperty(NormMLParser.ResourcePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormsProperty(NormMLParser.NormsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#conditionProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionProperty(NormMLParser.ConditionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#subordinateActionsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubordinateActionsProperty(NormMLParser.SubordinateActionsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#accessProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessProperty(NormMLParser.AccessPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#constraintsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintsProperty(NormMLParser.ConstraintsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionsProperty(NormMLParser.SanctionsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#activatedByProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivatedByProperty(NormMLParser.ActivatedByPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#normPropertyRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormPropertyRef(NormMLParser.NormPropertyRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#datesProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatesProperty(NormMLParser.DatesPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#beforeActionsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeforeActionsProperty(NormMLParser.BeforeActionsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#afterActionsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfterActionsProperty(NormMLParser.AfterActionsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#startDateProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStartDateProperty(NormMLParser.StartDatePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#endDateProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndDateProperty(NormMLParser.EndDatePropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#sanctionedNormsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSanctionedNormsProperty(NormMLParser.SanctionedNormsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#activatedNormsProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivatedNormsProperty(NormMLParser.ActivatedNormsPropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(NormMLParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link NormMLParser#referenceList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceList(NormMLParser.ReferenceListContext ctx);
}