// Generated from NormML.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.normml.parser; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NormMLParser}.
 */
public interface NormMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NormMLParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(NormMLParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(NormMLParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(NormMLParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(NormMLParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#organizationDecl}.
	 * @param ctx the parse tree
	 */
	void enterOrganizationDecl(NormMLParser.OrganizationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#organizationDecl}.
	 * @param ctx the parse tree
	 */
	void exitOrganizationDecl(NormMLParser.OrganizationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#organizationProperty}.
	 * @param ctx the parse tree
	 */
	void enterOrganizationProperty(NormMLParser.OrganizationPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#organizationProperty}.
	 * @param ctx the parse tree
	 */
	void exitOrganizationProperty(NormMLParser.OrganizationPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#agentDecl}.
	 * @param ctx the parse tree
	 */
	void enterAgentDecl(NormMLParser.AgentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#agentDecl}.
	 * @param ctx the parse tree
	 */
	void exitAgentDecl(NormMLParser.AgentDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#agentProperty}.
	 * @param ctx the parse tree
	 */
	void enterAgentProperty(NormMLParser.AgentPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#agentProperty}.
	 * @param ctx the parse tree
	 */
	void exitAgentProperty(NormMLParser.AgentPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#roleDecl}.
	 * @param ctx the parse tree
	 */
	void enterRoleDecl(NormMLParser.RoleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#roleDecl}.
	 * @param ctx the parse tree
	 */
	void exitRoleDecl(NormMLParser.RoleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#roleProperty}.
	 * @param ctx the parse tree
	 */
	void enterRoleProperty(NormMLParser.RolePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#roleProperty}.
	 * @param ctx the parse tree
	 */
	void exitRoleProperty(NormMLParser.RolePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#dataTypeDecl}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeDecl(NormMLParser.DataTypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#dataTypeDecl}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeDecl(NormMLParser.DataTypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#entityResourceDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityResourceDecl(NormMLParser.EntityResourceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#entityResourceDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityResourceDecl(NormMLParser.EntityResourceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#entityResourceProperty}.
	 * @param ctx the parse tree
	 */
	void enterEntityResourceProperty(NormMLParser.EntityResourcePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#entityResourceProperty}.
	 * @param ctx the parse tree
	 */
	void exitEntityResourceProperty(NormMLParser.EntityResourcePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#attributeResourceDecl}.
	 * @param ctx the parse tree
	 */
	void enterAttributeResourceDecl(NormMLParser.AttributeResourceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#attributeResourceDecl}.
	 * @param ctx the parse tree
	 */
	void exitAttributeResourceDecl(NormMLParser.AttributeResourceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#attributeResourceProperty}.
	 * @param ctx the parse tree
	 */
	void enterAttributeResourceProperty(NormMLParser.AttributeResourcePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#attributeResourceProperty}.
	 * @param ctx the parse tree
	 */
	void exitAttributeResourceProperty(NormMLParser.AttributeResourcePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#associationEndResourceDecl}.
	 * @param ctx the parse tree
	 */
	void enterAssociationEndResourceDecl(NormMLParser.AssociationEndResourceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#associationEndResourceDecl}.
	 * @param ctx the parse tree
	 */
	void exitAssociationEndResourceDecl(NormMLParser.AssociationEndResourceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#associationEndResourceProperty}.
	 * @param ctx the parse tree
	 */
	void enterAssociationEndResourceProperty(NormMLParser.AssociationEndResourcePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#associationEndResourceProperty}.
	 * @param ctx the parse tree
	 */
	void exitAssociationEndResourceProperty(NormMLParser.AssociationEndResourcePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#agentActionDecl}.
	 * @param ctx the parse tree
	 */
	void enterAgentActionDecl(NormMLParser.AgentActionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#agentActionDecl}.
	 * @param ctx the parse tree
	 */
	void exitAgentActionDecl(NormMLParser.AgentActionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#agentActionProperty}.
	 * @param ctx the parse tree
	 */
	void enterAgentActionProperty(NormMLParser.AgentActionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#agentActionProperty}.
	 * @param ctx the parse tree
	 */
	void exitAgentActionProperty(NormMLParser.AgentActionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#messageResourceDecl}.
	 * @param ctx the parse tree
	 */
	void enterMessageResourceDecl(NormMLParser.MessageResourceDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#messageResourceDecl}.
	 * @param ctx the parse tree
	 */
	void exitMessageResourceDecl(NormMLParser.MessageResourceDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#messageResourceProperty}.
	 * @param ctx the parse tree
	 */
	void enterMessageResourceProperty(NormMLParser.MessageResourcePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#messageResourceProperty}.
	 * @param ctx the parse tree
	 */
	void exitMessageResourceProperty(NormMLParser.MessageResourcePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#atomicActionDecl}.
	 * @param ctx the parse tree
	 */
	void enterAtomicActionDecl(NormMLParser.AtomicActionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#atomicActionDecl}.
	 * @param ctx the parse tree
	 */
	void exitAtomicActionDecl(NormMLParser.AtomicActionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#atomicActionProperty}.
	 * @param ctx the parse tree
	 */
	void enterAtomicActionProperty(NormMLParser.AtomicActionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#atomicActionProperty}.
	 * @param ctx the parse tree
	 */
	void exitAtomicActionProperty(NormMLParser.AtomicActionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#compositeActionDecl}.
	 * @param ctx the parse tree
	 */
	void enterCompositeActionDecl(NormMLParser.CompositeActionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#compositeActionDecl}.
	 * @param ctx the parse tree
	 */
	void exitCompositeActionDecl(NormMLParser.CompositeActionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#compositeActionProperty}.
	 * @param ctx the parse tree
	 */
	void enterCompositeActionProperty(NormMLParser.CompositeActionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#compositeActionProperty}.
	 * @param ctx the parse tree
	 */
	void exitCompositeActionProperty(NormMLParser.CompositeActionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normDecl}.
	 * @param ctx the parse tree
	 */
	void enterNormDecl(NormMLParser.NormDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normDecl}.
	 * @param ctx the parse tree
	 */
	void exitNormDecl(NormMLParser.NormDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normProperty}.
	 * @param ctx the parse tree
	 */
	void enterNormProperty(NormMLParser.NormPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normProperty}.
	 * @param ctx the parse tree
	 */
	void exitNormProperty(NormMLParser.NormPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#beforeDecl}.
	 * @param ctx the parse tree
	 */
	void enterBeforeDecl(NormMLParser.BeforeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#beforeDecl}.
	 * @param ctx the parse tree
	 */
	void exitBeforeDecl(NormMLParser.BeforeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#beforeProperty}.
	 * @param ctx the parse tree
	 */
	void enterBeforeProperty(NormMLParser.BeforePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#beforeProperty}.
	 * @param ctx the parse tree
	 */
	void exitBeforeProperty(NormMLParser.BeforePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#afterDecl}.
	 * @param ctx the parse tree
	 */
	void enterAfterDecl(NormMLParser.AfterDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#afterDecl}.
	 * @param ctx the parse tree
	 */
	void exitAfterDecl(NormMLParser.AfterDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#afterProperty}.
	 * @param ctx the parse tree
	 */
	void enterAfterProperty(NormMLParser.AfterPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#afterProperty}.
	 * @param ctx the parse tree
	 */
	void exitAfterProperty(NormMLParser.AfterPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#betweenDecl}.
	 * @param ctx the parse tree
	 */
	void enterBetweenDecl(NormMLParser.BetweenDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#betweenDecl}.
	 * @param ctx the parse tree
	 */
	void exitBetweenDecl(NormMLParser.BetweenDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#betweenProperty}.
	 * @param ctx the parse tree
	 */
	void enterBetweenProperty(NormMLParser.BetweenPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#betweenProperty}.
	 * @param ctx the parse tree
	 */
	void exitBetweenProperty(NormMLParser.BetweenPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#ifDecl}.
	 * @param ctx the parse tree
	 */
	void enterIfDecl(NormMLParser.IfDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#ifDecl}.
	 * @param ctx the parse tree
	 */
	void exitIfDecl(NormMLParser.IfDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#ifProperty}.
	 * @param ctx the parse tree
	 */
	void enterIfProperty(NormMLParser.IfPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#ifProperty}.
	 * @param ctx the parse tree
	 */
	void exitIfProperty(NormMLParser.IfPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#dateDecl}.
	 * @param ctx the parse tree
	 */
	void enterDateDecl(NormMLParser.DateDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#dateDecl}.
	 * @param ctx the parse tree
	 */
	void exitDateDecl(NormMLParser.DateDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionDecl}.
	 * @param ctx the parse tree
	 */
	void enterSanctionDecl(NormMLParser.SanctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionDecl}.
	 * @param ctx the parse tree
	 */
	void exitSanctionDecl(NormMLParser.SanctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionProperty}.
	 * @param ctx the parse tree
	 */
	void enterSanctionProperty(NormMLParser.SanctionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionProperty}.
	 * @param ctx the parse tree
	 */
	void exitSanctionProperty(NormMLParser.SanctionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#conditionDecl}.
	 * @param ctx the parse tree
	 */
	void enterConditionDecl(NormMLParser.ConditionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#conditionDecl}.
	 * @param ctx the parse tree
	 */
	void exitConditionDecl(NormMLParser.ConditionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#conditionBodyProperty}.
	 * @param ctx the parse tree
	 */
	void enterConditionBodyProperty(NormMLParser.ConditionBodyPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#conditionBodyProperty}.
	 * @param ctx the parse tree
	 */
	void exitConditionBodyProperty(NormMLParser.ConditionBodyPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#nameProperty}.
	 * @param ctx the parse tree
	 */
	void enterNameProperty(NormMLParser.NamePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#nameProperty}.
	 * @param ctx the parse tree
	 */
	void exitNameProperty(NormMLParser.NamePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#descriptionProperty}.
	 * @param ctx the parse tree
	 */
	void enterDescriptionProperty(NormMLParser.DescriptionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#descriptionProperty}.
	 * @param ctx the parse tree
	 */
	void exitDescriptionProperty(NormMLParser.DescriptionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#dateValueProperty}.
	 * @param ctx the parse tree
	 */
	void enterDateValueProperty(NormMLParser.DateValuePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#dateValueProperty}.
	 * @param ctx the parse tree
	 */
	void exitDateValueProperty(NormMLParser.DateValuePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#condExprProperty}.
	 * @param ctx the parse tree
	 */
	void enterCondExprProperty(NormMLParser.CondExprPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#condExprProperty}.
	 * @param ctx the parse tree
	 */
	void exitCondExprProperty(NormMLParser.CondExprPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#condLangProperty}.
	 * @param ctx the parse tree
	 */
	void enterCondLangProperty(NormMLParser.CondLangPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#condLangProperty}.
	 * @param ctx the parse tree
	 */
	void exitCondLangProperty(NormMLParser.CondLangPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normTypeProperty}.
	 * @param ctx the parse tree
	 */
	void enterNormTypeProperty(NormMLParser.NormTypePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normTypeProperty}.
	 * @param ctx the parse tree
	 */
	void exitNormTypeProperty(NormMLParser.NormTypePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionTypeProperty}.
	 * @param ctx the parse tree
	 */
	void enterSanctionTypeProperty(NormMLParser.SanctionTypePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionTypeProperty}.
	 * @param ctx the parse tree
	 */
	void exitSanctionTypeProperty(NormMLParser.SanctionTypePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#atomicKindProperty}.
	 * @param ctx the parse tree
	 */
	void enterAtomicKindProperty(NormMLParser.AtomicKindPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#atomicKindProperty}.
	 * @param ctx the parse tree
	 */
	void exitAtomicKindProperty(NormMLParser.AtomicKindPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#compositeKindProperty}.
	 * @param ctx the parse tree
	 */
	void enterCompositeKindProperty(NormMLParser.CompositeKindPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#compositeKindProperty}.
	 * @param ctx the parse tree
	 */
	void exitCompositeKindProperty(NormMLParser.CompositeKindPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normType}.
	 * @param ctx the parse tree
	 */
	void enterNormType(NormMLParser.NormTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normType}.
	 * @param ctx the parse tree
	 */
	void exitNormType(NormMLParser.NormTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionType}.
	 * @param ctx the parse tree
	 */
	void enterSanctionType(NormMLParser.SanctionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionType}.
	 * @param ctx the parse tree
	 */
	void exitSanctionType(NormMLParser.SanctionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#atomicActionKind}.
	 * @param ctx the parse tree
	 */
	void enterAtomicActionKind(NormMLParser.AtomicActionKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#atomicActionKind}.
	 * @param ctx the parse tree
	 */
	void exitAtomicActionKind(NormMLParser.AtomicActionKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#compositeActionKind}.
	 * @param ctx the parse tree
	 */
	void enterCompositeActionKind(NormMLParser.CompositeActionKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#compositeActionKind}.
	 * @param ctx the parse tree
	 */
	void exitCompositeActionKind(NormMLParser.CompositeActionKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#subOrganizationsProperty}.
	 * @param ctx the parse tree
	 */
	void enterSubOrganizationsProperty(NormMLParser.SubOrganizationsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#subOrganizationsProperty}.
	 * @param ctx the parse tree
	 */
	void exitSubOrganizationsProperty(NormMLParser.SubOrganizationsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#parentProperty}.
	 * @param ctx the parse tree
	 */
	void enterParentProperty(NormMLParser.ParentPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#parentProperty}.
	 * @param ctx the parse tree
	 */
	void exitParentProperty(NormMLParser.ParentPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#rolesProperty}.
	 * @param ctx the parse tree
	 */
	void enterRolesProperty(NormMLParser.RolesPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#rolesProperty}.
	 * @param ctx the parse tree
	 */
	void exitRolesProperty(NormMLParser.RolesPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#agentsProperty}.
	 * @param ctx the parse tree
	 */
	void enterAgentsProperty(NormMLParser.AgentsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#agentsProperty}.
	 * @param ctx the parse tree
	 */
	void exitAgentsProperty(NormMLParser.AgentsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#organizationsProperty}.
	 * @param ctx the parse tree
	 */
	void enterOrganizationsProperty(NormMLParser.OrganizationsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#organizationsProperty}.
	 * @param ctx the parse tree
	 */
	void exitOrganizationsProperty(NormMLParser.OrganizationsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#organizationPropertyRef}.
	 * @param ctx the parse tree
	 */
	void enterOrganizationPropertyRef(NormMLParser.OrganizationPropertyRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#organizationPropertyRef}.
	 * @param ctx the parse tree
	 */
	void exitOrganizationPropertyRef(NormMLParser.OrganizationPropertyRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#playersProperty}.
	 * @param ctx the parse tree
	 */
	void enterPlayersProperty(NormMLParser.PlayersPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#playersProperty}.
	 * @param ctx the parse tree
	 */
	void exitPlayersProperty(NormMLParser.PlayersPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#playsProperty}.
	 * @param ctx the parse tree
	 */
	void enterPlaysProperty(NormMLParser.PlaysPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#playsProperty}.
	 * @param ctx the parse tree
	 */
	void exitPlaysProperty(NormMLParser.PlaysPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#resourcesProperty}.
	 * @param ctx the parse tree
	 */
	void enterResourcesProperty(NormMLParser.ResourcesPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#resourcesProperty}.
	 * @param ctx the parse tree
	 */
	void exitResourcesProperty(NormMLParser.ResourcesPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#actionsProperty}.
	 * @param ctx the parse tree
	 */
	void enterActionsProperty(NormMLParser.ActionsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#actionsProperty}.
	 * @param ctx the parse tree
	 */
	void exitActionsProperty(NormMLParser.ActionsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#dataTypeProperty}.
	 * @param ctx the parse tree
	 */
	void enterDataTypeProperty(NormMLParser.DataTypePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#dataTypeProperty}.
	 * @param ctx the parse tree
	 */
	void exitDataTypeProperty(NormMLParser.DataTypePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#resourceProperty}.
	 * @param ctx the parse tree
	 */
	void enterResourceProperty(NormMLParser.ResourcePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#resourceProperty}.
	 * @param ctx the parse tree
	 */
	void exitResourceProperty(NormMLParser.ResourcePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normsProperty}.
	 * @param ctx the parse tree
	 */
	void enterNormsProperty(NormMLParser.NormsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normsProperty}.
	 * @param ctx the parse tree
	 */
	void exitNormsProperty(NormMLParser.NormsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#conditionProperty}.
	 * @param ctx the parse tree
	 */
	void enterConditionProperty(NormMLParser.ConditionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#conditionProperty}.
	 * @param ctx the parse tree
	 */
	void exitConditionProperty(NormMLParser.ConditionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#subordinateActionsProperty}.
	 * @param ctx the parse tree
	 */
	void enterSubordinateActionsProperty(NormMLParser.SubordinateActionsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#subordinateActionsProperty}.
	 * @param ctx the parse tree
	 */
	void exitSubordinateActionsProperty(NormMLParser.SubordinateActionsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#accessProperty}.
	 * @param ctx the parse tree
	 */
	void enterAccessProperty(NormMLParser.AccessPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#accessProperty}.
	 * @param ctx the parse tree
	 */
	void exitAccessProperty(NormMLParser.AccessPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#constraintsProperty}.
	 * @param ctx the parse tree
	 */
	void enterConstraintsProperty(NormMLParser.ConstraintsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#constraintsProperty}.
	 * @param ctx the parse tree
	 */
	void exitConstraintsProperty(NormMLParser.ConstraintsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionsProperty}.
	 * @param ctx the parse tree
	 */
	void enterSanctionsProperty(NormMLParser.SanctionsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionsProperty}.
	 * @param ctx the parse tree
	 */
	void exitSanctionsProperty(NormMLParser.SanctionsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#activatedByProperty}.
	 * @param ctx the parse tree
	 */
	void enterActivatedByProperty(NormMLParser.ActivatedByPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#activatedByProperty}.
	 * @param ctx the parse tree
	 */
	void exitActivatedByProperty(NormMLParser.ActivatedByPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#normPropertyRef}.
	 * @param ctx the parse tree
	 */
	void enterNormPropertyRef(NormMLParser.NormPropertyRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#normPropertyRef}.
	 * @param ctx the parse tree
	 */
	void exitNormPropertyRef(NormMLParser.NormPropertyRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#datesProperty}.
	 * @param ctx the parse tree
	 */
	void enterDatesProperty(NormMLParser.DatesPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#datesProperty}.
	 * @param ctx the parse tree
	 */
	void exitDatesProperty(NormMLParser.DatesPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#beforeActionsProperty}.
	 * @param ctx the parse tree
	 */
	void enterBeforeActionsProperty(NormMLParser.BeforeActionsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#beforeActionsProperty}.
	 * @param ctx the parse tree
	 */
	void exitBeforeActionsProperty(NormMLParser.BeforeActionsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#afterActionsProperty}.
	 * @param ctx the parse tree
	 */
	void enterAfterActionsProperty(NormMLParser.AfterActionsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#afterActionsProperty}.
	 * @param ctx the parse tree
	 */
	void exitAfterActionsProperty(NormMLParser.AfterActionsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#startDateProperty}.
	 * @param ctx the parse tree
	 */
	void enterStartDateProperty(NormMLParser.StartDatePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#startDateProperty}.
	 * @param ctx the parse tree
	 */
	void exitStartDateProperty(NormMLParser.StartDatePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#endDateProperty}.
	 * @param ctx the parse tree
	 */
	void enterEndDateProperty(NormMLParser.EndDatePropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#endDateProperty}.
	 * @param ctx the parse tree
	 */
	void exitEndDateProperty(NormMLParser.EndDatePropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#sanctionedNormsProperty}.
	 * @param ctx the parse tree
	 */
	void enterSanctionedNormsProperty(NormMLParser.SanctionedNormsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#sanctionedNormsProperty}.
	 * @param ctx the parse tree
	 */
	void exitSanctionedNormsProperty(NormMLParser.SanctionedNormsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#activatedNormsProperty}.
	 * @param ctx the parse tree
	 */
	void enterActivatedNormsProperty(NormMLParser.ActivatedNormsPropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#activatedNormsProperty}.
	 * @param ctx the parse tree
	 */
	void exitActivatedNormsProperty(NormMLParser.ActivatedNormsPropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(NormMLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(NormMLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link NormMLParser#referenceList}.
	 * @param ctx the parse tree
	 */
	void enterReferenceList(NormMLParser.ReferenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link NormMLParser#referenceList}.
	 * @param ctx the parse tree
	 */
	void exitReferenceList(NormMLParser.ReferenceListContext ctx);
}