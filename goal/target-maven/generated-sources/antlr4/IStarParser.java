// Generated from IStar.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.istar.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, OCL_CLAUSE=36, OCL_BLOCK=37, STRING=38, 
		IDENT=39, WS=40, LINE_COMMENT=41, BLOCK_COMMENT=42;
	public static final int
		RULE_model = 0, RULE_modelStatement = 1, RULE_actorDef = 2, RULE_actorKind = 3, 
		RULE_actorBody = 4, RULE_actorAssociationStmt = 5, RULE_goalType = 6, 
		RULE_goalTypeName = 7, RULE_descProperty = 8, RULE_rel = 9, RULE_dependency = 10, 
		RULE_dependumRef = 11, RULE_dependumKind = 12, RULE_depEnd = 13, RULE_contribType = 14, 
		RULE_oclCondition = 15, RULE_goalCondition = 16, RULE_activationClause = 17, 
		RULE_condLang = 18, RULE_stringLit = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"model", "modelStatement", "actorDef", "actorKind", "actorBody", "actorAssociationStmt", 
			"goalType", "goalTypeName", "descProperty", "rel", "dependency", "dependumRef", 
			"dependumKind", "depEnd", "contribType", "oclCondition", "goalCondition", 
			"activationClause", "condLang", "stringLit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'istar'", "'{'", "'}'", "'role'", "'agent'", "'goal'", "'task'", 
			"'resource'", "'quality'", "'is-a'", "'participates-in'", "':'", "'Achieve'", 
			"'Maintain'", "'Sustain'", "'None'", "'description'", "'>'", "'or'", 
			"'forall'", "'pick'", "'qualifies'", "'needed-by'", "'depend'", "'->'", 
			"'.'", "'make'", "'help'", "'hurt'", "'break'", "'pre'", "'post'", "'condition'", 
			"'activation'", "'lang'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"OCL_CLAUSE", "OCL_BLOCK", "STRING", "IDENT", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModelContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public TerminalNode EOF() { return getToken(IStarParser.EOF, 0); }
		public StringLitContext stringLit() {
			return getRuleContext(StringLitContext.class,0);
		}
		public List<ActorDefContext> actorDef() {
			return getRuleContexts(ActorDefContext.class);
		}
		public ActorDefContext actorDef(int i) {
			return getRuleContext(ActorDefContext.class,i);
		}
		public List<ModelStatementContext> modelStatement() {
			return getRuleContexts(ModelStatementContext.class);
		}
		public ModelStatementContext modelStatement(int i) {
			return getRuleContext(ModelStatementContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitModel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelContext model() throws RecognitionException {
		ModelContext _localctx = new ModelContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_model);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(T__0);
			setState(41);
			match(IDENT);
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(42);
				stringLit();
				}
			}

			setState(45);
			match(T__1);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(46);
				actorDef();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__9) | (1L << T__10) | (1L << T__23))) != 0)) {
				{
				{
				setState(52);
				modelStatement();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__2);
			setState(59);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelStatementContext extends ParserRuleContext {
		public DependencyContext dependency() {
			return getRuleContext(DependencyContext.class,0);
		}
		public ActorAssociationStmtContext actorAssociationStmt() {
			return getRuleContext(ActorAssociationStmtContext.class,0);
		}
		public ModelStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterModelStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitModelStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitModelStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModelStatementContext modelStatement() throws RecognitionException {
		ModelStatementContext _localctx = new ModelStatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_modelStatement);
		try {
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				dependency();
				}
				break;
			case T__9:
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				actorAssociationStmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorDefContext extends ParserRuleContext {
		public ActorKindContext actorKind() {
			return getRuleContext(ActorKindContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public StringLitContext stringLit() {
			return getRuleContext(StringLitContext.class,0);
		}
		public List<ActorBodyContext> actorBody() {
			return getRuleContexts(ActorBodyContext.class);
		}
		public ActorBodyContext actorBody(int i) {
			return getRuleContext(ActorBodyContext.class,i);
		}
		public ActorDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterActorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitActorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitActorDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActorDefContext actorDef() throws RecognitionException {
		ActorDefContext _localctx = new ActorDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_actorDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			actorKind();
			setState(66);
			match(IDENT);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING) {
				{
				setState(67);
				stringLit();
				}
			}

			setState(70);
			match(T__1);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << IDENT))) != 0)) {
				{
				{
				setState(71);
				actorBody();
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorKindContext extends ParserRuleContext {
		public ActorKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterActorKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitActorKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitActorKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActorKindContext actorKind() throws RecognitionException {
		ActorKindContext _localctx = new ActorKindContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_actorKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__4) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorBodyContext extends ParserRuleContext {
		public ActorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorBody; }
	 
		public ActorBodyContext() { }
		public void copyFrom(ActorBodyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BodyIsAContext extends ActorBodyContext {
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public BodyIsAContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyIsA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyIsA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyIsA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BodyParticipatesContext extends ActorBodyContext {
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public BodyParticipatesContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyParticipates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyParticipates(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyParticipates(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BodyGoalContext extends ActorBodyContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public GoalTypeContext goalType() {
			return getRuleContext(GoalTypeContext.class,0);
		}
		public DescPropertyContext descProperty() {
			return getRuleContext(DescPropertyContext.class,0);
		}
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public List<GoalConditionContext> goalCondition() {
			return getRuleContexts(GoalConditionContext.class);
		}
		public GoalConditionContext goalCondition(int i) {
			return getRuleContext(GoalConditionContext.class,i);
		}
		public ActivationClauseContext activationClause() {
			return getRuleContext(ActivationClauseContext.class,0);
		}
		public BodyGoalContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyGoal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyGoal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BodyResourceContext extends ActorBodyContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public DescPropertyContext descProperty() {
			return getRuleContext(DescPropertyContext.class,0);
		}
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public BodyResourceContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyResource(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyResource(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BodyQualityContext extends ActorBodyContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public DescPropertyContext descProperty() {
			return getRuleContext(DescPropertyContext.class,0);
		}
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public BodyQualityContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyQuality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyQuality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyQuality(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BodyTaskContext extends ActorBodyContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public DescPropertyContext descProperty() {
			return getRuleContext(DescPropertyContext.class,0);
		}
		public List<RelContext> rel() {
			return getRuleContexts(RelContext.class);
		}
		public RelContext rel(int i) {
			return getRuleContext(RelContext.class,i);
		}
		public List<OclConditionContext> oclCondition() {
			return getRuleContexts(OclConditionContext.class);
		}
		public OclConditionContext oclCondition(int i) {
			return getRuleContext(OclConditionContext.class,i);
		}
		public BodyTaskContext(ActorBodyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterBodyTask(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitBodyTask(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitBodyTask(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActorBodyContext actorBody() throws RecognitionException {
		ActorBodyContext _localctx = new ActorBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_actorBody);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new BodyGoalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__5);
				setState(82);
				match(IDENT);
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__11) {
					{
					setState(83);
					goalType();
					}
				}

				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(86);
					descProperty();
					}
				}

				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(89);
					rel();
					}
					}
					setState(94);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__32 || _la==OCL_CLAUSE) {
					{
					{
					setState(95);
					goalCondition();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__33) {
					{
					setState(101);
					activationClause();
					}
				}

				}
				break;
			case 2:
				_localctx = new BodyTaskContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(T__6);
				setState(105);
				match(IDENT);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(106);
					descProperty();
					}
				}

				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(109);
					rel();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__31) | (1L << OCL_CLAUSE))) != 0)) {
					{
					{
					setState(115);
					oclCondition();
					}
					}
					setState(120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 3:
				_localctx = new BodyResourceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				match(T__7);
				setState(122);
				match(IDENT);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(123);
					descProperty();
					}
				}

				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(126);
					rel();
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 4:
				_localctx = new BodyQualityContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
				match(T__8);
				setState(133);
				match(IDENT);
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(134);
					descProperty();
					}
				}

				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__17) {
					{
					{
					setState(137);
					rel();
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 5:
				_localctx = new BodyIsAContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				match(IDENT);
				setState(144);
				match(T__9);
				setState(145);
				match(IDENT);
				}
				break;
			case 6:
				_localctx = new BodyParticipatesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				match(IDENT);
				setState(147);
				match(T__10);
				setState(148);
				match(IDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActorAssociationStmtContext extends ParserRuleContext {
		public ActorAssociationStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actorAssociationStmt; }
	 
		public ActorAssociationStmtContext() { }
		public void copyFrom(ActorAssociationStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssocIsAContext extends ActorAssociationStmtContext {
		public Token source;
		public Token parent;
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public AssocIsAContext(ActorAssociationStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterAssocIsA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitAssocIsA(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitAssocIsA(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssocParticipatesInContext extends ActorAssociationStmtContext {
		public Token agent;
		public Token role;
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public AssocParticipatesInContext(ActorAssociationStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterAssocParticipatesIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitAssocParticipatesIn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitAssocParticipatesIn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActorAssociationStmtContext actorAssociationStmt() throws RecognitionException {
		ActorAssociationStmtContext _localctx = new ActorAssociationStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_actorAssociationStmt);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				_localctx = new AssocIsAContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				match(T__9);
				setState(152);
				((AssocIsAContext)_localctx).source = match(IDENT);
				setState(153);
				((AssocIsAContext)_localctx).parent = match(IDENT);
				}
				break;
			case T__10:
				_localctx = new AssocParticipatesInContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(154);
				match(T__10);
				setState(155);
				((AssocParticipatesInContext)_localctx).agent = match(IDENT);
				setState(156);
				((AssocParticipatesInContext)_localctx).role = match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GoalTypeContext extends ParserRuleContext {
		public GoalTypeNameContext goalTypeName() {
			return getRuleContext(GoalTypeNameContext.class,0);
		}
		public GoalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterGoalType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitGoalType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitGoalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalTypeContext goalType() throws RecognitionException {
		GoalTypeContext _localctx = new GoalTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_goalType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__11);
			setState(160);
			goalTypeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GoalTypeNameContext extends ParserRuleContext {
		public GoalTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterGoalTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitGoalTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitGoalTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalTypeNameContext goalTypeName() throws RecognitionException {
		GoalTypeNameContext _localctx = new GoalTypeNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_goalTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescPropertyContext extends ParserRuleContext {
		public StringLitContext stringLit() {
			return getRuleContext(StringLitContext.class,0);
		}
		public DescPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterDescProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitDescProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitDescProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescPropertyContext descProperty() throws RecognitionException {
		DescPropertyContext _localctx = new DescPropertyContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_descProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			match(T__16);
			setState(165);
			stringLit();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelContext extends ParserRuleContext {
		public RelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel; }
	 
		public RelContext() { }
		public void copyFrom(RelContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelQualifiesContext extends RelContext {
		public Token target;
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public RelQualifiesContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelQualifies(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelQualifies(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelQualifies(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelForAllContext extends RelContext {
		public Token param;
		public Token target;
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public RelForAllContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelForAll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelForAll(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelForAll(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelAndContext extends RelContext {
		public Token target;
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public RelAndContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelContributeContext extends RelContext {
		public Token target;
		public ContribTypeContext contribType() {
			return getRuleContext(ContribTypeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public RelContributeContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelContribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelContribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelContribute(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelOrContext extends RelContext {
		public Token target;
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public RelOrContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelOr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelPickContext extends RelContext {
		public Token param;
		public Token target;
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public RelPickContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelPick(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelPick(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelPick(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelNeededByContext extends RelContext {
		public Token target;
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public RelNeededByContext(RelContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterRelNeededBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitRelNeededBy(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitRelNeededBy(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelContext rel() throws RecognitionException {
		RelContext _localctx = new RelContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rel);
		try {
			setState(190);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new RelAndContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				match(T__17);
				setState(168);
				((RelAndContext)_localctx).target = match(IDENT);
				}
				break;
			case 2:
				_localctx = new RelOrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				match(T__17);
				setState(170);
				match(T__18);
				setState(171);
				((RelOrContext)_localctx).target = match(IDENT);
				}
				break;
			case 3:
				_localctx = new RelForAllContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				match(T__17);
				setState(173);
				match(T__19);
				setState(174);
				((RelForAllContext)_localctx).param = match(IDENT);
				setState(175);
				((RelForAllContext)_localctx).target = match(IDENT);
				}
				break;
			case 4:
				_localctx = new RelPickContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(176);
				match(T__17);
				setState(177);
				match(T__20);
				setState(178);
				((RelPickContext)_localctx).param = match(IDENT);
				setState(179);
				((RelPickContext)_localctx).target = match(IDENT);
				}
				break;
			case 5:
				_localctx = new RelContributeContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				match(T__17);
				setState(181);
				contribType();
				setState(182);
				((RelContributeContext)_localctx).target = match(IDENT);
				}
				break;
			case 6:
				_localctx = new RelQualifiesContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(184);
				match(T__17);
				setState(185);
				match(T__21);
				setState(186);
				((RelQualifiesContext)_localctx).target = match(IDENT);
				}
				break;
			case 7:
				_localctx = new RelNeededByContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(187);
				match(T__17);
				setState(188);
				match(T__22);
				setState(189);
				((RelNeededByContext)_localctx).target = match(IDENT);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DependencyContext extends ParserRuleContext {
		public List<DepEndContext> depEnd() {
			return getRuleContexts(DepEndContext.class);
		}
		public DepEndContext depEnd(int i) {
			return getRuleContext(DepEndContext.class,i);
		}
		public DependumRefContext dependumRef() {
			return getRuleContext(DependumRefContext.class,0);
		}
		public DependencyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependency; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterDependency(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitDependency(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitDependency(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependencyContext dependency() throws RecognitionException {
		DependencyContext _localctx = new DependencyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_dependency);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(T__23);
			setState(193);
			depEnd();
			setState(194);
			match(T__24);
			setState(195);
			dependumRef();
			setState(196);
			match(T__24);
			setState(197);
			depEnd();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DependumRefContext extends ParserRuleContext {
		public DependumKindContext dependumKind() {
			return getRuleContext(DependumKindContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public DependumRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependumRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterDependumRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitDependumRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitDependumRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependumRefContext dependumRef() throws RecognitionException {
		DependumRefContext _localctx = new DependumRefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_dependumRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			dependumKind();
			setState(200);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DependumKindContext extends ParserRuleContext {
		public DependumKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dependumKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterDependumKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitDependumKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitDependumKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DependumKindContext dependumKind() throws RecognitionException {
		DependumKindContext _localctx = new DependumKindContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dependumKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DepEndContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(IStarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(IStarParser.IDENT, i);
		}
		public DepEndContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_depEnd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterDepEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitDepEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitDepEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DepEndContext depEnd() throws RecognitionException {
		DepEndContext _localctx = new DepEndContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_depEnd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(IDENT);
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(205);
				match(T__25);
				setState(206);
				match(IDENT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContribTypeContext extends ParserRuleContext {
		public ContribTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contribType; }
	 
		public ContribTypeContext() { }
		public void copyFrom(ContribTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CtHurtContext extends ContribTypeContext {
		public CtHurtContext(ContribTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterCtHurt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitCtHurt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitCtHurt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtHelpContext extends ContribTypeContext {
		public CtHelpContext(ContribTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterCtHelp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitCtHelp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitCtHelp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtMakeContext extends ContribTypeContext {
		public CtMakeContext(ContribTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterCtMake(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitCtMake(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitCtMake(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CtBreakContext extends ContribTypeContext {
		public CtBreakContext(ContribTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterCtBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitCtBreak(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitCtBreak(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContribTypeContext contribType() throws RecognitionException {
		ContribTypeContext _localctx = new ContribTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_contribType);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__26:
				_localctx = new CtMakeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(209);
				match(T__26);
				}
				break;
			case T__27:
				_localctx = new CtHelpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(210);
				match(T__27);
				}
				break;
			case T__28:
				_localctx = new CtHurtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(211);
				match(T__28);
				}
				break;
			case T__29:
				_localctx = new CtBreakContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(212);
				match(T__29);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OclConditionContext extends ParserRuleContext {
		public TerminalNode OCL_BLOCK() { return getToken(IStarParser.OCL_BLOCK, 0); }
		public CondLangContext condLang() {
			return getRuleContext(CondLangContext.class,0);
		}
		public TerminalNode OCL_CLAUSE() { return getToken(IStarParser.OCL_CLAUSE, 0); }
		public OclConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oclCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterOclCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitOclCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitOclCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OclConditionContext oclCondition() throws RecognitionException {
		OclConditionContext _localctx = new OclConditionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_oclCondition);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
			case T__31:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				_la = _input.LA(1);
				if ( !(_la==T__30 || _la==T__31) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__34) {
					{
					setState(216);
					condLang();
					}
				}

				setState(219);
				match(OCL_BLOCK);
				}
				break;
			case OCL_CLAUSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(OCL_CLAUSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GoalConditionContext extends ParserRuleContext {
		public TerminalNode OCL_BLOCK() { return getToken(IStarParser.OCL_BLOCK, 0); }
		public CondLangContext condLang() {
			return getRuleContext(CondLangContext.class,0);
		}
		public TerminalNode OCL_CLAUSE() { return getToken(IStarParser.OCL_CLAUSE, 0); }
		public GoalConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_goalCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterGoalCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitGoalCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitGoalCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GoalConditionContext goalCondition() throws RecognitionException {
		GoalConditionContext _localctx = new GoalConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_goalCondition);
		int _la;
		try {
			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				match(T__32);
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__34) {
					{
					setState(224);
					condLang();
					}
				}

				setState(227);
				match(OCL_BLOCK);
				}
				break;
			case OCL_CLAUSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(OCL_CLAUSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ActivationClauseContext extends ParserRuleContext {
		public TerminalNode OCL_BLOCK() { return getToken(IStarParser.OCL_BLOCK, 0); }
		public CondLangContext condLang() {
			return getRuleContext(CondLangContext.class,0);
		}
		public ActivationClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activationClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterActivationClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitActivationClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitActivationClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActivationClauseContext activationClause() throws RecognitionException {
		ActivationClauseContext _localctx = new ActivationClauseContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_activationClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(T__33);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__34) {
				{
				setState(232);
				condLang();
				}
			}

			setState(235);
			match(OCL_BLOCK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CondLangContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(IStarParser.IDENT, 0); }
		public CondLangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condLang; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterCondLang(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitCondLang(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitCondLang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondLangContext condLang() throws RecognitionException {
		CondLangContext _localctx = new CondLangContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_condLang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237);
			match(T__34);
			setState(238);
			match(IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringLitContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(IStarParser.STRING, 0); }
		public StringLitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).enterStringLit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IStarListener ) ((IStarListener)listener).exitStringLit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IStarVisitor ) return ((IStarVisitor<? extends T>)visitor).visitStringLit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLitContext stringLit() throws RecognitionException {
		StringLitContext _localctx = new StringLitContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_stringLit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u00f5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\5\2.\n\2\3\2\3\2\7\2\62\n\2"+
		"\f\2\16\2\65\13\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\2\3\2\3\2\3\3\3\3\5\3"+
		"B\n\3\3\4\3\4\3\4\5\4G\n\4\3\4\3\4\7\4K\n\4\f\4\16\4N\13\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\5\6W\n\6\3\6\5\6Z\n\6\3\6\7\6]\n\6\f\6\16\6`\13\6\3\6"+
		"\7\6c\n\6\f\6\16\6f\13\6\3\6\5\6i\n\6\3\6\3\6\3\6\5\6n\n\6\3\6\7\6q\n"+
		"\6\f\6\16\6t\13\6\3\6\7\6w\n\6\f\6\16\6z\13\6\3\6\3\6\3\6\5\6\177\n\6"+
		"\3\6\7\6\u0082\n\6\f\6\16\6\u0085\13\6\3\6\3\6\3\6\5\6\u008a\n\6\3\6\7"+
		"\6\u008d\n\6\f\6\16\6\u0090\13\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0098\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00a0\n\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00c1\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\5\17\u00d2\n"+
		"\17\3\20\3\20\3\20\3\20\5\20\u00d8\n\20\3\21\3\21\5\21\u00dc\n\21\3\21"+
		"\3\21\5\21\u00e0\n\21\3\22\3\22\5\22\u00e4\n\22\3\22\3\22\5\22\u00e8\n"+
		"\22\3\23\3\23\5\23\u00ec\n\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2\6\3\2\6\7\3\2\17"+
		"\22\3\2\b\13\3\2!\"\2\u0107\2*\3\2\2\2\4A\3\2\2\2\6C\3\2\2\2\bQ\3\2\2"+
		"\2\n\u0097\3\2\2\2\f\u009f\3\2\2\2\16\u00a1\3\2\2\2\20\u00a4\3\2\2\2\22"+
		"\u00a6\3\2\2\2\24\u00c0\3\2\2\2\26\u00c2\3\2\2\2\30\u00c9\3\2\2\2\32\u00cc"+
		"\3\2\2\2\34\u00ce\3\2\2\2\36\u00d7\3\2\2\2 \u00df\3\2\2\2\"\u00e7\3\2"+
		"\2\2$\u00e9\3\2\2\2&\u00ef\3\2\2\2(\u00f2\3\2\2\2*+\7\3\2\2+-\7)\2\2,"+
		".\5(\25\2-,\3\2\2\2-.\3\2\2\2./\3\2\2\2/\63\7\4\2\2\60\62\5\6\4\2\61\60"+
		"\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\649\3\2\2\2\65\63\3"+
		"\2\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2"+
		"\2\2;9\3\2\2\2<=\7\5\2\2=>\7\2\2\3>\3\3\2\2\2?B\5\26\f\2@B\5\f\7\2A?\3"+
		"\2\2\2A@\3\2\2\2B\5\3\2\2\2CD\5\b\5\2DF\7)\2\2EG\5(\25\2FE\3\2\2\2FG\3"+
		"\2\2\2GH\3\2\2\2HL\7\4\2\2IK\5\n\6\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3"+
		"\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\5\2\2P\7\3\2\2\2QR\t\2\2\2R\t\3\2\2\2S"+
		"T\7\b\2\2TV\7)\2\2UW\5\16\b\2VU\3\2\2\2VW\3\2\2\2WY\3\2\2\2XZ\5\22\n\2"+
		"YX\3\2\2\2YZ\3\2\2\2Z^\3\2\2\2[]\5\24\13\2\\[\3\2\2\2]`\3\2\2\2^\\\3\2"+
		"\2\2^_\3\2\2\2_d\3\2\2\2`^\3\2\2\2ac\5\"\22\2ba\3\2\2\2cf\3\2\2\2db\3"+
		"\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2\2gi\5$\23\2hg\3\2\2\2hi\3\2\2\2i\u0098"+
		"\3\2\2\2jk\7\t\2\2km\7)\2\2ln\5\22\n\2ml\3\2\2\2mn\3\2\2\2nr\3\2\2\2o"+
		"q\5\24\13\2po\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2sx\3\2\2\2tr\3\2\2"+
		"\2uw\5 \21\2vu\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y\u0098\3\2\2\2zx"+
		"\3\2\2\2{|\7\n\2\2|~\7)\2\2}\177\5\22\n\2~}\3\2\2\2~\177\3\2\2\2\177\u0083"+
		"\3\2\2\2\u0080\u0082\5\24\13\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2\2\2"+
		"\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0098\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0087\7\13\2\2\u0087\u0089\7)\2\2\u0088\u008a\5\22\n\2"+
		"\u0089\u0088\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008e\3\2\2\2\u008b\u008d"+
		"\5\24\13\2\u008c\u008b\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2"+
		"\u008e\u008f\3\2\2\2\u008f\u0098\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092"+
		"\7)\2\2\u0092\u0093\7\f\2\2\u0093\u0098\7)\2\2\u0094\u0095\7)\2\2\u0095"+
		"\u0096\7\r\2\2\u0096\u0098\7)\2\2\u0097S\3\2\2\2\u0097j\3\2\2\2\u0097"+
		"{\3\2\2\2\u0097\u0086\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0094\3\2\2\2"+
		"\u0098\13\3\2\2\2\u0099\u009a\7\f\2\2\u009a\u009b\7)\2\2\u009b\u00a0\7"+
		")\2\2\u009c\u009d\7\r\2\2\u009d\u009e\7)\2\2\u009e\u00a0\7)\2\2\u009f"+
		"\u0099\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\r\3\2\2\2\u00a1\u00a2\7\16\2"+
		"\2\u00a2\u00a3\5\20\t\2\u00a3\17\3\2\2\2\u00a4\u00a5\t\3\2\2\u00a5\21"+
		"\3\2\2\2\u00a6\u00a7\7\23\2\2\u00a7\u00a8\5(\25\2\u00a8\23\3\2\2\2\u00a9"+
		"\u00aa\7\24\2\2\u00aa\u00c1\7)\2\2\u00ab\u00ac\7\24\2\2\u00ac\u00ad\7"+
		"\25\2\2\u00ad\u00c1\7)\2\2\u00ae\u00af\7\24\2\2\u00af\u00b0\7\26\2\2\u00b0"+
		"\u00b1\7)\2\2\u00b1\u00c1\7)\2\2\u00b2\u00b3\7\24\2\2\u00b3\u00b4\7\27"+
		"\2\2\u00b4\u00b5\7)\2\2\u00b5\u00c1\7)\2\2\u00b6\u00b7\7\24\2\2\u00b7"+
		"\u00b8\5\36\20\2\u00b8\u00b9\7)\2\2\u00b9\u00c1\3\2\2\2\u00ba\u00bb\7"+
		"\24\2\2\u00bb\u00bc\7\30\2\2\u00bc\u00c1\7)\2\2\u00bd\u00be\7\24\2\2\u00be"+
		"\u00bf\7\31\2\2\u00bf\u00c1\7)\2\2\u00c0\u00a9\3\2\2\2\u00c0\u00ab\3\2"+
		"\2\2\u00c0\u00ae\3\2\2\2\u00c0\u00b2\3\2\2\2\u00c0\u00b6\3\2\2\2\u00c0"+
		"\u00ba\3\2\2\2\u00c0\u00bd\3\2\2\2\u00c1\25\3\2\2\2\u00c2\u00c3\7\32\2"+
		"\2\u00c3\u00c4\5\34\17\2\u00c4\u00c5\7\33\2\2\u00c5\u00c6\5\30\r\2\u00c6"+
		"\u00c7\7\33\2\2\u00c7\u00c8\5\34\17\2\u00c8\27\3\2\2\2\u00c9\u00ca\5\32"+
		"\16\2\u00ca\u00cb\7)\2\2\u00cb\31\3\2\2\2\u00cc\u00cd\t\4\2\2\u00cd\33"+
		"\3\2\2\2\u00ce\u00d1\7)\2\2\u00cf\u00d0\7\34\2\2\u00d0\u00d2\7)\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\35\3\2\2\2\u00d3\u00d8\7\35\2"+
		"\2\u00d4\u00d8\7\36\2\2\u00d5\u00d8\7\37\2\2\u00d6\u00d8\7 \2\2\u00d7"+
		"\u00d3\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8\37\3\2\2\2\u00d9\u00db\t\5\2\2\u00da\u00dc\5&\24\2\u00db\u00da"+
		"\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0\7\'\2\2\u00de"+
		"\u00e0\7&\2\2\u00df\u00d9\3\2\2\2\u00df\u00de\3\2\2\2\u00e0!\3\2\2\2\u00e1"+
		"\u00e3\7#\2\2\u00e2\u00e4\5&\24\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e8\7\'\2\2\u00e6\u00e8\7&\2\2\u00e7"+
		"\u00e1\3\2\2\2\u00e7\u00e6\3\2\2\2\u00e8#\3\2\2\2\u00e9\u00eb\7$\2\2\u00ea"+
		"\u00ec\5&\24\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ee\7\'\2\2\u00ee%\3\2\2\2\u00ef\u00f0\7%\2\2\u00f0\u00f1"+
		"\7)\2\2\u00f1\'\3\2\2\2\u00f2\u00f3\7(\2\2\u00f3)\3\2\2\2\36-\639AFLV"+
		"Y^dhmrx~\u0083\u0089\u008e\u0097\u009f\u00c0\u00d1\u00d7\u00db\u00df\u00e3"+
		"\u00e7\u00eb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}