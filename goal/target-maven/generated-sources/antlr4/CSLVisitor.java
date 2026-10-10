// Generated from CSL.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.csl.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSLParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(CSLParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#topLevelDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDecl(CSLParser.TopLevelDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#enumDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumDecl(CSLParser.EnumDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#datatypeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDatatypeDecl(CSLParser.DatatypeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#entityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityDecl(CSLParser.EntityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#roleDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRoleDecl(CSLParser.RoleDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#specializesClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecializesClause(CSLParser.SpecializesClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#orgContextDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrgContextDecl(CSLParser.OrgContextDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#orgContextItem}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrgContextItem(CSLParser.OrgContextItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#attributeBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeBlock(CSLParser.AttributeBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#attributeDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeDecl(CSLParser.AttributeDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#attributeModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeModifier(CSLParser.AttributeModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(CSLParser.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#defaultValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultValue(CSLParser.DefaultValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#entityRelationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityRelationDecl(CSLParser.EntityRelationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#relationKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationKind(CSLParser.RelationKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#endpointDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndpointDecl(CSLParser.EndpointDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#compatibilityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompatibilityDecl(CSLParser.CompatibilityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#cardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCardinality(CSLParser.CardinalityContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#invariantDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantDecl(CSLParser.InvariantDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#oclExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOclExpression(CSLParser.OclExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#oclToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOclToken(CSLParser.OclTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSLParser#oclKeyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOclKeyword(CSLParser.OclKeywordContext ctx);
}