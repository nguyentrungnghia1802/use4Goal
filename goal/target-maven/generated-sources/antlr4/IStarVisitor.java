// Generated from IStar.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.istar.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IStarParser#model}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModel(IStarParser.ModelContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#modelStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModelStatement(IStarParser.ModelStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#actorDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActorDef(IStarParser.ActorDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#actorKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActorKind(IStarParser.ActorKindContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyGoal}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyGoal(IStarParser.BodyGoalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyTask}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyTask(IStarParser.BodyTaskContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyResource}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyResource(IStarParser.BodyResourceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyQuality}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyQuality(IStarParser.BodyQualityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyIsA}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyIsA(IStarParser.BodyIsAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bodyParticipates}
	 * labeled alternative in {@link IStarParser#actorBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBodyParticipates(IStarParser.BodyParticipatesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assocIsA}
	 * labeled alternative in {@link IStarParser#actorAssociationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocIsA(IStarParser.AssocIsAContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assocParticipatesIn}
	 * labeled alternative in {@link IStarParser#actorAssociationStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssocParticipatesIn(IStarParser.AssocParticipatesInContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#goalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalType(IStarParser.GoalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#goalTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalTypeName(IStarParser.GoalTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#descProperty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescProperty(IStarParser.DescPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relAnd}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelAnd(IStarParser.RelAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relOr}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelOr(IStarParser.RelOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relForAll}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelForAll(IStarParser.RelForAllContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relPick}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelPick(IStarParser.RelPickContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relContribute}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelContribute(IStarParser.RelContributeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relQualifies}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelQualifies(IStarParser.RelQualifiesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relNeededBy}
	 * labeled alternative in {@link IStarParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelNeededBy(IStarParser.RelNeededByContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#dependency}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependency(IStarParser.DependencyContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#dependumRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependumRef(IStarParser.DependumRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#dependumKind}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDependumKind(IStarParser.DependumKindContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#depEnd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDepEnd(IStarParser.DepEndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctMake}
	 * labeled alternative in {@link IStarParser#contribType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtMake(IStarParser.CtMakeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctHelp}
	 * labeled alternative in {@link IStarParser#contribType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtHelp(IStarParser.CtHelpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctHurt}
	 * labeled alternative in {@link IStarParser#contribType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtHurt(IStarParser.CtHurtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ctBreak}
	 * labeled alternative in {@link IStarParser#contribType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCtBreak(IStarParser.CtBreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#oclCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOclCondition(IStarParser.OclConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#goalCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoalCondition(IStarParser.GoalConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#activationClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActivationClause(IStarParser.ActivationClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#condLang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondLang(IStarParser.CondLangContext ctx);
	/**
	 * Visit a parse tree produced by {@link IStarParser#stringLit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(IStarParser.StringLitContext ctx);
}