// Generated from AOL.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.aol.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		VERSION=18, BOOLEAN=19, SIGNED_NUMBER=20, STRING_LITERAL=21, IDENT=22, 
		WS=23, LINE_COMMENT=24, BLOCK_COMMENT=25;
	public static final int
		RULE_model = 0, RULE_topLevelDecl = 1, RULE_agentDecl = 2, RULE_groupInstanceDecl = 3, 
		RULE_groupItemDecl = 4, RULE_playDecl = 5, RULE_roleInstanceDecl = 6, 
		RULE_playLinkDecl = 7, RULE_entityInstanceDecl = 8, RULE_linkDecl = 9, 
		RULE_attributeValueBlock = 10, RULE_attributeValue = 11, RULE_value = 12;
	private static String[] makeRuleNames() {
		return new String[] {
			"model", "topLevelDecl", "agentDecl", "groupInstanceDecl", "groupItemDecl", 
			"playDecl", "roleInstanceDecl", "playLinkDecl", "entityInstanceDecl", 
			"linkDecl", "attributeValueBlock", "attributeValue", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'aol'", "'for'", "'{'", "'}'", "'agent'", "'as'", "','", "';'", 
			"'group'", "'play'", "'by'", "'role'", "'->'", "'entity'", "'link'", 
			"':'", "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "VERSION", "BOOLEAN", "SIGNED_NUMBER", 
			"STRING_LITERAL", "IDENT", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "AOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModelContext extends ParserRuleContext {
		public TerminalNode VERSION() { return getToken(AOLParser.VERSION, 0); }
		public TerminalNode IDENT() { return getToken(AOLParser.IDENT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(AOLParser.STRING_LITERAL, 0); }
		public TerminalNode EOF() { return getToken(AOLParser.EOF, 0); }
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
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitModel(this);
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
			setState(26);
			match(T__0);
			setState(27);
			match(VERSION);
			setState(28);
			match(IDENT);
			setState(29);
			match(T__1);
			setState(30);
			match(STRING_LITERAL);
			setState(31);
			match(T__2);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << T__14))) != 0)) {
				{
				{
				setState(32);
				topLevelDecl();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			match(T__3);
			setState(39);
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
		public AgentDeclContext agentDecl() {
			return getRuleContext(AgentDeclContext.class,0);
		}
		public GroupInstanceDeclContext groupInstanceDecl() {
			return getRuleContext(GroupInstanceDeclContext.class,0);
		}
		public EntityInstanceDeclContext entityInstanceDecl() {
			return getRuleContext(EntityInstanceDeclContext.class,0);
		}
		public RoleInstanceDeclContext roleInstanceDecl() {
			return getRuleContext(RoleInstanceDeclContext.class,0);
		}
		public PlayLinkDeclContext playLinkDecl() {
			return getRuleContext(PlayLinkDeclContext.class,0);
		}
		public LinkDeclContext linkDecl() {
			return getRuleContext(LinkDeclContext.class,0);
		}
		public TopLevelDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevelDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterTopLevelDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitTopLevelDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitTopLevelDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelDeclContext topLevelDecl() throws RecognitionException {
		TopLevelDeclContext _localctx = new TopLevelDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevelDecl);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				agentDecl();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				groupInstanceDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(43);
				entityInstanceDecl();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				roleInstanceDecl();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(45);
				playLinkDecl();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 6);
				{
				setState(46);
				linkDecl();
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

	public static class AgentDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public AttributeValueBlockContext attributeValueBlock() {
			return getRuleContext(AttributeValueBlockContext.class,0);
		}
		public AgentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterAgentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitAgentDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitAgentDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentDeclContext agentDecl() throws RecognitionException {
		AgentDeclContext _localctx = new AgentDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_agentDecl);
		int _la;
		try {
			setState(64);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__4);
				setState(50);
				match(IDENT);
				setState(51);
				match(T__5);
				setState(52);
				match(IDENT);
				setState(53);
				attributeValueBlock();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__4);
				setState(55);
				match(IDENT);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(56);
					match(T__6);
					setState(57);
					match(IDENT);
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(T__7);
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

	public static class GroupInstanceDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public List<GroupItemDeclContext> groupItemDecl() {
			return getRuleContexts(GroupItemDeclContext.class);
		}
		public GroupItemDeclContext groupItemDecl(int i) {
			return getRuleContext(GroupItemDeclContext.class,i);
		}
		public GroupInstanceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupInstanceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterGroupInstanceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitGroupInstanceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitGroupInstanceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupInstanceDeclContext groupInstanceDecl() throws RecognitionException {
		GroupInstanceDeclContext _localctx = new GroupInstanceDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_groupInstanceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__8);
			setState(67);
			match(IDENT);
			setState(68);
			match(T__5);
			setState(69);
			match(IDENT);
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(70);
				match(T__7);
				}
				break;
			case T__2:
				{
				setState(71);
				match(T__2);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << T__13) | (1L << IDENT))) != 0)) {
					{
					{
					setState(72);
					groupItemDecl();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(T__3);
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

	public static class GroupItemDeclContext extends ParserRuleContext {
		public GroupInstanceDeclContext groupInstanceDecl() {
			return getRuleContext(GroupInstanceDeclContext.class,0);
		}
		public PlayDeclContext playDecl() {
			return getRuleContext(PlayDeclContext.class,0);
		}
		public RoleInstanceDeclContext roleInstanceDecl() {
			return getRuleContext(RoleInstanceDeclContext.class,0);
		}
		public EntityInstanceDeclContext entityInstanceDecl() {
			return getRuleContext(EntityInstanceDeclContext.class,0);
		}
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public GroupItemDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupItemDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterGroupItemDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitGroupItemDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitGroupItemDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupItemDeclContext groupItemDecl() throws RecognitionException {
		GroupItemDeclContext _localctx = new GroupItemDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_groupItemDecl);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				groupInstanceDecl();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				playDecl();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(83);
				roleInstanceDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(84);
				entityInstanceDecl();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 5);
				{
				setState(85);
				attributeValue();
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

	public static class PlayDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public AttributeValueBlockContext attributeValueBlock() {
			return getRuleContext(AttributeValueBlockContext.class,0);
		}
		public PlayDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterPlayDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitPlayDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitPlayDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayDeclContext playDecl() throws RecognitionException {
		PlayDeclContext _localctx = new PlayDeclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_playDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__9);
			setState(89);
			match(IDENT);
			setState(90);
			match(T__5);
			setState(91);
			match(IDENT);
			setState(92);
			match(T__10);
			setState(93);
			match(IDENT);
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(94);
				match(T__7);
				}
				break;
			case T__2:
				{
				setState(95);
				attributeValueBlock();
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

	public static class RoleInstanceDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public AttributeValueBlockContext attributeValueBlock() {
			return getRuleContext(AttributeValueBlockContext.class,0);
		}
		public RoleInstanceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roleInstanceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterRoleInstanceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitRoleInstanceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitRoleInstanceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleInstanceDeclContext roleInstanceDecl() throws RecognitionException {
		RoleInstanceDeclContext _localctx = new RoleInstanceDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_roleInstanceDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__11);
			setState(99);
			match(IDENT);
			setState(100);
			match(T__5);
			setState(101);
			match(IDENT);
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(102);
				match(T__7);
				}
				break;
			case T__2:
				{
				setState(103);
				attributeValueBlock();
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

	public static class PlayLinkDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public PlayLinkDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playLinkDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterPlayLinkDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitPlayLinkDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitPlayLinkDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayLinkDeclContext playLinkDecl() throws RecognitionException {
		PlayLinkDeclContext _localctx = new PlayLinkDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_playLinkDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__9);
			setState(107);
			match(IDENT);
			setState(108);
			match(T__12);
			setState(109);
			match(IDENT);
			setState(110);
			match(T__7);
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

	public static class EntityInstanceDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public AttributeValueBlockContext attributeValueBlock() {
			return getRuleContext(AttributeValueBlockContext.class,0);
		}
		public EntityInstanceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityInstanceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterEntityInstanceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitEntityInstanceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitEntityInstanceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityInstanceDeclContext entityInstanceDecl() throws RecognitionException {
		EntityInstanceDeclContext _localctx = new EntityInstanceDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_entityInstanceDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(T__13);
			setState(113);
			match(IDENT);
			setState(114);
			match(T__5);
			setState(115);
			match(IDENT);
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				setState(116);
				match(T__7);
				}
				break;
			case T__2:
				{
				setState(117);
				attributeValueBlock();
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

	public static class LinkDeclContext extends ParserRuleContext {
		public List<TerminalNode> IDENT() { return getTokens(AOLParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(AOLParser.IDENT, i);
		}
		public LinkDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_linkDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterLinkDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitLinkDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitLinkDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LinkDeclContext linkDecl() throws RecognitionException {
		LinkDeclContext _localctx = new LinkDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_linkDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__14);
			setState(121);
			match(IDENT);
			setState(122);
			match(T__15);
			setState(123);
			match(IDENT);
			setState(124);
			match(T__12);
			setState(125);
			match(IDENT);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(126);
				match(T__6);
				setState(127);
				match(IDENT);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__7);
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

	public static class AttributeValueBlockContext extends ParserRuleContext {
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public AttributeValueBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValueBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterAttributeValueBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitAttributeValueBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitAttributeValueBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueBlockContext attributeValueBlock() throws RecognitionException {
		AttributeValueBlockContext _localctx = new AttributeValueBlockContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attributeValueBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__2);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(136);
				attributeValue();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__3);
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

	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(AOLParser.IDENT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(IDENT);
			setState(145);
			match(T__16);
			setState(146);
			value();
			setState(147);
			match(T__7);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING_LITERAL() { return getToken(AOLParser.STRING_LITERAL, 0); }
		public TerminalNode SIGNED_NUMBER() { return getToken(AOLParser.SIGNED_NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(AOLParser.BOOLEAN, 0); }
		public TerminalNode IDENT() { return getToken(AOLParser.IDENT, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AOLListener ) ((AOLListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof AOLVisitor ) return ((AOLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << SIGNED_NUMBER) | (1L << STRING_LITERAL) | (1L << IDENT))) != 0)) ) {
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u009a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2$\n\2\f"+
		"\2\16\2\'\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\62\n\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\5\4C\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5L\n\5\f\5\16\5O\13\5\3\5\5\5R\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\5\6Y\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7c\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\5\ny\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0083\n\13"+
		"\f\13\16\13\u0086\13\13\3\13\3\13\3\f\3\f\7\f\u008c\n\f\f\f\16\f\u008f"+
		"\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\2\2\17\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\2\3\3\2\25\30\2\u009f\2\34\3\2\2\2\4\61\3\2\2\2\6B"+
		"\3\2\2\2\bD\3\2\2\2\nX\3\2\2\2\fZ\3\2\2\2\16d\3\2\2\2\20l\3\2\2\2\22r"+
		"\3\2\2\2\24z\3\2\2\2\26\u0089\3\2\2\2\30\u0092\3\2\2\2\32\u0097\3\2\2"+
		"\2\34\35\7\3\2\2\35\36\7\24\2\2\36\37\7\30\2\2\37 \7\4\2\2 !\7\27\2\2"+
		"!%\7\5\2\2\"$\5\4\3\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2"+
		"\2\2\'%\3\2\2\2()\7\6\2\2)*\7\2\2\3*\3\3\2\2\2+\62\5\6\4\2,\62\5\b\5\2"+
		"-\62\5\22\n\2.\62\5\16\b\2/\62\5\20\t\2\60\62\5\24\13\2\61+\3\2\2\2\61"+
		",\3\2\2\2\61-\3\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2"+
		"\2\63\64\7\7\2\2\64\65\7\30\2\2\65\66\7\b\2\2\66\67\7\30\2\2\67C\5\26"+
		"\f\289\7\7\2\29>\7\30\2\2:;\7\t\2\2;=\7\30\2\2<:\3\2\2\2=@\3\2\2\2><\3"+
		"\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AC\7\n\2\2B\63\3\2\2\2B8\3\2\2\2C"+
		"\7\3\2\2\2DE\7\13\2\2EF\7\30\2\2FG\7\b\2\2GQ\7\30\2\2HR\7\n\2\2IM\7\5"+
		"\2\2JL\5\n\6\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2\2\2OM\3\2"+
		"\2\2PR\7\6\2\2QH\3\2\2\2QI\3\2\2\2R\t\3\2\2\2SY\5\b\5\2TY\5\f\7\2UY\5"+
		"\16\b\2VY\5\22\n\2WY\5\30\r\2XS\3\2\2\2XT\3\2\2\2XU\3\2\2\2XV\3\2\2\2"+
		"XW\3\2\2\2Y\13\3\2\2\2Z[\7\f\2\2[\\\7\30\2\2\\]\7\b\2\2]^\7\30\2\2^_\7"+
		"\r\2\2_b\7\30\2\2`c\7\n\2\2ac\5\26\f\2b`\3\2\2\2ba\3\2\2\2c\r\3\2\2\2"+
		"de\7\16\2\2ef\7\30\2\2fg\7\b\2\2gj\7\30\2\2hk\7\n\2\2ik\5\26\f\2jh\3\2"+
		"\2\2ji\3\2\2\2k\17\3\2\2\2lm\7\f\2\2mn\7\30\2\2no\7\17\2\2op\7\30\2\2"+
		"pq\7\n\2\2q\21\3\2\2\2rs\7\20\2\2st\7\30\2\2tu\7\b\2\2ux\7\30\2\2vy\7"+
		"\n\2\2wy\5\26\f\2xv\3\2\2\2xw\3\2\2\2y\23\3\2\2\2z{\7\21\2\2{|\7\30\2"+
		"\2|}\7\22\2\2}~\7\30\2\2~\177\7\17\2\2\177\u0084\7\30\2\2\u0080\u0081"+
		"\7\t\2\2\u0081\u0083\7\30\2\2\u0082\u0080\3\2\2\2\u0083\u0086\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084"+
		"\3\2\2\2\u0087\u0088\7\n\2\2\u0088\25\3\2\2\2\u0089\u008d\7\5\2\2\u008a"+
		"\u008c\5\30\r\2\u008b\u008a\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3"+
		"\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090"+
		"\u0091\7\6\2\2\u0091\27\3\2\2\2\u0092\u0093\7\30\2\2\u0093\u0094\7\23"+
		"\2\2\u0094\u0095\5\32\16\2\u0095\u0096\7\n\2\2\u0096\31\3\2\2\2\u0097"+
		"\u0098\t\2\2\2\u0098\33\3\2\2\2\16%\61>BMQXbjx\u0084\u008d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}