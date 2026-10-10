// Generated from CSL.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.csl.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		VERSION=46, BOOLEAN=47, REAL=48, INT=49, STRING_LITERAL=50, OCL_STRING=51, 
		IDENT=52, WS=53, LINE_COMMENT=54, BLOCK_COMMENT=55;
	public static final int
		RULE_model = 0, RULE_topLevelDecl = 1, RULE_enumDecl = 2, RULE_datatypeDecl = 3, 
		RULE_entityDecl = 4, RULE_roleDecl = 5, RULE_specializesClause = 6, RULE_orgContextDecl = 7, 
		RULE_orgContextItem = 8, RULE_attributeBlock = 9, RULE_attributeDecl = 10, 
		RULE_attributeModifier = 11, RULE_defaultClause = 12, RULE_defaultValue = 13, 
		RULE_entityRelationDecl = 14, RULE_relationKind = 15, RULE_endpointDecl = 16, 
		RULE_compatibilityDecl = 17, RULE_cardinality = 18, RULE_invariantDecl = 19, 
		RULE_oclExpression = 20, RULE_oclToken = 21, RULE_oclKeyword = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"model", "topLevelDecl", "enumDecl", "datatypeDecl", "entityDecl", "roleDecl", 
			"specializesClause", "orgContextDecl", "orgContextItem", "attributeBlock", 
			"attributeDecl", "attributeModifier", "defaultClause", "defaultValue", 
			"entityRelationDecl", "relationKind", "endpointDecl", "compatibilityDecl", 
			"cardinality", "invariantDecl", "oclExpression", "oclToken", "oclKeyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'csl'", "'{'", "'}'", "'enum'", "','", "'datatype'", "';'", "'entity'", 
			"'role'", "'specializes'", "'extends'", "'orgContext'", "'attribute'", 
			"':'", "'optional'", "'required'", "'mutable'", "'default'", "'-'", "'association'", 
			"'aggregation'", "'composition'", "'compatible'", "'['", "']'", "'..'", 
			"'*'", "'context'", "'inv'", "'.'", "'->'", "'('", "')'", "'|'", "'@'", 
			"'#'", "'::'", "'='", "'<>'", "'<'", "'<='", "'>'", "'>='", "'+'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "VERSION", 
			"BOOLEAN", "REAL", "INT", "STRING_LITERAL", "OCL_STRING", "IDENT", "WS", 
			"LINE_COMMENT", "BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "CSL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModelContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(CSLParser.VERSION, 0); }
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public TerminalNode EOF() { return getToken(CSLParser.EOF, 0); }
		public List<TopLevelDeclContext> topLevelDecl() {
			return getRuleContexts(TopLevelDeclContext.class);
		}
		public TopLevelDeclContext topLevelDecl(int i) {
			return getRuleContext(TopLevelDeclContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitModel(this);
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
			setState(46);
			match(T__0);
			setState(47);
			match(VERSION);
			setState(48);
			match(IDENT);
			setState(49);
			match(T__1);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__27) | (1L << IDENT))) != 0)) {
				{
				{
				setState(50);
				topLevelDecl();
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			match(T__2);
			setState(57);
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

	public static class TopLevelDeclContext extends ParserRuleContext {
		public EnumDeclContext enumDecl() {
			return getRuleContext(EnumDeclContext.class,0);
		}
		public DatatypeDeclContext datatypeDecl() {
			return getRuleContext(DatatypeDeclContext.class,0);
		}
		public EntityDeclContext entityDecl() {
			return getRuleContext(EntityDeclContext.class,0);
		}
		public RoleDeclContext roleDecl() {
			return getRuleContext(RoleDeclContext.class,0);
		}
		public OrgContextDeclContext orgContextDecl() {
			return getRuleContext(OrgContextDeclContext.class,0);
		}
		public EntityRelationDeclContext entityRelationDecl() {
			return getRuleContext(EntityRelationDeclContext.class,0);
		}
		public CompatibilityDeclContext compatibilityDecl() {
			return getRuleContext(CompatibilityDeclContext.class,0);
		}
		public InvariantDeclContext invariantDecl() {
			return getRuleContext(InvariantDeclContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitTopLevelDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitTopLevelDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(67);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				enumDecl();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				datatypeDecl();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				entityDecl();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				roleDecl();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				orgContextDecl();
				}
				break;
			case T__19:
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				entityRelationDecl();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				compatibilityDecl();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				invariantDecl();
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

	public static class EnumDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CSLParser.IDENT, i);
		}
		public EnumDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterEnumDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitEnumDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitEnumDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDeclContext enumDecl() throws RecognitionException {
		EnumDeclContext _localctx = new EnumDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_enumDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(T__3);
			setState(70);
			match(IDENT);
			setState(71);
			match(T__1);
			setState(72);
			match(IDENT);
			setState(77);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					match(T__4);
					setState(74);
					match(IDENT);
					}
					} 
				}
				setState(79);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(80);
				match(T__4);
				}
			}

			setState(83);
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

	public static class DatatypeDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public DatatypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatypeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterDatatypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitDatatypeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitDatatypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeDeclContext datatypeDecl() throws RecognitionException {
		DatatypeDeclContext _localctx = new DatatypeDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_datatypeDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__5);
			setState(86);
			match(IDENT);
			setState(87);
			match(T__6);
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

	public static class EntityDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public AttributeBlockContext attributeBlock() {
			return getRuleContext(AttributeBlockContext.class,0);
		}
		public SpecializesClauseContext specializesClause() {
			return getRuleContext(SpecializesClauseContext.class,0);
		}
		public EntityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterEntityDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitEntityDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitEntityDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityDeclContext entityDecl() throws RecognitionException {
		EntityDeclContext _localctx = new EntityDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_entityDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__7);
			setState(90);
			match(IDENT);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==T__10) {
				{
				setState(91);
				specializesClause();
				}
			}

			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(94);
				match(T__6);
				}
				break;
			case T__1:
				{
				setState(95);
				attributeBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RoleDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public AttributeBlockContext attributeBlock() {
			return getRuleContext(AttributeBlockContext.class,0);
		}
		public SpecializesClauseContext specializesClause() {
			return getRuleContext(SpecializesClauseContext.class,0);
		}
		public RoleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roleDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterRoleDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitRoleDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitRoleDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleDeclContext roleDecl() throws RecognitionException {
		RoleDeclContext _localctx = new RoleDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_roleDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__8);
			setState(99);
			match(IDENT);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9 || _la==T__10) {
				{
				setState(100);
				specializesClause();
				}
			}

			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				setState(103);
				match(T__6);
				}
				break;
			case T__1:
				{
				setState(104);
				attributeBlock();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class SpecializesClauseContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public SpecializesClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specializesClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterSpecializesClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitSpecializesClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitSpecializesClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecializesClauseContext specializesClause() throws RecognitionException {
		SpecializesClauseContext _localctx = new SpecializesClauseContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_specializesClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==T__9 || _la==T__10) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(108);
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

	public static class OrgContextDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public List<OrgContextItemContext> orgContextItem() {
			return getRuleContexts(OrgContextItemContext.class);
		}
		public OrgContextItemContext orgContextItem(int i) {
			return getRuleContext(OrgContextItemContext.class,i);
		}
		public OrgContextDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orgContextDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterOrgContextDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitOrgContextDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitOrgContextDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrgContextDeclContext orgContextDecl() throws RecognitionException {
		OrgContextDeclContext _localctx = new OrgContextDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_orgContextDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__11);
			setState(111);
			match(IDENT);
			setState(112);
			match(T__1);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__11) | (1L << T__12) | (1L << IDENT))) != 0)) {
				{
				{
				setState(113);
				orgContextItem();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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

	public static class OrgContextItemContext extends ParserRuleContext {
		public AttributeDeclContext attributeDecl() {
			return getRuleContext(AttributeDeclContext.class,0);
		}
		public EntityDeclContext entityDecl() {
			return getRuleContext(EntityDeclContext.class,0);
		}
		public RoleDeclContext roleDecl() {
			return getRuleContext(RoleDeclContext.class,0);
		}
		public OrgContextDeclContext orgContextDecl() {
			return getRuleContext(OrgContextDeclContext.class,0);
		}
		public CompatibilityDeclContext compatibilityDecl() {
			return getRuleContext(CompatibilityDeclContext.class,0);
		}
		public OrgContextItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orgContextItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterOrgContextItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitOrgContextItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitOrgContextItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrgContextItemContext orgContextItem() throws RecognitionException {
		OrgContextItemContext _localctx = new OrgContextItemContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_orgContextItem);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				attributeDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				entityDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(123);
				roleDecl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(124);
				orgContextDecl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(125);
				compatibilityDecl();
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

	public static class AttributeBlockContext extends ParserRuleContext {
		public List<AttributeDeclContext> attributeDecl() {
			return getRuleContexts(AttributeDeclContext.class);
		}
		public AttributeDeclContext attributeDecl(int i) {
			return getRuleContext(AttributeDeclContext.class,i);
		}
		public AttributeBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterAttributeBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitAttributeBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitAttributeBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeBlockContext attributeBlock() throws RecognitionException {
		AttributeBlockContext _localctx = new AttributeBlockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attributeBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__1);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12 || _la==IDENT) {
				{
				{
				setState(129);
				attributeDecl();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
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

	public static class AttributeDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CSLParser.IDENT, i);
		}
		public AttributeModifierContext attributeModifier() {
			return getRuleContext(AttributeModifierContext.class,0);
		}
		public DefaultClauseContext defaultClause() {
			return getRuleContext(DefaultClauseContext.class,0);
		}
		public AttributeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterAttributeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitAttributeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitAttributeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeDeclContext attributeDecl() throws RecognitionException {
		AttributeDeclContext _localctx = new AttributeDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attributeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(137);
				match(T__12);
				}
			}

			setState(140);
			match(IDENT);
			setState(141);
			match(T__13);
			setState(142);
			match(IDENT);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << T__16))) != 0)) {
				{
				setState(143);
				attributeModifier();
				}
			}

			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(146);
				defaultClause();
				}
			}

			setState(149);
			match(T__6);
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

	public static class AttributeModifierContext extends ParserRuleContext {
		public AttributeModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterAttributeModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitAttributeModifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitAttributeModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeModifierContext attributeModifier() throws RecognitionException {
		AttributeModifierContext _localctx = new AttributeModifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeModifier);
		int _la;
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(152);
					match(T__16);
					}
				}

				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
				match(T__16);
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__14 || _la==T__15) {
					{
					setState(156);
					_la = _input.LA(1);
					if ( !(_la==T__14 || _la==T__15) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

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

	public static class DefaultClauseContext extends ParserRuleContext {
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public DefaultClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterDefaultClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitDefaultClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitDefaultClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultClauseContext defaultClause() throws RecognitionException {
		DefaultClauseContext _localctx = new DefaultClauseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_defaultClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__17);
			setState(162);
			defaultValue();
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

	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(CSLParser.STRING_LITERAL, 0); }
		public TerminalNode OCL_STRING() { return getToken(CSLParser.OCL_STRING, 0); }
		public TerminalNode INT() { return getToken(CSLParser.INT, 0); }
		public TerminalNode REAL() { return getToken(CSLParser.REAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(CSLParser.BOOLEAN, 0); }
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defaultValue);
		int _la;
		try {
			setState(172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(STRING_LITERAL);
				}
				break;
			case OCL_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(165);
				match(OCL_STRING);
				}
				break;
			case T__18:
			case REAL:
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(166);
					match(T__18);
					}
				}

				setState(169);
				_la = _input.LA(1);
				if ( !(_la==REAL || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(BOOLEAN);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(171);
				match(IDENT);
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

	public static class EntityRelationDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public List<EndpointDeclContext> endpointDecl() {
			return getRuleContexts(EndpointDeclContext.class);
		}
		public EndpointDeclContext endpointDecl(int i) {
			return getRuleContext(EndpointDeclContext.class,i);
		}
		public RelationKindContext relationKind() {
			return getRuleContext(RelationKindContext.class,0);
		}
		public EntityRelationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityRelationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterEntityRelationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitEntityRelationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitEntityRelationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityRelationDeclContext entityRelationDecl() throws RecognitionException {
		EntityRelationDeclContext _localctx = new EntityRelationDeclContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_entityRelationDecl);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(T__19);
				setState(175);
				match(IDENT);
				setState(176);
				match(T__1);
				setState(177);
				endpointDecl();
				setState(179); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(178);
					endpointDecl();
					}
					}
					setState(181); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==IDENT );
				setState(183);
				match(T__2);
				}
				break;
			case T__20:
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				relationKind();
				setState(186);
				match(IDENT);
				setState(187);
				match(T__1);
				setState(188);
				endpointDecl();
				setState(189);
				endpointDecl();
				setState(190);
				match(T__2);
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

	public static class RelationKindContext extends ParserRuleContext {
		public RelationKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterRelationKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitRelationKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitRelationKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationKindContext relationKind() throws RecognitionException {
		RelationKindContext _localctx = new RelationKindContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_relationKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_la = _input.LA(1);
			if ( !(_la==T__20 || _la==T__21) ) {
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

	public static class EndpointDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CSLParser.IDENT, i);
		}
		public CardinalityContext cardinality() {
			return getRuleContext(CardinalityContext.class,0);
		}
		public EndpointDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endpointDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterEndpointDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitEndpointDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitEndpointDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndpointDeclContext endpointDecl() throws RecognitionException {
		EndpointDeclContext _localctx = new EndpointDeclContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_endpointDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(IDENT);
			setState(197);
			cardinality();
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8 || _la==IDENT) {
				{
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__8) {
					{
					setState(198);
					match(T__8);
					}
				}

				setState(201);
				match(IDENT);
				}
			}

			setState(204);
			match(T__6);
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

	public static class CompatibilityDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CSLParser.IDENT, i);
		}
		public CompatibilityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compatibilityDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterCompatibilityDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitCompatibilityDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitCompatibilityDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompatibilityDeclContext compatibilityDecl() throws RecognitionException {
		CompatibilityDeclContext _localctx = new CompatibilityDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_compatibilityDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(IDENT);
			setState(207);
			match(T__22);
			setState(208);
			match(IDENT);
			setState(209);
			match(T__6);
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

	public static class CardinalityContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(CSLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(CSLParser.INT, i);
		}
		public CardinalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cardinality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterCardinality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitCardinality(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitCardinality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CardinalityContext cardinality() throws RecognitionException {
		CardinalityContext _localctx = new CardinalityContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_cardinality);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(T__23);
				setState(212);
				match(INT);
				setState(213);
				match(T__24);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(214);
				match(T__23);
				setState(215);
				match(INT);
				setState(216);
				match(T__25);
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==T__26 || _la==INT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(218);
				match(T__24);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219);
				match(T__23);
				setState(220);
				match(T__26);
				setState(221);
				match(T__24);
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

	public static class InvariantDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(CSLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(CSLParser.IDENT, i);
		}
		public OclExpressionContext oclExpression() {
			return getRuleContext(OclExpressionContext.class,0);
		}
		public InvariantDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariantDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterInvariantDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitInvariantDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitInvariantDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InvariantDeclContext invariantDecl() throws RecognitionException {
		InvariantDeclContext _localctx = new InvariantDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_invariantDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__27);
			setState(225);
			match(IDENT);
			setState(226);
			match(T__28);
			setState(227);
			match(IDENT);
			setState(228);
			match(T__13);
			setState(229);
			oclExpression();
			setState(230);
			match(T__6);
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

	public static class OclExpressionContext extends ParserRuleContext {
		public List<OclTokenContext> oclToken() {
			return getRuleContexts(OclTokenContext.class);
		}
		public OclTokenContext oclToken(int i) {
			return getRuleContext(OclTokenContext.class,i);
		}
		public OclExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oclExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterOclExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitOclExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitOclExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OclExpressionContext oclExpression() throws RecognitionException {
		OclExpressionContext _localctx = new OclExpressionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_oclExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(232);
				oclToken();
				}
				}
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << BOOLEAN) | (1L << REAL) | (1L << INT) | (1L << STRING_LITERAL) | (1L << OCL_STRING) | (1L << IDENT))) != 0) );
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

	public static class OclTokenContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(CSLParser.IDENT, 0); }
		public OclKeywordContext oclKeyword() {
			return getRuleContext(OclKeywordContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(CSLParser.STRING_LITERAL, 0); }
		public TerminalNode OCL_STRING() { return getToken(CSLParser.OCL_STRING, 0); }
		public TerminalNode INT() { return getToken(CSLParser.INT, 0); }
		public TerminalNode REAL() { return getToken(CSLParser.REAL, 0); }
		public TerminalNode BOOLEAN() { return getToken(CSLParser.BOOLEAN, 0); }
		public OclTokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oclToken; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterOclToken(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitOclToken(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitOclToken(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OclTokenContext oclToken() throws RecognitionException {
		OclTokenContext _localctx = new OclTokenContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_oclToken);
		try {
			setState(268);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(IDENT);
				}
				break;
			case T__0:
			case T__3:
			case T__5:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__19:
			case T__20:
			case T__21:
			case T__22:
			case T__27:
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				oclKeyword();
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				match(STRING_LITERAL);
				}
				break;
			case OCL_STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(240);
				match(OCL_STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				match(INT);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				match(REAL);
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 7);
				{
				setState(243);
				match(BOOLEAN);
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 8);
				{
				setState(244);
				match(T__29);
				}
				break;
			case T__30:
				enterOuterAlt(_localctx, 9);
				{
				setState(245);
				match(T__30);
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 10);
				{
				setState(246);
				match(T__31);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 11);
				{
				setState(247);
				match(T__32);
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 12);
				{
				setState(248);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 13);
				{
				setState(249);
				match(T__24);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 14);
				{
				setState(250);
				match(T__1);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 15);
				{
				setState(251);
				match(T__2);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 16);
				{
				setState(252);
				match(T__4);
				}
				break;
			case T__33:
				enterOuterAlt(_localctx, 17);
				{
				setState(253);
				match(T__33);
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 18);
				{
				setState(254);
				match(T__34);
				}
				break;
			case T__35:
				enterOuterAlt(_localctx, 19);
				{
				setState(255);
				match(T__35);
				}
				break;
			case T__36:
				enterOuterAlt(_localctx, 20);
				{
				setState(256);
				match(T__36);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 21);
				{
				setState(257);
				match(T__13);
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 22);
				{
				setState(258);
				match(T__37);
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 23);
				{
				setState(259);
				match(T__38);
				}
				break;
			case T__39:
				enterOuterAlt(_localctx, 24);
				{
				setState(260);
				match(T__39);
				}
				break;
			case T__40:
				enterOuterAlt(_localctx, 25);
				{
				setState(261);
				match(T__40);
				}
				break;
			case T__41:
				enterOuterAlt(_localctx, 26);
				{
				setState(262);
				match(T__41);
				}
				break;
			case T__42:
				enterOuterAlt(_localctx, 27);
				{
				setState(263);
				match(T__42);
				}
				break;
			case T__43:
				enterOuterAlt(_localctx, 28);
				{
				setState(264);
				match(T__43);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 29);
				{
				setState(265);
				match(T__18);
				}
				break;
			case T__26:
				enterOuterAlt(_localctx, 30);
				{
				setState(266);
				match(T__26);
				}
				break;
			case T__44:
				enterOuterAlt(_localctx, 31);
				{
				setState(267);
				match(T__44);
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

	public static class OclKeywordContext extends ParserRuleContext {
		public OclKeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oclKeyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).enterOclKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CSLListener ) ((CSLListener)listener).exitOclKeyword(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CSLVisitor ) return ((CSLVisitor<? extends T>)visitor).visitOclKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OclKeywordContext oclKeyword() throws RecognitionException {
		OclKeywordContext _localctx = new OclKeywordContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_oclKeyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__3) | (1L << T__5) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__27) | (1L << T__28))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\39\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\3\2\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\5\3F\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4N\n\4\f\4\16\4Q\13\4\3"+
		"\4\5\4T\n\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\5\6_\n\6\3\6\3\6\5\6c"+
		"\n\6\3\7\3\7\3\7\5\7h\n\7\3\7\3\7\5\7l\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\7\tu\n\t\f\t\16\tx\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0081\n\n\3\13"+
		"\3\13\7\13\u0085\n\13\f\13\16\13\u0088\13\13\3\13\3\13\3\f\5\f\u008d\n"+
		"\f\3\f\3\f\3\f\3\f\5\f\u0093\n\f\3\f\5\f\u0096\n\f\3\f\3\f\3\r\3\r\5\r"+
		"\u009c\n\r\3\r\3\r\5\r\u00a0\n\r\5\r\u00a2\n\r\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\5\17\u00aa\n\17\3\17\3\17\3\17\5\17\u00af\n\17\3\20\3\20\3\20\3"+
		"\20\3\20\6\20\u00b6\n\20\r\20\16\20\u00b7\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u00c3\n\20\3\21\3\21\3\22\3\22\3\22\5\22\u00ca\n"+
		"\22\3\22\5\22\u00cd\n\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e1\n\24\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\6\26\u00ec\n\26\r\26\16\26\u00ed\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\5\27\u010f\n\27\3\30\3\30\3\30\2\2\31\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\2\b\3\2\f\r\3\2\21\22\3\2\62\63\3\2\27"+
		"\30\4\2\35\35\63\63\t\2\3\3\6\6\b\b\n\17\21\24\26\31\36\37\2\u013f\2\60"+
		"\3\2\2\2\4E\3\2\2\2\6G\3\2\2\2\bW\3\2\2\2\n[\3\2\2\2\fd\3\2\2\2\16m\3"+
		"\2\2\2\20p\3\2\2\2\22\u0080\3\2\2\2\24\u0082\3\2\2\2\26\u008c\3\2\2\2"+
		"\30\u00a1\3\2\2\2\32\u00a3\3\2\2\2\34\u00ae\3\2\2\2\36\u00c2\3\2\2\2 "+
		"\u00c4\3\2\2\2\"\u00c6\3\2\2\2$\u00d0\3\2\2\2&\u00e0\3\2\2\2(\u00e2\3"+
		"\2\2\2*\u00eb\3\2\2\2,\u010e\3\2\2\2.\u0110\3\2\2\2\60\61\7\3\2\2\61\62"+
		"\7\60\2\2\62\63\7\66\2\2\63\67\7\4\2\2\64\66\5\4\3\2\65\64\3\2\2\2\66"+
		"9\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28:\3\2\2\29\67\3\2\2\2:;\7\5\2\2;<"+
		"\7\2\2\3<\3\3\2\2\2=F\5\6\4\2>F\5\b\5\2?F\5\n\6\2@F\5\f\7\2AF\5\20\t\2"+
		"BF\5\36\20\2CF\5$\23\2DF\5(\25\2E=\3\2\2\2E>\3\2\2\2E?\3\2\2\2E@\3\2\2"+
		"\2EA\3\2\2\2EB\3\2\2\2EC\3\2\2\2ED\3\2\2\2F\5\3\2\2\2GH\7\6\2\2HI\7\66"+
		"\2\2IJ\7\4\2\2JO\7\66\2\2KL\7\7\2\2LN\7\66\2\2MK\3\2\2\2NQ\3\2\2\2OM\3"+
		"\2\2\2OP\3\2\2\2PS\3\2\2\2QO\3\2\2\2RT\7\7\2\2SR\3\2\2\2ST\3\2\2\2TU\3"+
		"\2\2\2UV\7\5\2\2V\7\3\2\2\2WX\7\b\2\2XY\7\66\2\2YZ\7\t\2\2Z\t\3\2\2\2"+
		"[\\\7\n\2\2\\^\7\66\2\2]_\5\16\b\2^]\3\2\2\2^_\3\2\2\2_b\3\2\2\2`c\7\t"+
		"\2\2ac\5\24\13\2b`\3\2\2\2ba\3\2\2\2c\13\3\2\2\2de\7\13\2\2eg\7\66\2\2"+
		"fh\5\16\b\2gf\3\2\2\2gh\3\2\2\2hk\3\2\2\2il\7\t\2\2jl\5\24\13\2ki\3\2"+
		"\2\2kj\3\2\2\2l\r\3\2\2\2mn\t\2\2\2no\7\66\2\2o\17\3\2\2\2pq\7\16\2\2"+
		"qr\7\66\2\2rv\7\4\2\2su\5\22\n\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2"+
		"\2wy\3\2\2\2xv\3\2\2\2yz\7\5\2\2z\21\3\2\2\2{\u0081\5\26\f\2|\u0081\5"+
		"\n\6\2}\u0081\5\f\7\2~\u0081\5\20\t\2\177\u0081\5$\23\2\u0080{\3\2\2\2"+
		"\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081"+
		"\23\3\2\2\2\u0082\u0086\7\4\2\2\u0083\u0085\5\26\f\2\u0084\u0083\3\2\2"+
		"\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089"+
		"\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\5\2\2\u008a\25\3\2\2\2\u008b"+
		"\u008d\7\17\2\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3"+
		"\2\2\2\u008e\u008f\7\66\2\2\u008f\u0090\7\20\2\2\u0090\u0092\7\66\2\2"+
		"\u0091\u0093\5\30\r\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u0096\5\32\16\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0098\7\t\2\2\u0098\27\3\2\2\2\u0099\u009b"+
		"\t\3\2\2\u009a\u009c\7\23\2\2\u009b\u009a\3\2\2\2\u009b\u009c\3\2\2\2"+
		"\u009c\u00a2\3\2\2\2\u009d\u009f\7\23\2\2\u009e\u00a0\t\3\2\2\u009f\u009e"+
		"\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u0099\3\2\2\2\u00a1"+
		"\u009d\3\2\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\7\24\2\2\u00a4\u00a5\5\34"+
		"\17\2\u00a5\33\3\2\2\2\u00a6\u00af\7\64\2\2\u00a7\u00af\7\65\2\2\u00a8"+
		"\u00aa\7\25\2\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3"+
		"\2\2\2\u00ab\u00af\t\4\2\2\u00ac\u00af\7\61\2\2\u00ad\u00af\7\66\2\2\u00ae"+
		"\u00a6\3\2\2\2\u00ae\u00a7\3\2\2\2\u00ae\u00a9\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00ad\3\2\2\2\u00af\35\3\2\2\2\u00b0\u00b1\7\26\2\2\u00b1\u00b2"+
		"\7\66\2\2\u00b2\u00b3\7\4\2\2\u00b3\u00b5\5\"\22\2\u00b4\u00b6\5\"\22"+
		"\2\u00b5\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00ba\7\5\2\2\u00ba\u00c3\3\2\2\2\u00bb"+
		"\u00bc\5 \21\2\u00bc\u00bd\7\66\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf\5"+
		"\"\22\2\u00bf\u00c0\5\"\22\2\u00c0\u00c1\7\5\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00b0\3\2\2\2\u00c2\u00bb\3\2\2\2\u00c3\37\3\2\2\2\u00c4\u00c5\t\5\2"+
		"\2\u00c5!\3\2\2\2\u00c6\u00c7\7\66\2\2\u00c7\u00cc\5&\24\2\u00c8\u00ca"+
		"\7\13\2\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cb\3\2\2\2"+
		"\u00cb\u00cd\7\66\2\2\u00cc\u00c9\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00ce"+
		"\3\2\2\2\u00ce\u00cf\7\t\2\2\u00cf#\3\2\2\2\u00d0\u00d1\7\66\2\2\u00d1"+
		"\u00d2\7\31\2\2\u00d2\u00d3\7\66\2\2\u00d3\u00d4\7\t\2\2\u00d4%\3\2\2"+
		"\2\u00d5\u00d6\7\32\2\2\u00d6\u00d7\7\63\2\2\u00d7\u00e1\7\33\2\2\u00d8"+
		"\u00d9\7\32\2\2\u00d9\u00da\7\63\2\2\u00da\u00db\7\34\2\2\u00db\u00dc"+
		"\t\6\2\2\u00dc\u00e1\7\33\2\2\u00dd\u00de\7\32\2\2\u00de\u00df\7\35\2"+
		"\2\u00df\u00e1\7\33\2\2\u00e0\u00d5\3\2\2\2\u00e0\u00d8\3\2\2\2\u00e0"+
		"\u00dd\3\2\2\2\u00e1\'\3\2\2\2\u00e2\u00e3\7\36\2\2\u00e3\u00e4\7\66\2"+
		"\2\u00e4\u00e5\7\37\2\2\u00e5\u00e6\7\66\2\2\u00e6\u00e7\7\20\2\2\u00e7"+
		"\u00e8\5*\26\2\u00e8\u00e9\7\t\2\2\u00e9)\3\2\2\2\u00ea\u00ec\5,\27\2"+
		"\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee"+
		"\3\2\2\2\u00ee+\3\2\2\2\u00ef\u010f\7\66\2\2\u00f0\u010f\5.\30\2\u00f1"+
		"\u010f\7\64\2\2\u00f2\u010f\7\65\2\2\u00f3\u010f\7\63\2\2\u00f4\u010f"+
		"\7\62\2\2\u00f5\u010f\7\61\2\2\u00f6\u010f\7 \2\2\u00f7\u010f\7!\2\2\u00f8"+
		"\u010f\7\"\2\2\u00f9\u010f\7#\2\2\u00fa\u010f\7\32\2\2\u00fb\u010f\7\33"+
		"\2\2\u00fc\u010f\7\4\2\2\u00fd\u010f\7\5\2\2\u00fe\u010f\7\7\2\2\u00ff"+
		"\u010f\7$\2\2\u0100\u010f\7%\2\2\u0101\u010f\7&\2\2\u0102\u010f\7\'\2"+
		"\2\u0103\u010f\7\20\2\2\u0104\u010f\7(\2\2\u0105\u010f\7)\2\2\u0106\u010f"+
		"\7*\2\2\u0107\u010f\7+\2\2\u0108\u010f\7,\2\2\u0109\u010f\7-\2\2\u010a"+
		"\u010f\7.\2\2\u010b\u010f\7\25\2\2\u010c\u010f\7\35\2\2\u010d\u010f\7"+
		"/\2\2\u010e\u00ef\3\2\2\2\u010e\u00f0\3\2\2\2\u010e\u00f1\3\2\2\2\u010e"+
		"\u00f2\3\2\2\2\u010e\u00f3\3\2\2\2\u010e\u00f4\3\2\2\2\u010e\u00f5\3\2"+
		"\2\2\u010e\u00f6\3\2\2\2\u010e\u00f7\3\2\2\2\u010e\u00f8\3\2\2\2\u010e"+
		"\u00f9\3\2\2\2\u010e\u00fa\3\2\2\2\u010e\u00fb\3\2\2\2\u010e\u00fc\3\2"+
		"\2\2\u010e\u00fd\3\2\2\2\u010e\u00fe\3\2\2\2\u010e\u00ff\3\2\2\2\u010e"+
		"\u0100\3\2\2\2\u010e\u0101\3\2\2\2\u010e\u0102\3\2\2\2\u010e\u0103\3\2"+
		"\2\2\u010e\u0104\3\2\2\2\u010e\u0105\3\2\2\2\u010e\u0106\3\2\2\2\u010e"+
		"\u0107\3\2\2\2\u010e\u0108\3\2\2\2\u010e\u0109\3\2\2\2\u010e\u010a\3\2"+
		"\2\2\u010e\u010b\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010d\3\2\2\2\u010f"+
		"-\3\2\2\2\u0110\u0111\t\7\2\2\u0111/\3\2\2\2\34\67EOS^bgkv\u0080\u0086"+
		"\u008c\u0092\u0095\u009b\u009f\u00a1\u00a9\u00ae\u00b7\u00c2\u00c9\u00cc"+
		"\u00e0\u00ed\u010e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}