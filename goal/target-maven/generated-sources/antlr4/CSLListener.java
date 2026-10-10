// Generated from CSL.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.csl.parser; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSLParser}.
 */
public interface CSLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSLParser#model}.
	 * @param ctx the parse tree
	 */
	void enterModel(CSLParser.ModelContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#model}.
	 * @param ctx the parse tree
	 */
	void exitModel(CSLParser.ModelContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void enterTopLevelDecl(CSLParser.TopLevelDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#topLevelDecl}.
	 * @param ctx the parse tree
	 */
	void exitTopLevelDecl(CSLParser.TopLevelDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumDecl(CSLParser.EnumDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#enumDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumDecl(CSLParser.EnumDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#datatypeDecl}.
	 * @param ctx the parse tree
	 */
	void enterDatatypeDecl(CSLParser.DatatypeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#datatypeDecl}.
	 * @param ctx the parse tree
	 */
	void exitDatatypeDecl(CSLParser.DatatypeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityDecl(CSLParser.EntityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityDecl(CSLParser.EntityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#roleDecl}.
	 * @param ctx the parse tree
	 */
	void enterRoleDecl(CSLParser.RoleDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#roleDecl}.
	 * @param ctx the parse tree
	 */
	void exitRoleDecl(CSLParser.RoleDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#specializesClause}.
	 * @param ctx the parse tree
	 */
	void enterSpecializesClause(CSLParser.SpecializesClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#specializesClause}.
	 * @param ctx the parse tree
	 */
	void exitSpecializesClause(CSLParser.SpecializesClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#orgContextDecl}.
	 * @param ctx the parse tree
	 */
	void enterOrgContextDecl(CSLParser.OrgContextDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#orgContextDecl}.
	 * @param ctx the parse tree
	 */
	void exitOrgContextDecl(CSLParser.OrgContextDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#orgContextItem}.
	 * @param ctx the parse tree
	 */
	void enterOrgContextItem(CSLParser.OrgContextItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#orgContextItem}.
	 * @param ctx the parse tree
	 */
	void exitOrgContextItem(CSLParser.OrgContextItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#attributeBlock}.
	 * @param ctx the parse tree
	 */
	void enterAttributeBlock(CSLParser.AttributeBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#attributeBlock}.
	 * @param ctx the parse tree
	 */
	void exitAttributeBlock(CSLParser.AttributeBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#attributeDecl}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDecl(CSLParser.AttributeDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#attributeDecl}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDecl(CSLParser.AttributeDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void enterAttributeModifier(CSLParser.AttributeModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void exitAttributeModifier(CSLParser.AttributeModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(CSLParser.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(CSLParser.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(CSLParser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(CSLParser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#entityRelationDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityRelationDecl(CSLParser.EntityRelationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#entityRelationDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityRelationDecl(CSLParser.EntityRelationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#relationKind}.
	 * @param ctx the parse tree
	 */
	void enterRelationKind(CSLParser.RelationKindContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#relationKind}.
	 * @param ctx the parse tree
	 */
	void exitRelationKind(CSLParser.RelationKindContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#endpointDecl}.
	 * @param ctx the parse tree
	 */
	void enterEndpointDecl(CSLParser.EndpointDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#endpointDecl}.
	 * @param ctx the parse tree
	 */
	void exitEndpointDecl(CSLParser.EndpointDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#compatibilityDecl}.
	 * @param ctx the parse tree
	 */
	void enterCompatibilityDecl(CSLParser.CompatibilityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#compatibilityDecl}.
	 * @param ctx the parse tree
	 */
	void exitCompatibilityDecl(CSLParser.CompatibilityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void enterCardinality(CSLParser.CardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#cardinality}.
	 * @param ctx the parse tree
	 */
	void exitCardinality(CSLParser.CardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#invariantDecl}.
	 * @param ctx the parse tree
	 */
	void enterInvariantDecl(CSLParser.InvariantDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#invariantDecl}.
	 * @param ctx the parse tree
	 */
	void exitInvariantDecl(CSLParser.InvariantDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#oclExpression}.
	 * @param ctx the parse tree
	 */
	void enterOclExpression(CSLParser.OclExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#oclExpression}.
	 * @param ctx the parse tree
	 */
	void exitOclExpression(CSLParser.OclExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#oclToken}.
	 * @param ctx the parse tree
	 */
	void enterOclToken(CSLParser.OclTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#oclToken}.
	 * @param ctx the parse tree
	 */
	void exitOclToken(CSLParser.OclTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSLParser#oclKeyword}.
	 * @param ctx the parse tree
	 */
	void enterOclKeyword(CSLParser.OclKeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSLParser#oclKeyword}.
	 * @param ctx the parse tree
	 */
	void exitOclKeyword(CSLParser.OclKeywordContext ctx);
}