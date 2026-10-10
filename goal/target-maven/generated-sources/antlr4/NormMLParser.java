// Generated from NormML.g4 by ANTLR 4.9.3
 package org.vnu.sme.goal.dsl.normml.parser; 
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NormMLParser extends Parser {
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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		IDENT=81, STRING=82, LINE_COMMENT=83, BLOCK_COMMENT=84, WS=85;
	public static final int
		RULE_model = 0, RULE_declaration = 1, RULE_organizationDecl = 2, RULE_organizationProperty = 3, 
		RULE_agentDecl = 4, RULE_agentProperty = 5, RULE_roleDecl = 6, RULE_roleProperty = 7, 
		RULE_dataTypeDecl = 8, RULE_entityResourceDecl = 9, RULE_entityResourceProperty = 10, 
		RULE_attributeResourceDecl = 11, RULE_attributeResourceProperty = 12, 
		RULE_associationEndResourceDecl = 13, RULE_associationEndResourceProperty = 14, 
		RULE_agentActionDecl = 15, RULE_agentActionProperty = 16, RULE_messageResourceDecl = 17, 
		RULE_messageResourceProperty = 18, RULE_atomicActionDecl = 19, RULE_atomicActionProperty = 20, 
		RULE_compositeActionDecl = 21, RULE_compositeActionProperty = 22, RULE_normDecl = 23, 
		RULE_normProperty = 24, RULE_beforeDecl = 25, RULE_beforeProperty = 26, 
		RULE_afterDecl = 27, RULE_afterProperty = 28, RULE_betweenDecl = 29, RULE_betweenProperty = 30, 
		RULE_ifDecl = 31, RULE_ifProperty = 32, RULE_dateDecl = 33, RULE_sanctionDecl = 34, 
		RULE_sanctionProperty = 35, RULE_conditionDecl = 36, RULE_conditionBodyProperty = 37, 
		RULE_nameProperty = 38, RULE_descriptionProperty = 39, RULE_dateValueProperty = 40, 
		RULE_condExprProperty = 41, RULE_condLangProperty = 42, RULE_normTypeProperty = 43, 
		RULE_sanctionTypeProperty = 44, RULE_atomicKindProperty = 45, RULE_compositeKindProperty = 46, 
		RULE_normType = 47, RULE_sanctionType = 48, RULE_atomicActionKind = 49, 
		RULE_compositeActionKind = 50, RULE_subOrganizationsProperty = 51, RULE_parentProperty = 52, 
		RULE_rolesProperty = 53, RULE_agentsProperty = 54, RULE_organizationsProperty = 55, 
		RULE_organizationPropertyRef = 56, RULE_playersProperty = 57, RULE_playsProperty = 58, 
		RULE_resourcesProperty = 59, RULE_actionsProperty = 60, RULE_dataTypeProperty = 61, 
		RULE_resourceProperty = 62, RULE_normsProperty = 63, RULE_conditionProperty = 64, 
		RULE_subordinateActionsProperty = 65, RULE_accessProperty = 66, RULE_constraintsProperty = 67, 
		RULE_sanctionsProperty = 68, RULE_activatedByProperty = 69, RULE_normPropertyRef = 70, 
		RULE_datesProperty = 71, RULE_beforeActionsProperty = 72, RULE_afterActionsProperty = 73, 
		RULE_startDateProperty = 74, RULE_endDateProperty = 75, RULE_sanctionedNormsProperty = 76, 
		RULE_activatedNormsProperty = 77, RULE_reference = 78, RULE_referenceList = 79;
	private static String[] makeRuleNames() {
		return new String[] {
			"model", "declaration", "organizationDecl", "organizationProperty", "agentDecl", 
			"agentProperty", "roleDecl", "roleProperty", "dataTypeDecl", "entityResourceDecl", 
			"entityResourceProperty", "attributeResourceDecl", "attributeResourceProperty", 
			"associationEndResourceDecl", "associationEndResourceProperty", "agentActionDecl", 
			"agentActionProperty", "messageResourceDecl", "messageResourceProperty", 
			"atomicActionDecl", "atomicActionProperty", "compositeActionDecl", "compositeActionProperty", 
			"normDecl", "normProperty", "beforeDecl", "beforeProperty", "afterDecl", 
			"afterProperty", "betweenDecl", "betweenProperty", "ifDecl", "ifProperty", 
			"dateDecl", "sanctionDecl", "sanctionProperty", "conditionDecl", "conditionBodyProperty", 
			"nameProperty", "descriptionProperty", "dateValueProperty", "condExprProperty", 
			"condLangProperty", "normTypeProperty", "sanctionTypeProperty", "atomicKindProperty", 
			"compositeKindProperty", "normType", "sanctionType", "atomicActionKind", 
			"compositeActionKind", "subOrganizationsProperty", "parentProperty", 
			"rolesProperty", "agentsProperty", "organizationsProperty", "organizationPropertyRef", 
			"playersProperty", "playsProperty", "resourcesProperty", "actionsProperty", 
			"dataTypeProperty", "resourceProperty", "normsProperty", "conditionProperty", 
			"subordinateActionsProperty", "accessProperty", "constraintsProperty", 
			"sanctionsProperty", "activatedByProperty", "normPropertyRef", "datesProperty", 
			"beforeActionsProperty", "afterActionsProperty", "startDateProperty", 
			"endDateProperty", "sanctionedNormsProperty", "activatedNormsProperty", 
			"reference", "referenceList"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'normml'", "'{'", "'}'", "'Organization'", "'Agent'", "'Role'", 
			"'DataType'", "'EntityResource'", "'AttributeResource'", "'AssociationEndResource'", 
			"'AgentAction'", "'MessageResource'", "'AtomicAction'", "'CompositeAction'", 
			"'Norm'", "'Before'", "'After'", "'Between'", "'If'", "'Date'", "'Sanction'", 
			"'Condition'", "'name'", "':'", "';'", "'description'", "'value'", "'condExpr'", 
			"'condLang'", "'type'", "'kind'", "'NormProhibition'", "'NormPermission'", 
			"'NormObligation'", "'Punishment'", "'Reward'", "'AtomicCreate'", "'AtomicRead'", 
			"'AtomicUpdate'", "'AtomicDelete'", "'AtomicExecute'", "'AtomicSend'", 
			"'AtomicReceive'", "'EntityRead'", "'EntityUpdate'", "'EntityFullAccess'", 
			"'AttributeFullAccess'", "'AssociationEndFullAccess'", "'MessageFullAccess'", 
			"'subOrganizations'", "'parent'", "'roles'", "'agents'", "'organizations'", 
			"'organization'", "'players'", "'plays'", "'resources'", "'actions'", 
			"'dataType'", "'resource'", "'norms'", "'condition'", "'subordinateActions'", 
			"'access'", "'constraints'", "'sanctions'", "'activatedBy'", "'norm'", 
			"'dates'", "'beforeActions'", "'afterActions'", "'startDate'", "'endDate'", 
			"'sanctionedNorms'", "'activatedNorms'", "'@'", "'['", "','", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "IDENT", "STRING", 
			"LINE_COMMENT", "BLOCK_COMMENT", "WS"
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
	public String getGrammarFileName() { return "NormML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NormMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ModelContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public TerminalNode EOF() { return getToken(NormMLParser.EOF, 0); }
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public ModelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_model; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterModel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitModel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitModel(this);
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
			setState(160);
			match(T__0);
			setState(161);
			match(IDENT);
			setState(162);
			match(T__1);
			setState(166);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) {
				{
				{
				setState(163);
				declaration();
				}
				}
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			match(T__2);
			setState(170);
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

	public static class DeclarationContext extends ParserRuleContext {
		public OrganizationDeclContext organizationDecl() {
			return getRuleContext(OrganizationDeclContext.class,0);
		}
		public AgentDeclContext agentDecl() {
			return getRuleContext(AgentDeclContext.class,0);
		}
		public RoleDeclContext roleDecl() {
			return getRuleContext(RoleDeclContext.class,0);
		}
		public DataTypeDeclContext dataTypeDecl() {
			return getRuleContext(DataTypeDeclContext.class,0);
		}
		public EntityResourceDeclContext entityResourceDecl() {
			return getRuleContext(EntityResourceDeclContext.class,0);
		}
		public AttributeResourceDeclContext attributeResourceDecl() {
			return getRuleContext(AttributeResourceDeclContext.class,0);
		}
		public AssociationEndResourceDeclContext associationEndResourceDecl() {
			return getRuleContext(AssociationEndResourceDeclContext.class,0);
		}
		public AgentActionDeclContext agentActionDecl() {
			return getRuleContext(AgentActionDeclContext.class,0);
		}
		public MessageResourceDeclContext messageResourceDecl() {
			return getRuleContext(MessageResourceDeclContext.class,0);
		}
		public AtomicActionDeclContext atomicActionDecl() {
			return getRuleContext(AtomicActionDeclContext.class,0);
		}
		public CompositeActionDeclContext compositeActionDecl() {
			return getRuleContext(CompositeActionDeclContext.class,0);
		}
		public NormDeclContext normDecl() {
			return getRuleContext(NormDeclContext.class,0);
		}
		public BeforeDeclContext beforeDecl() {
			return getRuleContext(BeforeDeclContext.class,0);
		}
		public AfterDeclContext afterDecl() {
			return getRuleContext(AfterDeclContext.class,0);
		}
		public BetweenDeclContext betweenDecl() {
			return getRuleContext(BetweenDeclContext.class,0);
		}
		public IfDeclContext ifDecl() {
			return getRuleContext(IfDeclContext.class,0);
		}
		public DateDeclContext dateDecl() {
			return getRuleContext(DateDeclContext.class,0);
		}
		public SanctionDeclContext sanctionDecl() {
			return getRuleContext(SanctionDeclContext.class,0);
		}
		public ConditionDeclContext conditionDecl() {
			return getRuleContext(ConditionDeclContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declaration);
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				organizationDecl();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				agentDecl();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				roleDecl();
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				dataTypeDecl();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				entityResourceDecl();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				attributeResourceDecl();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				associationEndResourceDecl();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				agentActionDecl();
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 9);
				{
				setState(180);
				messageResourceDecl();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 10);
				{
				setState(181);
				atomicActionDecl();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 11);
				{
				setState(182);
				compositeActionDecl();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 12);
				{
				setState(183);
				normDecl();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 13);
				{
				setState(184);
				beforeDecl();
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 14);
				{
				setState(185);
				afterDecl();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 15);
				{
				setState(186);
				betweenDecl();
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 16);
				{
				setState(187);
				ifDecl();
				}
				break;
			case T__19:
				enterOuterAlt(_localctx, 17);
				{
				setState(188);
				dateDecl();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 18);
				{
				setState(189);
				sanctionDecl();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 19);
				{
				setState(190);
				conditionDecl();
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

	public static class OrganizationDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<OrganizationPropertyContext> organizationProperty() {
			return getRuleContexts(OrganizationPropertyContext.class);
		}
		public OrganizationPropertyContext organizationProperty(int i) {
			return getRuleContext(OrganizationPropertyContext.class,i);
		}
		public OrganizationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_organizationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterOrganizationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitOrganizationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitOrganizationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrganizationDeclContext organizationDecl() throws RecognitionException {
		OrganizationDeclContext _localctx = new OrganizationDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_organizationDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__3);
			setState(194);
			match(IDENT);
			setState(195);
			match(T__1);
			setState(199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__57) | (1L << T__61))) != 0)) {
				{
				{
				setState(196);
				organizationProperty();
				}
				}
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(202);
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

	public static class OrganizationPropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public SubOrganizationsPropertyContext subOrganizationsProperty() {
			return getRuleContext(SubOrganizationsPropertyContext.class,0);
		}
		public ParentPropertyContext parentProperty() {
			return getRuleContext(ParentPropertyContext.class,0);
		}
		public RolesPropertyContext rolesProperty() {
			return getRuleContext(RolesPropertyContext.class,0);
		}
		public NormsPropertyContext normsProperty() {
			return getRuleContext(NormsPropertyContext.class,0);
		}
		public ResourcesPropertyContext resourcesProperty() {
			return getRuleContext(ResourcesPropertyContext.class,0);
		}
		public OrganizationPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_organizationProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterOrganizationProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitOrganizationProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitOrganizationProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrganizationPropertyContext organizationProperty() throws RecognitionException {
		OrganizationPropertyContext _localctx = new OrganizationPropertyContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_organizationProperty);
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				nameProperty();
				}
				break;
			case T__49:
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				subOrganizationsProperty();
				}
				break;
			case T__50:
				enterOuterAlt(_localctx, 3);
				{
				setState(206);
				parentProperty();
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				rolesProperty();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 5);
				{
				setState(208);
				normsProperty();
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 6);
				{
				setState(209);
				resourcesProperty();
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
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AgentPropertyContext> agentProperty() {
			return getRuleContexts(AgentPropertyContext.class);
		}
		public AgentPropertyContext agentProperty(int i) {
			return getRuleContext(AgentPropertyContext.class,i);
		}
		public AgentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAgentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAgentDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAgentDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentDeclContext agentDecl() throws RecognitionException {
		AgentDeclContext _localctx = new AgentDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_agentDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__4);
			setState(213);
			match(IDENT);
			setState(214);
			match(T__1);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__56) | (1L << T__57) | (1L << T__61))) != 0)) {
				{
				{
				setState(215);
				agentProperty();
				}
				}
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(221);
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

	public static class AgentPropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public PlaysPropertyContext playsProperty() {
			return getRuleContext(PlaysPropertyContext.class,0);
		}
		public NormsPropertyContext normsProperty() {
			return getRuleContext(NormsPropertyContext.class,0);
		}
		public ResourcesPropertyContext resourcesProperty() {
			return getRuleContext(ResourcesPropertyContext.class,0);
		}
		public AgentPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAgentProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAgentProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAgentProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentPropertyContext agentProperty() throws RecognitionException {
		AgentPropertyContext _localctx = new AgentPropertyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_agentProperty);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				nameProperty();
				}
				break;
			case T__56:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				playsProperty();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				normsProperty();
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 4);
				{
				setState(226);
				resourcesProperty();
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

	public static class RoleDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<RolePropertyContext> roleProperty() {
			return getRuleContexts(RolePropertyContext.class);
		}
		public RolePropertyContext roleProperty(int i) {
			return getRuleContext(RolePropertyContext.class,i);
		}
		public RoleDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roleDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterRoleDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitRoleDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitRoleDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RoleDeclContext roleDecl() throws RecognitionException {
		RoleDeclContext _localctx = new RoleDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_roleDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__5);
			setState(230);
			match(IDENT);
			setState(231);
			match(T__1);
			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__54) | (1L << T__55) | (1L << T__57) | (1L << T__61))) != 0)) {
				{
				{
				setState(232);
				roleProperty();
				}
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(238);
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

	public static class RolePropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public OrganizationPropertyRefContext organizationPropertyRef() {
			return getRuleContext(OrganizationPropertyRefContext.class,0);
		}
		public PlayersPropertyContext playersProperty() {
			return getRuleContext(PlayersPropertyContext.class,0);
		}
		public NormsPropertyContext normsProperty() {
			return getRuleContext(NormsPropertyContext.class,0);
		}
		public ResourcesPropertyContext resourcesProperty() {
			return getRuleContext(ResourcesPropertyContext.class,0);
		}
		public RolePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_roleProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterRoleProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitRoleProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitRoleProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RolePropertyContext roleProperty() throws RecognitionException {
		RolePropertyContext _localctx = new RolePropertyContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_roleProperty);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				nameProperty();
				}
				break;
			case T__54:
				enterOuterAlt(_localctx, 2);
				{
				setState(241);
				organizationPropertyRef();
				}
				break;
			case T__55:
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				playersProperty();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 4);
				{
				setState(243);
				normsProperty();
				}
				break;
			case T__57:
				enterOuterAlt(_localctx, 5);
				{
				setState(244);
				resourcesProperty();
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

	public static class DataTypeDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<NamePropertyContext> nameProperty() {
			return getRuleContexts(NamePropertyContext.class);
		}
		public NamePropertyContext nameProperty(int i) {
			return getRuleContext(NamePropertyContext.class,i);
		}
		public DataTypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDataTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDataTypeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDataTypeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypeDeclContext dataTypeDecl() throws RecognitionException {
		DataTypeDeclContext _localctx = new DataTypeDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dataTypeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__6);
			setState(248);
			match(IDENT);
			setState(249);
			match(T__1);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22) {
				{
				{
				setState(250);
				nameProperty();
				}
				}
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(256);
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

	public static class EntityResourceDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<EntityResourcePropertyContext> entityResourceProperty() {
			return getRuleContexts(EntityResourcePropertyContext.class);
		}
		public EntityResourcePropertyContext entityResourceProperty(int i) {
			return getRuleContext(EntityResourcePropertyContext.class,i);
		}
		public EntityResourceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityResourceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterEntityResourceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitEntityResourceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitEntityResourceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityResourceDeclContext entityResourceDecl() throws RecognitionException {
		EntityResourceDeclContext _localctx = new EntityResourceDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_entityResourceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__7);
			setState(259);
			match(IDENT);
			setState(260);
			match(T__1);
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__58) {
				{
				{
				setState(261);
				entityResourceProperty();
				}
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(267);
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

	public static class EntityResourcePropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public ActionsPropertyContext actionsProperty() {
			return getRuleContext(ActionsPropertyContext.class,0);
		}
		public EntityResourcePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityResourceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterEntityResourceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitEntityResourceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitEntityResourceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityResourcePropertyContext entityResourceProperty() throws RecognitionException {
		EntityResourcePropertyContext _localctx = new EntityResourcePropertyContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_entityResourceProperty);
		try {
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(269);
				nameProperty();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(270);
				actionsProperty();
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

	public static class AttributeResourceDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AttributeResourcePropertyContext> attributeResourceProperty() {
			return getRuleContexts(AttributeResourcePropertyContext.class);
		}
		public AttributeResourcePropertyContext attributeResourceProperty(int i) {
			return getRuleContext(AttributeResourcePropertyContext.class,i);
		}
		public AttributeResourceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeResourceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAttributeResourceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAttributeResourceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAttributeResourceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeResourceDeclContext attributeResourceDecl() throws RecognitionException {
		AttributeResourceDeclContext _localctx = new AttributeResourceDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeResourceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			match(T__8);
			setState(274);
			match(IDENT);
			setState(275);
			match(T__1);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
				{
				setState(276);
				attributeResourceProperty();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
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

	public static class AttributeResourcePropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public ActionsPropertyContext actionsProperty() {
			return getRuleContext(ActionsPropertyContext.class,0);
		}
		public DataTypePropertyContext dataTypeProperty() {
			return getRuleContext(DataTypePropertyContext.class,0);
		}
		public AttributeResourcePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeResourceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAttributeResourceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAttributeResourceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAttributeResourceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeResourcePropertyContext attributeResourceProperty() throws RecognitionException {
		AttributeResourcePropertyContext _localctx = new AttributeResourcePropertyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attributeResourceProperty);
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				nameProperty();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				actionsProperty();
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				dataTypeProperty();
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

	public static class AssociationEndResourceDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AssociationEndResourcePropertyContext> associationEndResourceProperty() {
			return getRuleContexts(AssociationEndResourcePropertyContext.class);
		}
		public AssociationEndResourcePropertyContext associationEndResourceProperty(int i) {
			return getRuleContext(AssociationEndResourcePropertyContext.class,i);
		}
		public AssociationEndResourceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationEndResourceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAssociationEndResourceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAssociationEndResourceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAssociationEndResourceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociationEndResourceDeclContext associationEndResourceDecl() throws RecognitionException {
		AssociationEndResourceDeclContext _localctx = new AssociationEndResourceDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_associationEndResourceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(T__9);
			setState(290);
			match(IDENT);
			setState(291);
			match(T__1);
			setState(295);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__58) {
				{
				{
				setState(292);
				associationEndResourceProperty();
				}
				}
				setState(297);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(298);
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

	public static class AssociationEndResourcePropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public ActionsPropertyContext actionsProperty() {
			return getRuleContext(ActionsPropertyContext.class,0);
		}
		public AssociationEndResourcePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_associationEndResourceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAssociationEndResourceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAssociationEndResourceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAssociationEndResourceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssociationEndResourcePropertyContext associationEndResourceProperty() throws RecognitionException {
		AssociationEndResourcePropertyContext _localctx = new AssociationEndResourcePropertyContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_associationEndResourceProperty);
		try {
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				nameProperty();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				actionsProperty();
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

	public static class AgentActionDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AgentActionPropertyContext> agentActionProperty() {
			return getRuleContexts(AgentActionPropertyContext.class);
		}
		public AgentActionPropertyContext agentActionProperty(int i) {
			return getRuleContext(AgentActionPropertyContext.class,i);
		}
		public AgentActionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentActionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAgentActionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAgentActionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAgentActionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentActionDeclContext agentActionDecl() throws RecognitionException {
		AgentActionDeclContext _localctx = new AgentActionDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_agentActionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(T__10);
			setState(305);
			match(IDENT);
			setState(306);
			match(T__1);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__22 || _la==T__58) {
				{
				{
				setState(307);
				agentActionProperty();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
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

	public static class AgentActionPropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public ActionsPropertyContext actionsProperty() {
			return getRuleContext(ActionsPropertyContext.class,0);
		}
		public AgentActionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentActionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAgentActionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAgentActionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAgentActionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentActionPropertyContext agentActionProperty() throws RecognitionException {
		AgentActionPropertyContext _localctx = new AgentActionPropertyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_agentActionProperty);
		try {
			setState(317);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(315);
				nameProperty();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(316);
				actionsProperty();
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

	public static class MessageResourceDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<MessageResourcePropertyContext> messageResourceProperty() {
			return getRuleContexts(MessageResourcePropertyContext.class);
		}
		public MessageResourcePropertyContext messageResourceProperty(int i) {
			return getRuleContext(MessageResourcePropertyContext.class,i);
		}
		public MessageResourceDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageResourceDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterMessageResourceDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitMessageResourceDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitMessageResourceDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageResourceDeclContext messageResourceDecl() throws RecognitionException {
		MessageResourceDeclContext _localctx = new MessageResourceDeclContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_messageResourceDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(T__11);
			setState(320);
			match(IDENT);
			setState(321);
			match(T__1);
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__58) | (1L << T__59))) != 0)) {
				{
				{
				setState(322);
				messageResourceProperty();
				}
				}
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(328);
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

	public static class MessageResourcePropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public ActionsPropertyContext actionsProperty() {
			return getRuleContext(ActionsPropertyContext.class,0);
		}
		public DataTypePropertyContext dataTypeProperty() {
			return getRuleContext(DataTypePropertyContext.class,0);
		}
		public MessageResourcePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_messageResourceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterMessageResourceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitMessageResourceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitMessageResourceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MessageResourcePropertyContext messageResourceProperty() throws RecognitionException {
		MessageResourcePropertyContext _localctx = new MessageResourcePropertyContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_messageResourceProperty);
		try {
			setState(333);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				nameProperty();
				}
				break;
			case T__58:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				actionsProperty();
				}
				break;
			case T__59:
				enterOuterAlt(_localctx, 3);
				{
				setState(332);
				dataTypeProperty();
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

	public static class AtomicActionDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AtomicActionPropertyContext> atomicActionProperty() {
			return getRuleContexts(AtomicActionPropertyContext.class);
		}
		public AtomicActionPropertyContext atomicActionProperty(int i) {
			return getRuleContext(AtomicActionPropertyContext.class,i);
		}
		public AtomicActionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicActionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAtomicActionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAtomicActionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAtomicActionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicActionDeclContext atomicActionDecl() throws RecognitionException {
		AtomicActionDeclContext _localctx = new AtomicActionDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atomicActionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(T__12);
			setState(336);
			match(IDENT);
			setState(337);
			match(T__1);
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__30) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0)) {
				{
				{
				setState(338);
				atomicActionProperty();
				}
				}
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(344);
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

	public static class AtomicActionPropertyContext extends ParserRuleContext {
		public AtomicKindPropertyContext atomicKindProperty() {
			return getRuleContext(AtomicKindPropertyContext.class,0);
		}
		public ResourcePropertyContext resourceProperty() {
			return getRuleContext(ResourcePropertyContext.class,0);
		}
		public NormsPropertyContext normsProperty() {
			return getRuleContext(NormsPropertyContext.class,0);
		}
		public ConditionPropertyContext conditionProperty() {
			return getRuleContext(ConditionPropertyContext.class,0);
		}
		public AtomicActionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicActionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAtomicActionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAtomicActionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAtomicActionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicActionPropertyContext atomicActionProperty() throws RecognitionException {
		AtomicActionPropertyContext _localctx = new AtomicActionPropertyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atomicActionProperty);
		try {
			setState(350);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				atomicKindProperty();
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				resourceProperty();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 3);
				{
				setState(348);
				normsProperty();
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 4);
				{
				setState(349);
				conditionProperty();
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

	public static class CompositeActionDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<CompositeActionPropertyContext> compositeActionProperty() {
			return getRuleContexts(CompositeActionPropertyContext.class);
		}
		public CompositeActionPropertyContext compositeActionProperty(int i) {
			return getRuleContext(CompositeActionPropertyContext.class,i);
		}
		public CompositeActionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeActionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCompositeActionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCompositeActionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCompositeActionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeActionDeclContext compositeActionDecl() throws RecognitionException {
		CompositeActionDeclContext _localctx = new CompositeActionDeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_compositeActionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(T__13);
			setState(353);
			match(IDENT);
			setState(354);
			match(T__1);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 31)) & ~0x3f) == 0 && ((1L << (_la - 31)) & ((1L << (T__30 - 31)) | (1L << (T__60 - 31)) | (1L << (T__61 - 31)) | (1L << (T__62 - 31)) | (1L << (T__63 - 31)))) != 0)) {
				{
				{
				setState(355);
				compositeActionProperty();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(361);
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

	public static class CompositeActionPropertyContext extends ParserRuleContext {
		public CompositeKindPropertyContext compositeKindProperty() {
			return getRuleContext(CompositeKindPropertyContext.class,0);
		}
		public ResourcePropertyContext resourceProperty() {
			return getRuleContext(ResourcePropertyContext.class,0);
		}
		public NormsPropertyContext normsProperty() {
			return getRuleContext(NormsPropertyContext.class,0);
		}
		public ConditionPropertyContext conditionProperty() {
			return getRuleContext(ConditionPropertyContext.class,0);
		}
		public SubordinateActionsPropertyContext subordinateActionsProperty() {
			return getRuleContext(SubordinateActionsPropertyContext.class,0);
		}
		public CompositeActionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeActionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCompositeActionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCompositeActionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCompositeActionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeActionPropertyContext compositeActionProperty() throws RecognitionException {
		CompositeActionPropertyContext _localctx = new CompositeActionPropertyContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_compositeActionProperty);
		try {
			setState(368);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(363);
				compositeKindProperty();
				}
				break;
			case T__60:
				enterOuterAlt(_localctx, 2);
				{
				setState(364);
				resourceProperty();
				}
				break;
			case T__61:
				enterOuterAlt(_localctx, 3);
				{
				setState(365);
				normsProperty();
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 4);
				{
				setState(366);
				conditionProperty();
				}
				break;
			case T__63:
				enterOuterAlt(_localctx, 5);
				{
				setState(367);
				subordinateActionsProperty();
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

	public static class NormDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<NormPropertyContext> normProperty() {
			return getRuleContexts(NormPropertyContext.class);
		}
		public NormPropertyContext normProperty(int i) {
			return getRuleContext(NormPropertyContext.class,i);
		}
		public NormDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormDeclContext normDecl() throws RecognitionException {
		NormDeclContext _localctx = new NormDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_normDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__14);
			setState(371);
			match(IDENT);
			setState(372);
			match(T__1);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 23)) & ~0x3f) == 0 && ((1L << (_la - 23)) & ((1L << (T__22 - 23)) | (1L << (T__29 - 23)) | (1L << (T__51 - 23)) | (1L << (T__52 - 23)) | (1L << (T__53 - 23)) | (1L << (T__64 - 23)) | (1L << (T__65 - 23)) | (1L << (T__66 - 23)) | (1L << (T__67 - 23)))) != 0)) {
				{
				{
				setState(373);
				normProperty();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(379);
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

	public static class NormPropertyContext extends ParserRuleContext {
		public NamePropertyContext nameProperty() {
			return getRuleContext(NamePropertyContext.class,0);
		}
		public NormTypePropertyContext normTypeProperty() {
			return getRuleContext(NormTypePropertyContext.class,0);
		}
		public AccessPropertyContext accessProperty() {
			return getRuleContext(AccessPropertyContext.class,0);
		}
		public ConstraintsPropertyContext constraintsProperty() {
			return getRuleContext(ConstraintsPropertyContext.class,0);
		}
		public SanctionsPropertyContext sanctionsProperty() {
			return getRuleContext(SanctionsPropertyContext.class,0);
		}
		public ActivatedByPropertyContext activatedByProperty() {
			return getRuleContext(ActivatedByPropertyContext.class,0);
		}
		public RolesPropertyContext rolesProperty() {
			return getRuleContext(RolesPropertyContext.class,0);
		}
		public AgentsPropertyContext agentsProperty() {
			return getRuleContext(AgentsPropertyContext.class,0);
		}
		public OrganizationsPropertyContext organizationsProperty() {
			return getRuleContext(OrganizationsPropertyContext.class,0);
		}
		public NormPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormPropertyContext normProperty() throws RecognitionException {
		NormPropertyContext _localctx = new NormPropertyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_normProperty);
		try {
			setState(390);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(381);
				nameProperty();
				}
				break;
			case T__29:
				enterOuterAlt(_localctx, 2);
				{
				setState(382);
				normTypeProperty();
				}
				break;
			case T__64:
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				accessProperty();
				}
				break;
			case T__65:
				enterOuterAlt(_localctx, 4);
				{
				setState(384);
				constraintsProperty();
				}
				break;
			case T__66:
				enterOuterAlt(_localctx, 5);
				{
				setState(385);
				sanctionsProperty();
				}
				break;
			case T__67:
				enterOuterAlt(_localctx, 6);
				{
				setState(386);
				activatedByProperty();
				}
				break;
			case T__51:
				enterOuterAlt(_localctx, 7);
				{
				setState(387);
				rolesProperty();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 8);
				{
				setState(388);
				agentsProperty();
				}
				break;
			case T__53:
				enterOuterAlt(_localctx, 9);
				{
				setState(389);
				organizationsProperty();
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

	public static class BeforeDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<BeforePropertyContext> beforeProperty() {
			return getRuleContexts(BeforePropertyContext.class);
		}
		public BeforePropertyContext beforeProperty(int i) {
			return getRuleContext(BeforePropertyContext.class,i);
		}
		public BeforeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterBeforeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitBeforeDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitBeforeDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeDeclContext beforeDecl() throws RecognitionException {
		BeforeDeclContext _localctx = new BeforeDeclContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_beforeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(T__15);
			setState(393);
			match(IDENT);
			setState(394);
			match(T__1);
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)))) != 0)) {
				{
				{
				setState(395);
				beforeProperty();
				}
				}
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(401);
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

	public static class BeforePropertyContext extends ParserRuleContext {
		public NormPropertyRefContext normPropertyRef() {
			return getRuleContext(NormPropertyRefContext.class,0);
		}
		public DatesPropertyContext datesProperty() {
			return getRuleContext(DatesPropertyContext.class,0);
		}
		public BeforeActionsPropertyContext beforeActionsProperty() {
			return getRuleContext(BeforeActionsPropertyContext.class,0);
		}
		public BeforePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterBeforeProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitBeforeProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitBeforeProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforePropertyContext beforeProperty() throws RecognitionException {
		BeforePropertyContext _localctx = new BeforePropertyContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_beforeProperty);
		try {
			setState(406);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(403);
				normPropertyRef();
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 2);
				{
				setState(404);
				datesProperty();
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 3);
				{
				setState(405);
				beforeActionsProperty();
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

	public static class AfterDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<AfterPropertyContext> afterProperty() {
			return getRuleContexts(AfterPropertyContext.class);
		}
		public AfterPropertyContext afterProperty(int i) {
			return getRuleContext(AfterPropertyContext.class,i);
		}
		public AfterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAfterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAfterDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAfterDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterDeclContext afterDecl() throws RecognitionException {
		AfterDeclContext _localctx = new AfterDeclContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_afterDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(T__16);
			setState(409);
			match(IDENT);
			setState(410);
			match(T__1);
			setState(414);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__71 - 69)))) != 0)) {
				{
				{
				setState(411);
				afterProperty();
				}
				}
				setState(416);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(417);
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

	public static class AfterPropertyContext extends ParserRuleContext {
		public NormPropertyRefContext normPropertyRef() {
			return getRuleContext(NormPropertyRefContext.class,0);
		}
		public DatesPropertyContext datesProperty() {
			return getRuleContext(DatesPropertyContext.class,0);
		}
		public AfterActionsPropertyContext afterActionsProperty() {
			return getRuleContext(AfterActionsPropertyContext.class,0);
		}
		public AfterPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAfterProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAfterProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAfterProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterPropertyContext afterProperty() throws RecognitionException {
		AfterPropertyContext _localctx = new AfterPropertyContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_afterProperty);
		try {
			setState(422);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				normPropertyRef();
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 2);
				{
				setState(420);
				datesProperty();
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 3);
				{
				setState(421);
				afterActionsProperty();
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

	public static class BetweenDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<BetweenPropertyContext> betweenProperty() {
			return getRuleContexts(BetweenPropertyContext.class);
		}
		public BetweenPropertyContext betweenProperty(int i) {
			return getRuleContext(BetweenPropertyContext.class,i);
		}
		public BetweenDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterBetweenDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitBetweenDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitBetweenDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenDeclContext betweenDecl() throws RecognitionException {
		BetweenDeclContext _localctx = new BetweenDeclContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_betweenDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			match(T__17);
			setState(425);
			match(IDENT);
			setState(426);
			match(T__1);
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)) | (1L << (T__72 - 69)) | (1L << (T__73 - 69)))) != 0)) {
				{
				{
				setState(427);
				betweenProperty();
				}
				}
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(433);
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

	public static class BetweenPropertyContext extends ParserRuleContext {
		public NormPropertyRefContext normPropertyRef() {
			return getRuleContext(NormPropertyRefContext.class,0);
		}
		public DatesPropertyContext datesProperty() {
			return getRuleContext(DatesPropertyContext.class,0);
		}
		public AfterActionsPropertyContext afterActionsProperty() {
			return getRuleContext(AfterActionsPropertyContext.class,0);
		}
		public BeforeActionsPropertyContext beforeActionsProperty() {
			return getRuleContext(BeforeActionsPropertyContext.class,0);
		}
		public StartDatePropertyContext startDateProperty() {
			return getRuleContext(StartDatePropertyContext.class,0);
		}
		public EndDatePropertyContext endDateProperty() {
			return getRuleContext(EndDatePropertyContext.class,0);
		}
		public BetweenPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterBetweenProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitBetweenProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitBetweenProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenPropertyContext betweenProperty() throws RecognitionException {
		BetweenPropertyContext _localctx = new BetweenPropertyContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_betweenProperty);
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				normPropertyRef();
				}
				break;
			case T__69:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				datesProperty();
				}
				break;
			case T__71:
				enterOuterAlt(_localctx, 3);
				{
				setState(437);
				afterActionsProperty();
				}
				break;
			case T__70:
				enterOuterAlt(_localctx, 4);
				{
				setState(438);
				beforeActionsProperty();
				}
				break;
			case T__72:
				enterOuterAlt(_localctx, 5);
				{
				setState(439);
				startDateProperty();
				}
				break;
			case T__73:
				enterOuterAlt(_localctx, 6);
				{
				setState(440);
				endDateProperty();
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

	public static class IfDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<IfPropertyContext> ifProperty() {
			return getRuleContexts(IfPropertyContext.class);
		}
		public IfPropertyContext ifProperty(int i) {
			return getRuleContext(IfPropertyContext.class,i);
		}
		public IfDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterIfDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitIfDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitIfDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfDeclContext ifDecl() throws RecognitionException {
		IfDeclContext _localctx = new IfDeclContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_ifDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(443);
			match(T__18);
			setState(444);
			match(IDENT);
			setState(445);
			match(T__1);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__62 || _la==T__68) {
				{
				{
				setState(446);
				ifProperty();
				}
				}
				setState(451);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(452);
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

	public static class IfPropertyContext extends ParserRuleContext {
		public NormPropertyRefContext normPropertyRef() {
			return getRuleContext(NormPropertyRefContext.class,0);
		}
		public ConditionPropertyContext conditionProperty() {
			return getRuleContext(ConditionPropertyContext.class,0);
		}
		public IfPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterIfProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitIfProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitIfProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfPropertyContext ifProperty() throws RecognitionException {
		IfPropertyContext _localctx = new IfPropertyContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_ifProperty);
		try {
			setState(456);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__68:
				enterOuterAlt(_localctx, 1);
				{
				setState(454);
				normPropertyRef();
				}
				break;
			case T__62:
				enterOuterAlt(_localctx, 2);
				{
				setState(455);
				conditionProperty();
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

	public static class DateDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<DateValuePropertyContext> dateValueProperty() {
			return getRuleContexts(DateValuePropertyContext.class);
		}
		public DateValuePropertyContext dateValueProperty(int i) {
			return getRuleContext(DateValuePropertyContext.class,i);
		}
		public DateDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDateDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDateDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDateDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateDeclContext dateDecl() throws RecognitionException {
		DateDeclContext _localctx = new DateDeclContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_dateDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(458);
			match(T__19);
			setState(459);
			match(IDENT);
			setState(460);
			match(T__1);
			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__26) {
				{
				{
				setState(461);
				dateValueProperty();
				}
				}
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(467);
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

	public static class SanctionDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<SanctionPropertyContext> sanctionProperty() {
			return getRuleContexts(SanctionPropertyContext.class);
		}
		public SanctionPropertyContext sanctionProperty(int i) {
			return getRuleContext(SanctionPropertyContext.class,i);
		}
		public SanctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionDeclContext sanctionDecl() throws RecognitionException {
		SanctionDeclContext _localctx = new SanctionDeclContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sanctionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			match(T__20);
			setState(470);
			match(IDENT);
			setState(471);
			match(T__1);
			setState(475);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 26)) & ~0x3f) == 0 && ((1L << (_la - 26)) & ((1L << (T__25 - 26)) | (1L << (T__29 - 26)) | (1L << (T__74 - 26)) | (1L << (T__75 - 26)))) != 0)) {
				{
				{
				setState(472);
				sanctionProperty();
				}
				}
				setState(477);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(478);
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

	public static class SanctionPropertyContext extends ParserRuleContext {
		public SanctionTypePropertyContext sanctionTypeProperty() {
			return getRuleContext(SanctionTypePropertyContext.class,0);
		}
		public DescriptionPropertyContext descriptionProperty() {
			return getRuleContext(DescriptionPropertyContext.class,0);
		}
		public SanctionedNormsPropertyContext sanctionedNormsProperty() {
			return getRuleContext(SanctionedNormsPropertyContext.class,0);
		}
		public ActivatedNormsPropertyContext activatedNormsProperty() {
			return getRuleContext(ActivatedNormsPropertyContext.class,0);
		}
		public SanctionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionPropertyContext sanctionProperty() throws RecognitionException {
		SanctionPropertyContext _localctx = new SanctionPropertyContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_sanctionProperty);
		try {
			setState(484);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__29:
				enterOuterAlt(_localctx, 1);
				{
				setState(480);
				sanctionTypeProperty();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 2);
				{
				setState(481);
				descriptionProperty();
				}
				break;
			case T__74:
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				sanctionedNormsProperty();
				}
				break;
			case T__75:
				enterOuterAlt(_localctx, 4);
				{
				setState(483);
				activatedNormsProperty();
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

	public static class ConditionDeclContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public List<ConditionBodyPropertyContext> conditionBodyProperty() {
			return getRuleContexts(ConditionBodyPropertyContext.class);
		}
		public ConditionBodyPropertyContext conditionBodyProperty(int i) {
			return getRuleContext(ConditionBodyPropertyContext.class,i);
		}
		public ConditionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterConditionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitConditionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitConditionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionDeclContext conditionDecl() throws RecognitionException {
		ConditionDeclContext _localctx = new ConditionDeclContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_conditionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(T__21);
			setState(487);
			match(IDENT);
			setState(488);
			match(T__1);
			setState(492);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__27 || _la==T__28) {
				{
				{
				setState(489);
				conditionBodyProperty();
				}
				}
				setState(494);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(495);
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

	public static class ConditionBodyPropertyContext extends ParserRuleContext {
		public CondExprPropertyContext condExprProperty() {
			return getRuleContext(CondExprPropertyContext.class,0);
		}
		public CondLangPropertyContext condLangProperty() {
			return getRuleContext(CondLangPropertyContext.class,0);
		}
		public ConditionBodyPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionBodyProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterConditionBodyProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitConditionBodyProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitConditionBodyProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionBodyPropertyContext conditionBodyProperty() throws RecognitionException {
		ConditionBodyPropertyContext _localctx = new ConditionBodyPropertyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_conditionBodyProperty);
		try {
			setState(499);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__27:
				enterOuterAlt(_localctx, 1);
				{
				setState(497);
				condExprProperty();
				}
				break;
			case T__28:
				enterOuterAlt(_localctx, 2);
				{
				setState(498);
				condLangProperty();
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

	public static class NamePropertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(NormMLParser.STRING, 0); }
		public NamePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nameProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNameProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNameProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNameProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamePropertyContext nameProperty() throws RecognitionException {
		NamePropertyContext _localctx = new NamePropertyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_nameProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501);
			match(T__22);
			setState(502);
			match(T__23);
			setState(503);
			match(STRING);
			setState(504);
			match(T__24);
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

	public static class DescriptionPropertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(NormMLParser.STRING, 0); }
		public DescriptionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDescriptionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDescriptionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDescriptionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionPropertyContext descriptionProperty() throws RecognitionException {
		DescriptionPropertyContext _localctx = new DescriptionPropertyContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_descriptionProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			match(T__25);
			setState(507);
			match(T__23);
			setState(508);
			match(STRING);
			setState(509);
			match(T__24);
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

	public static class DateValuePropertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(NormMLParser.STRING, 0); }
		public DateValuePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateValueProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDateValueProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDateValueProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDateValueProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateValuePropertyContext dateValueProperty() throws RecognitionException {
		DateValuePropertyContext _localctx = new DateValuePropertyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_dateValueProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(T__26);
			setState(512);
			match(T__23);
			setState(513);
			match(STRING);
			setState(514);
			match(T__24);
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

	public static class CondExprPropertyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(NormMLParser.STRING, 0); }
		public CondExprPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condExprProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCondExprProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCondExprProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCondExprProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondExprPropertyContext condExprProperty() throws RecognitionException {
		CondExprPropertyContext _localctx = new CondExprPropertyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_condExprProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(516);
			match(T__27);
			setState(517);
			match(T__23);
			setState(518);
			match(STRING);
			setState(519);
			match(T__24);
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

	public static class CondLangPropertyContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public CondLangPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condLangProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCondLangProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCondLangProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCondLangProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondLangPropertyContext condLangProperty() throws RecognitionException {
		CondLangPropertyContext _localctx = new CondLangPropertyContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_condLangProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(521);
			match(T__28);
			setState(522);
			match(T__23);
			setState(523);
			match(IDENT);
			setState(524);
			match(T__24);
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

	public static class NormTypePropertyContext extends ParserRuleContext {
		public NormTypeContext normType() {
			return getRuleContext(NormTypeContext.class,0);
		}
		public NormTypePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normTypeProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormTypeProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormTypeProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormTypeProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormTypePropertyContext normTypeProperty() throws RecognitionException {
		NormTypePropertyContext _localctx = new NormTypePropertyContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_normTypeProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526);
			match(T__29);
			setState(527);
			match(T__23);
			setState(528);
			normType();
			setState(529);
			match(T__24);
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

	public static class SanctionTypePropertyContext extends ParserRuleContext {
		public SanctionTypeContext sanctionType() {
			return getRuleContext(SanctionTypeContext.class,0);
		}
		public SanctionTypePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionTypeProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionTypeProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionTypeProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionTypeProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionTypePropertyContext sanctionTypeProperty() throws RecognitionException {
		SanctionTypePropertyContext _localctx = new SanctionTypePropertyContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_sanctionTypeProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(T__29);
			setState(532);
			match(T__23);
			setState(533);
			sanctionType();
			setState(534);
			match(T__24);
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

	public static class AtomicKindPropertyContext extends ParserRuleContext {
		public AtomicActionKindContext atomicActionKind() {
			return getRuleContext(AtomicActionKindContext.class,0);
		}
		public AtomicKindPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicKindProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAtomicKindProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAtomicKindProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAtomicKindProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicKindPropertyContext atomicKindProperty() throws RecognitionException {
		AtomicKindPropertyContext _localctx = new AtomicKindPropertyContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_atomicKindProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(T__30);
			setState(537);
			match(T__23);
			setState(538);
			atomicActionKind();
			setState(539);
			match(T__24);
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

	public static class CompositeKindPropertyContext extends ParserRuleContext {
		public CompositeActionKindContext compositeActionKind() {
			return getRuleContext(CompositeActionKindContext.class,0);
		}
		public CompositeKindPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeKindProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCompositeKindProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCompositeKindProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCompositeKindProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeKindPropertyContext compositeKindProperty() throws RecognitionException {
		CompositeKindPropertyContext _localctx = new CompositeKindPropertyContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_compositeKindProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			match(T__30);
			setState(542);
			match(T__23);
			setState(543);
			compositeActionKind();
			setState(544);
			match(T__24);
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

	public static class NormTypeContext extends ParserRuleContext {
		public NormTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormTypeContext normType() throws RecognitionException {
		NormTypeContext _localctx = new NormTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_normType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(546);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
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

	public static class SanctionTypeContext extends ParserRuleContext {
		public SanctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionTypeContext sanctionType() throws RecognitionException {
		SanctionTypeContext _localctx = new SanctionTypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_sanctionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_la = _input.LA(1);
			if ( !(_la==T__34 || _la==T__35) ) {
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

	public static class AtomicActionKindContext extends ParserRuleContext {
		public AtomicActionKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicActionKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAtomicActionKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAtomicActionKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAtomicActionKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicActionKindContext atomicActionKind() throws RecognitionException {
		AtomicActionKindContext _localctx = new AtomicActionKindContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_atomicActionKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42))) != 0)) ) {
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

	public static class CompositeActionKindContext extends ParserRuleContext {
		public CompositeActionKindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositeActionKind; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterCompositeActionKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitCompositeActionKind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitCompositeActionKind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompositeActionKindContext compositeActionKind() throws RecognitionException {
		CompositeActionKindContext _localctx = new CompositeActionKindContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_compositeActionKind);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(552);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48))) != 0)) ) {
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

	public static class SubOrganizationsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public SubOrganizationsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subOrganizationsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSubOrganizationsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSubOrganizationsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSubOrganizationsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubOrganizationsPropertyContext subOrganizationsProperty() throws RecognitionException {
		SubOrganizationsPropertyContext _localctx = new SubOrganizationsPropertyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_subOrganizationsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(T__49);
			setState(555);
			match(T__23);
			setState(556);
			referenceList();
			setState(557);
			match(T__24);
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

	public static class ParentPropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ParentPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterParentProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitParentProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitParentProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentPropertyContext parentProperty() throws RecognitionException {
		ParentPropertyContext _localctx = new ParentPropertyContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_parentProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			match(T__50);
			setState(560);
			match(T__23);
			setState(561);
			reference();
			setState(562);
			match(T__24);
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

	public static class RolesPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public RolesPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rolesProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterRolesProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitRolesProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitRolesProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RolesPropertyContext rolesProperty() throws RecognitionException {
		RolesPropertyContext _localctx = new RolesPropertyContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_rolesProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			match(T__51);
			setState(565);
			match(T__23);
			setState(566);
			referenceList();
			setState(567);
			match(T__24);
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

	public static class AgentsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public AgentsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agentsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAgentsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAgentsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAgentsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AgentsPropertyContext agentsProperty() throws RecognitionException {
		AgentsPropertyContext _localctx = new AgentsPropertyContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_agentsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(569);
			match(T__52);
			setState(570);
			match(T__23);
			setState(571);
			referenceList();
			setState(572);
			match(T__24);
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

	public static class OrganizationsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public OrganizationsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_organizationsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterOrganizationsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitOrganizationsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitOrganizationsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrganizationsPropertyContext organizationsProperty() throws RecognitionException {
		OrganizationsPropertyContext _localctx = new OrganizationsPropertyContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_organizationsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			match(T__53);
			setState(575);
			match(T__23);
			setState(576);
			referenceList();
			setState(577);
			match(T__24);
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

	public static class OrganizationPropertyRefContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public OrganizationPropertyRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_organizationPropertyRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterOrganizationPropertyRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitOrganizationPropertyRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitOrganizationPropertyRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OrganizationPropertyRefContext organizationPropertyRef() throws RecognitionException {
		OrganizationPropertyRefContext _localctx = new OrganizationPropertyRefContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_organizationPropertyRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(T__54);
			setState(580);
			match(T__23);
			setState(581);
			reference();
			setState(582);
			match(T__24);
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

	public static class PlayersPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public PlayersPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playersProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterPlayersProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitPlayersProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitPlayersProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlayersPropertyContext playersProperty() throws RecognitionException {
		PlayersPropertyContext _localctx = new PlayersPropertyContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_playersProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			match(T__55);
			setState(585);
			match(T__23);
			setState(586);
			referenceList();
			setState(587);
			match(T__24);
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

	public static class PlaysPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public PlaysPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_playsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterPlaysProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitPlaysProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitPlaysProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlaysPropertyContext playsProperty() throws RecognitionException {
		PlaysPropertyContext _localctx = new PlaysPropertyContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_playsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(T__56);
			setState(590);
			match(T__23);
			setState(591);
			referenceList();
			setState(592);
			match(T__24);
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

	public static class ResourcesPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public ResourcesPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourcesProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterResourcesProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitResourcesProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitResourcesProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcesPropertyContext resourcesProperty() throws RecognitionException {
		ResourcesPropertyContext _localctx = new ResourcesPropertyContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_resourcesProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			match(T__57);
			setState(595);
			match(T__23);
			setState(596);
			referenceList();
			setState(597);
			match(T__24);
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

	public static class ActionsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public ActionsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actionsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterActionsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitActionsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitActionsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActionsPropertyContext actionsProperty() throws RecognitionException {
		ActionsPropertyContext _localctx = new ActionsPropertyContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_actionsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			match(T__58);
			setState(600);
			match(T__23);
			setState(601);
			referenceList();
			setState(602);
			match(T__24);
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

	public static class DataTypePropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public DataTypePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataTypeProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDataTypeProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDataTypeProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDataTypeProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataTypePropertyContext dataTypeProperty() throws RecognitionException {
		DataTypePropertyContext _localctx = new DataTypePropertyContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_dataTypeProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			match(T__59);
			setState(605);
			match(T__23);
			setState(606);
			reference();
			setState(607);
			match(T__24);
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

	public static class ResourcePropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ResourcePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterResourceProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitResourceProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitResourceProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ResourcePropertyContext resourceProperty() throws RecognitionException {
		ResourcePropertyContext _localctx = new ResourcePropertyContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_resourceProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			match(T__60);
			setState(610);
			match(T__23);
			setState(611);
			reference();
			setState(612);
			match(T__24);
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

	public static class NormsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public NormsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormsPropertyContext normsProperty() throws RecognitionException {
		NormsPropertyContext _localctx = new NormsPropertyContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_normsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(614);
			match(T__61);
			setState(615);
			match(T__23);
			setState(616);
			referenceList();
			setState(617);
			match(T__24);
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

	public static class ConditionPropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public ConditionPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterConditionProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitConditionProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitConditionProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionPropertyContext conditionProperty() throws RecognitionException {
		ConditionPropertyContext _localctx = new ConditionPropertyContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_conditionProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(T__62);
			setState(620);
			match(T__23);
			setState(621);
			reference();
			setState(622);
			match(T__24);
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

	public static class SubordinateActionsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public SubordinateActionsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subordinateActionsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSubordinateActionsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSubordinateActionsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSubordinateActionsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubordinateActionsPropertyContext subordinateActionsProperty() throws RecognitionException {
		SubordinateActionsPropertyContext _localctx = new SubordinateActionsPropertyContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_subordinateActionsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(T__63);
			setState(625);
			match(T__23);
			setState(626);
			referenceList();
			setState(627);
			match(T__24);
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

	public static class AccessPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public AccessPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accessProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAccessProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAccessProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAccessProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessPropertyContext accessProperty() throws RecognitionException {
		AccessPropertyContext _localctx = new AccessPropertyContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_accessProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(629);
			match(T__64);
			setState(630);
			match(T__23);
			setState(631);
			referenceList();
			setState(632);
			match(T__24);
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

	public static class ConstraintsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public ConstraintsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterConstraintsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitConstraintsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitConstraintsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintsPropertyContext constraintsProperty() throws RecognitionException {
		ConstraintsPropertyContext _localctx = new ConstraintsPropertyContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_constraintsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			match(T__65);
			setState(635);
			match(T__23);
			setState(636);
			referenceList();
			setState(637);
			match(T__24);
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

	public static class SanctionsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public SanctionsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionsPropertyContext sanctionsProperty() throws RecognitionException {
		SanctionsPropertyContext _localctx = new SanctionsPropertyContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_sanctionsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			match(T__66);
			setState(640);
			match(T__23);
			setState(641);
			referenceList();
			setState(642);
			match(T__24);
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

	public static class ActivatedByPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public ActivatedByPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activatedByProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterActivatedByProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitActivatedByProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitActivatedByProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActivatedByPropertyContext activatedByProperty() throws RecognitionException {
		ActivatedByPropertyContext _localctx = new ActivatedByPropertyContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_activatedByProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			match(T__67);
			setState(645);
			match(T__23);
			setState(646);
			referenceList();
			setState(647);
			match(T__24);
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

	public static class NormPropertyRefContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public NormPropertyRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normPropertyRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterNormPropertyRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitNormPropertyRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitNormPropertyRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NormPropertyRefContext normPropertyRef() throws RecognitionException {
		NormPropertyRefContext _localctx = new NormPropertyRefContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_normPropertyRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(649);
			match(T__68);
			setState(650);
			match(T__23);
			setState(651);
			reference();
			setState(652);
			match(T__24);
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

	public static class DatesPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public DatesPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datesProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterDatesProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitDatesProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitDatesProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatesPropertyContext datesProperty() throws RecognitionException {
		DatesPropertyContext _localctx = new DatesPropertyContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_datesProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			match(T__69);
			setState(655);
			match(T__23);
			setState(656);
			referenceList();
			setState(657);
			match(T__24);
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

	public static class BeforeActionsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public BeforeActionsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_beforeActionsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterBeforeActionsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitBeforeActionsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitBeforeActionsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BeforeActionsPropertyContext beforeActionsProperty() throws RecognitionException {
		BeforeActionsPropertyContext _localctx = new BeforeActionsPropertyContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_beforeActionsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
			match(T__70);
			setState(660);
			match(T__23);
			setState(661);
			referenceList();
			setState(662);
			match(T__24);
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

	public static class AfterActionsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public AfterActionsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_afterActionsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterAfterActionsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitAfterActionsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitAfterActionsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AfterActionsPropertyContext afterActionsProperty() throws RecognitionException {
		AfterActionsPropertyContext _localctx = new AfterActionsPropertyContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_afterActionsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(664);
			match(T__71);
			setState(665);
			match(T__23);
			setState(666);
			referenceList();
			setState(667);
			match(T__24);
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

	public static class StartDatePropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public StartDatePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_startDateProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterStartDateProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitStartDateProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitStartDateProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartDatePropertyContext startDateProperty() throws RecognitionException {
		StartDatePropertyContext _localctx = new StartDatePropertyContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_startDateProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(669);
			match(T__72);
			setState(670);
			match(T__23);
			setState(671);
			reference();
			setState(672);
			match(T__24);
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

	public static class EndDatePropertyContext extends ParserRuleContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public EndDatePropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_endDateProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterEndDateProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitEndDateProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitEndDateProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EndDatePropertyContext endDateProperty() throws RecognitionException {
		EndDatePropertyContext _localctx = new EndDatePropertyContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_endDateProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(674);
			match(T__73);
			setState(675);
			match(T__23);
			setState(676);
			reference();
			setState(677);
			match(T__24);
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

	public static class SanctionedNormsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public SanctionedNormsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sanctionedNormsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterSanctionedNormsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitSanctionedNormsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitSanctionedNormsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SanctionedNormsPropertyContext sanctionedNormsProperty() throws RecognitionException {
		SanctionedNormsPropertyContext _localctx = new SanctionedNormsPropertyContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_sanctionedNormsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			match(T__74);
			setState(680);
			match(T__23);
			setState(681);
			referenceList();
			setState(682);
			match(T__24);
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

	public static class ActivatedNormsPropertyContext extends ParserRuleContext {
		public ReferenceListContext referenceList() {
			return getRuleContext(ReferenceListContext.class,0);
		}
		public ActivatedNormsPropertyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_activatedNormsProperty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterActivatedNormsProperty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitActivatedNormsProperty(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitActivatedNormsProperty(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ActivatedNormsPropertyContext activatedNormsProperty() throws RecognitionException {
		ActivatedNormsPropertyContext _localctx = new ActivatedNormsPropertyContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_activatedNormsProperty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			match(T__75);
			setState(685);
			match(T__23);
			setState(686);
			referenceList();
			setState(687);
			match(T__24);
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

	public static class ReferenceContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(NormMLParser.IDENT, 0); }
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(689);
			match(T__76);
			setState(690);
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

	public static class ReferenceListContext extends ParserRuleContext {
		public List<ReferenceContext> reference() {
			return getRuleContexts(ReferenceContext.class);
		}
		public ReferenceContext reference(int i) {
			return getRuleContext(ReferenceContext.class,i);
		}
		public ReferenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).enterReferenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NormMLListener ) ((NormMLListener)listener).exitReferenceList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NormMLVisitor ) return ((NormMLVisitor<? extends T>)visitor).visitReferenceList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceListContext referenceList() throws RecognitionException {
		ReferenceListContext _localctx = new ReferenceListContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_referenceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(692);
			match(T__77);
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__76) {
				{
				setState(693);
				reference();
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__78) {
					{
					{
					setState(694);
					match(T__78);
					setState(695);
					reference();
					}
					}
					setState(700);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(703);
			match(T__79);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3W\u02c4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\3\2\3\2\3\2\3\2\7"+
		"\2\u00a7\n\2\f\2\16\2\u00aa\13\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\u00c2\n\3\3\4\3"+
		"\4\3\4\3\4\7\4\u00c8\n\4\f\4\16\4\u00cb\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\5\5\u00d5\n\5\3\6\3\6\3\6\3\6\7\6\u00db\n\6\f\6\16\6\u00de\13\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u00e6\n\7\3\b\3\b\3\b\3\b\7\b\u00ec\n\b\f"+
		"\b\16\b\u00ef\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u00f8\n\t\3\n\3\n\3"+
		"\n\3\n\7\n\u00fe\n\n\f\n\16\n\u0101\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7"+
		"\13\u0109\n\13\f\13\16\13\u010c\13\13\3\13\3\13\3\f\3\f\5\f\u0112\n\f"+
		"\3\r\3\r\3\r\3\r\7\r\u0118\n\r\f\r\16\r\u011b\13\r\3\r\3\r\3\16\3\16\3"+
		"\16\5\16\u0122\n\16\3\17\3\17\3\17\3\17\7\17\u0128\n\17\f\17\16\17\u012b"+
		"\13\17\3\17\3\17\3\20\3\20\5\20\u0131\n\20\3\21\3\21\3\21\3\21\7\21\u0137"+
		"\n\21\f\21\16\21\u013a\13\21\3\21\3\21\3\22\3\22\5\22\u0140\n\22\3\23"+
		"\3\23\3\23\3\23\7\23\u0146\n\23\f\23\16\23\u0149\13\23\3\23\3\23\3\24"+
		"\3\24\3\24\5\24\u0150\n\24\3\25\3\25\3\25\3\25\7\25\u0156\n\25\f\25\16"+
		"\25\u0159\13\25\3\25\3\25\3\26\3\26\3\26\3\26\5\26\u0161\n\26\3\27\3\27"+
		"\3\27\3\27\7\27\u0167\n\27\f\27\16\27\u016a\13\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u0173\n\30\3\31\3\31\3\31\3\31\7\31\u0179\n\31\f"+
		"\31\16\31\u017c\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u0189\n\32\3\33\3\33\3\33\3\33\7\33\u018f\n\33\f\33\16\33\u0192"+
		"\13\33\3\33\3\33\3\34\3\34\3\34\5\34\u0199\n\34\3\35\3\35\3\35\3\35\7"+
		"\35\u019f\n\35\f\35\16\35\u01a2\13\35\3\35\3\35\3\36\3\36\3\36\5\36\u01a9"+
		"\n\36\3\37\3\37\3\37\3\37\7\37\u01af\n\37\f\37\16\37\u01b2\13\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \3 \5 \u01bc\n \3!\3!\3!\3!\7!\u01c2\n!\f!\16!\u01c5"+
		"\13!\3!\3!\3\"\3\"\5\"\u01cb\n\"\3#\3#\3#\3#\7#\u01d1\n#\f#\16#\u01d4"+
		"\13#\3#\3#\3$\3$\3$\3$\7$\u01dc\n$\f$\16$\u01df\13$\3$\3$\3%\3%\3%\3%"+
		"\5%\u01e7\n%\3&\3&\3&\3&\7&\u01ed\n&\f&\16&\u01f0\13&\3&\3&\3\'\3\'\5"+
		"\'\u01f6\n\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+"+
		"\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3"+
		"\60\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\3"+
		"\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38"+
		"\38\38\38\39\39\39\39\39\3:\3:\3:\3:\3:\3;\3;\3;\3;\3;\3<\3<\3<\3<\3<"+
		"\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3?\3?\3?\3?\3?\3@\3@\3@\3@\3@\3A\3A\3A"+
		"\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3F"+
		"\3F\3F\3F\3F\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3J\3J\3J\3J"+
		"\3J\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3M\3M\3M\3M\3M\3N\3N\3N\3N\3N\3O\3O"+
		"\3O\3O\3O\3P\3P\3P\3Q\3Q\3Q\3Q\7Q\u02bb\nQ\fQ\16Q\u02be\13Q\5Q\u02c0\n"+
		"Q\3Q\3Q\3Q\2\2R\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\2\6\3\2\"$\3\2%&\3\2\'-\3\2.\63\2\u02cb\2\u00a2\3\2\2\2\4\u00c1\3\2\2"+
		"\2\6\u00c3\3\2\2\2\b\u00d4\3\2\2\2\n\u00d6\3\2\2\2\f\u00e5\3\2\2\2\16"+
		"\u00e7\3\2\2\2\20\u00f7\3\2\2\2\22\u00f9\3\2\2\2\24\u0104\3\2\2\2\26\u0111"+
		"\3\2\2\2\30\u0113\3\2\2\2\32\u0121\3\2\2\2\34\u0123\3\2\2\2\36\u0130\3"+
		"\2\2\2 \u0132\3\2\2\2\"\u013f\3\2\2\2$\u0141\3\2\2\2&\u014f\3\2\2\2(\u0151"+
		"\3\2\2\2*\u0160\3\2\2\2,\u0162\3\2\2\2.\u0172\3\2\2\2\60\u0174\3\2\2\2"+
		"\62\u0188\3\2\2\2\64\u018a\3\2\2\2\66\u0198\3\2\2\28\u019a\3\2\2\2:\u01a8"+
		"\3\2\2\2<\u01aa\3\2\2\2>\u01bb\3\2\2\2@\u01bd\3\2\2\2B\u01ca\3\2\2\2D"+
		"\u01cc\3\2\2\2F\u01d7\3\2\2\2H\u01e6\3\2\2\2J\u01e8\3\2\2\2L\u01f5\3\2"+
		"\2\2N\u01f7\3\2\2\2P\u01fc\3\2\2\2R\u0201\3\2\2\2T\u0206\3\2\2\2V\u020b"+
		"\3\2\2\2X\u0210\3\2\2\2Z\u0215\3\2\2\2\\\u021a\3\2\2\2^\u021f\3\2\2\2"+
		"`\u0224\3\2\2\2b\u0226\3\2\2\2d\u0228\3\2\2\2f\u022a\3\2\2\2h\u022c\3"+
		"\2\2\2j\u0231\3\2\2\2l\u0236\3\2\2\2n\u023b\3\2\2\2p\u0240\3\2\2\2r\u0245"+
		"\3\2\2\2t\u024a\3\2\2\2v\u024f\3\2\2\2x\u0254\3\2\2\2z\u0259\3\2\2\2|"+
		"\u025e\3\2\2\2~\u0263\3\2\2\2\u0080\u0268\3\2\2\2\u0082\u026d\3\2\2\2"+
		"\u0084\u0272\3\2\2\2\u0086\u0277\3\2\2\2\u0088\u027c\3\2\2\2\u008a\u0281"+
		"\3\2\2\2\u008c\u0286\3\2\2\2\u008e\u028b\3\2\2\2\u0090\u0290\3\2\2\2\u0092"+
		"\u0295\3\2\2\2\u0094\u029a\3\2\2\2\u0096\u029f\3\2\2\2\u0098\u02a4\3\2"+
		"\2\2\u009a\u02a9\3\2\2\2\u009c\u02ae\3\2\2\2\u009e\u02b3\3\2\2\2\u00a0"+
		"\u02b6\3\2\2\2\u00a2\u00a3\7\3\2\2\u00a3\u00a4\7S\2\2\u00a4\u00a8\7\4"+
		"\2\2\u00a5\u00a7\5\4\3\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8"+
		"\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a8\3\2"+
		"\2\2\u00ab\u00ac\7\5\2\2\u00ac\u00ad\7\2\2\3\u00ad\3\3\2\2\2\u00ae\u00c2"+
		"\5\6\4\2\u00af\u00c2\5\n\6\2\u00b0\u00c2\5\16\b\2\u00b1\u00c2\5\22\n\2"+
		"\u00b2\u00c2\5\24\13\2\u00b3\u00c2\5\30\r\2\u00b4\u00c2\5\34\17\2\u00b5"+
		"\u00c2\5 \21\2\u00b6\u00c2\5$\23\2\u00b7\u00c2\5(\25\2\u00b8\u00c2\5,"+
		"\27\2\u00b9\u00c2\5\60\31\2\u00ba\u00c2\5\64\33\2\u00bb\u00c2\58\35\2"+
		"\u00bc\u00c2\5<\37\2\u00bd\u00c2\5@!\2\u00be\u00c2\5D#\2\u00bf\u00c2\5"+
		"F$\2\u00c0\u00c2\5J&\2\u00c1\u00ae\3\2\2\2\u00c1\u00af\3\2\2\2\u00c1\u00b0"+
		"\3\2\2\2\u00c1\u00b1\3\2\2\2\u00c1\u00b2\3\2\2\2\u00c1\u00b3\3\2\2\2\u00c1"+
		"\u00b4\3\2\2\2\u00c1\u00b5\3\2\2\2\u00c1\u00b6\3\2\2\2\u00c1\u00b7\3\2"+
		"\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00ba\3\2\2\2\u00c1"+
		"\u00bb\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c1\u00be\3\2"+
		"\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\5\3\2\2\2\u00c3\u00c4"+
		"\7\6\2\2\u00c4\u00c5\7S\2\2\u00c5\u00c9\7\4\2\2\u00c6\u00c8\5\b\5\2\u00c7"+
		"\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9\u00ca\3\2"+
		"\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7\5\2\2\u00cd"+
		"\7\3\2\2\2\u00ce\u00d5\5N(\2\u00cf\u00d5\5h\65\2\u00d0\u00d5\5j\66\2\u00d1"+
		"\u00d5\5l\67\2\u00d2\u00d5\5\u0080A\2\u00d3\u00d5\5x=\2\u00d4\u00ce\3"+
		"\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d1\3\2\2\2\u00d4"+
		"\u00d2\3\2\2\2\u00d4\u00d3\3\2\2\2\u00d5\t\3\2\2\2\u00d6\u00d7\7\7\2\2"+
		"\u00d7\u00d8\7S\2\2\u00d8\u00dc\7\4\2\2\u00d9\u00db\5\f\7\2\u00da\u00d9"+
		"\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\u00df\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\7\5\2\2\u00e0\13\3\2\2"+
		"\2\u00e1\u00e6\5N(\2\u00e2\u00e6\5v<\2\u00e3\u00e6\5\u0080A\2\u00e4\u00e6"+
		"\5x=\2\u00e5\u00e1\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6\r\3\2\2\2\u00e7\u00e8\7\b\2\2\u00e8\u00e9\7S\2\2"+
		"\u00e9\u00ed\7\4\2\2\u00ea\u00ec\5\20\t\2\u00eb\u00ea\3\2\2\2\u00ec\u00ef"+
		"\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f1\7\5\2\2\u00f1\17\3\2\2\2\u00f2\u00f8\5N(\2"+
		"\u00f3\u00f8\5r:\2\u00f4\u00f8\5t;\2\u00f5\u00f8\5\u0080A\2\u00f6\u00f8"+
		"\5x=\2\u00f7\u00f2\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f7\u00f4\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\21\3\2\2\2\u00f9\u00fa\7\t\2"+
		"\2\u00fa\u00fb\7S\2\2\u00fb\u00ff\7\4\2\2\u00fc\u00fe\5N(\2\u00fd\u00fc"+
		"\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0102\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0103\7\5\2\2\u0103\23\3\2\2"+
		"\2\u0104\u0105\7\n\2\2\u0105\u0106\7S\2\2\u0106\u010a\7\4\2\2\u0107\u0109"+
		"\5\26\f\2\u0108\u0107\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2"+
		"\u010a\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010a\3\2\2\2\u010d\u010e"+
		"\7\5\2\2\u010e\25\3\2\2\2\u010f\u0112\5N(\2\u0110\u0112\5z>\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0110\3\2\2\2\u0112\27\3\2\2\2\u0113\u0114\7\13\2\2\u0114"+
		"\u0115\7S\2\2\u0115\u0119\7\4\2\2\u0116\u0118\5\32\16\2\u0117\u0116\3"+
		"\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a"+
		"\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\5\2\2\u011d\31\3\2\2"+
		"\2\u011e\u0122\5N(\2\u011f\u0122\5z>\2\u0120\u0122\5|?\2\u0121\u011e\3"+
		"\2\2\2\u0121\u011f\3\2\2\2\u0121\u0120\3\2\2\2\u0122\33\3\2\2\2\u0123"+
		"\u0124\7\f\2\2\u0124\u0125\7S\2\2\u0125\u0129\7\4\2\2\u0126\u0128\5\36"+
		"\20\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012c\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u012d\7\5"+
		"\2\2\u012d\35\3\2\2\2\u012e\u0131\5N(\2\u012f\u0131\5z>\2\u0130\u012e"+
		"\3\2\2\2\u0130\u012f\3\2\2\2\u0131\37\3\2\2\2\u0132\u0133\7\r\2\2\u0133"+
		"\u0134\7S\2\2\u0134\u0138\7\4\2\2\u0135\u0137\5\"\22\2\u0136\u0135\3\2"+
		"\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7\5\2\2\u013c!\3\2\2\2"+
		"\u013d\u0140\5N(\2\u013e\u0140\5z>\2\u013f\u013d\3\2\2\2\u013f\u013e\3"+
		"\2\2\2\u0140#\3\2\2\2\u0141\u0142\7\16\2\2\u0142\u0143\7S\2\2\u0143\u0147"+
		"\7\4\2\2\u0144\u0146\5&\24\2\u0145\u0144\3\2\2\2\u0146\u0149\3\2\2\2\u0147"+
		"\u0145\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3\2\2\2\u0149\u0147\3\2"+
		"\2\2\u014a\u014b\7\5\2\2\u014b%\3\2\2\2\u014c\u0150\5N(\2\u014d\u0150"+
		"\5z>\2\u014e\u0150\5|?\2\u014f\u014c\3\2\2\2\u014f\u014d\3\2\2\2\u014f"+
		"\u014e\3\2\2\2\u0150\'\3\2\2\2\u0151\u0152\7\17\2\2\u0152\u0153\7S\2\2"+
		"\u0153\u0157\7\4\2\2\u0154\u0156\5*\26\2\u0155\u0154\3\2\2\2\u0156\u0159"+
		"\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158\u015a\3\2\2\2\u0159"+
		"\u0157\3\2\2\2\u015a\u015b\7\5\2\2\u015b)\3\2\2\2\u015c\u0161\5\\/\2\u015d"+
		"\u0161\5~@\2\u015e\u0161\5\u0080A\2\u015f\u0161\5\u0082B\2\u0160\u015c"+
		"\3\2\2\2\u0160\u015d\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161"+
		"+\3\2\2\2\u0162\u0163\7\20\2\2\u0163\u0164\7S\2\2\u0164\u0168\7\4\2\2"+
		"\u0165\u0167\5.\30\2\u0166\u0165\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166"+
		"\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016b\3\2\2\2\u016a\u0168\3\2\2\2\u016b"+
		"\u016c\7\5\2\2\u016c-\3\2\2\2\u016d\u0173\5^\60\2\u016e\u0173\5~@\2\u016f"+
		"\u0173\5\u0080A\2\u0170\u0173\5\u0082B\2\u0171\u0173\5\u0084C\2\u0172"+
		"\u016d\3\2\2\2\u0172\u016e\3\2\2\2\u0172\u016f\3\2\2\2\u0172\u0170\3\2"+
		"\2\2\u0172\u0171\3\2\2\2\u0173/\3\2\2\2\u0174\u0175\7\21\2\2\u0175\u0176"+
		"\7S\2\2\u0176\u017a\7\4\2\2\u0177\u0179\5\62\32\2\u0178\u0177\3\2\2\2"+
		"\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017d"+
		"\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\7\5\2\2\u017e\61\3\2\2\2\u017f"+
		"\u0189\5N(\2\u0180\u0189\5X-\2\u0181\u0189\5\u0086D\2\u0182\u0189\5\u0088"+
		"E\2\u0183\u0189\5\u008aF\2\u0184\u0189\5\u008cG\2\u0185\u0189\5l\67\2"+
		"\u0186\u0189\5n8\2\u0187\u0189\5p9\2\u0188\u017f\3\2\2\2\u0188\u0180\3"+
		"\2\2\2\u0188\u0181\3\2\2\2\u0188\u0182\3\2\2\2\u0188\u0183\3\2\2\2\u0188"+
		"\u0184\3\2\2\2\u0188\u0185\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0187\3\2"+
		"\2\2\u0189\63\3\2\2\2\u018a\u018b\7\22\2\2\u018b\u018c\7S\2\2\u018c\u0190"+
		"\7\4\2\2\u018d\u018f\5\66\34\2\u018e\u018d\3\2\2\2\u018f\u0192\3\2\2\2"+
		"\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u0190"+
		"\3\2\2\2\u0193\u0194\7\5\2\2\u0194\65\3\2\2\2\u0195\u0199\5\u008eH\2\u0196"+
		"\u0199\5\u0090I\2\u0197\u0199\5\u0092J\2\u0198\u0195\3\2\2\2\u0198\u0196"+
		"\3\2\2\2\u0198\u0197\3\2\2\2\u0199\67\3\2\2\2\u019a\u019b\7\23\2\2\u019b"+
		"\u019c\7S\2\2\u019c\u01a0\7\4\2\2\u019d\u019f\5:\36\2\u019e\u019d\3\2"+
		"\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a3\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3\u01a4\7\5\2\2\u01a49\3\2\2\2"+
		"\u01a5\u01a9\5\u008eH\2\u01a6\u01a9\5\u0090I\2\u01a7\u01a9\5\u0094K\2"+
		"\u01a8\u01a5\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a7\3\2\2\2\u01a9;\3"+
		"\2\2\2\u01aa\u01ab\7\24\2\2\u01ab\u01ac\7S\2\2\u01ac\u01b0\7\4\2\2\u01ad"+
		"\u01af\5> \2\u01ae\u01ad\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2"+
		"\2\u01b0\u01b1\3\2\2\2\u01b1\u01b3\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b3\u01b4"+
		"\7\5\2\2\u01b4=\3\2\2\2\u01b5\u01bc\5\u008eH\2\u01b6\u01bc\5\u0090I\2"+
		"\u01b7\u01bc\5\u0094K\2\u01b8\u01bc\5\u0092J\2\u01b9\u01bc\5\u0096L\2"+
		"\u01ba\u01bc\5\u0098M\2\u01bb\u01b5\3\2\2\2\u01bb\u01b6\3\2\2\2\u01bb"+
		"\u01b7\3\2\2\2\u01bb\u01b8\3\2\2\2\u01bb\u01b9\3\2\2\2\u01bb\u01ba\3\2"+
		"\2\2\u01bc?\3\2\2\2\u01bd\u01be\7\25\2\2\u01be\u01bf\7S\2\2\u01bf\u01c3"+
		"\7\4\2\2\u01c0\u01c2\5B\"\2\u01c1\u01c0\3\2\2\2\u01c2\u01c5\3\2\2\2\u01c3"+
		"\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01c6\3\2\2\2\u01c5\u01c3\3\2"+
		"\2\2\u01c6\u01c7\7\5\2\2\u01c7A\3\2\2\2\u01c8\u01cb\5\u008eH\2\u01c9\u01cb"+
		"\5\u0082B\2\u01ca\u01c8\3\2\2\2\u01ca\u01c9\3\2\2\2\u01cbC\3\2\2\2\u01cc"+
		"\u01cd\7\26\2\2\u01cd\u01ce\7S\2\2\u01ce\u01d2\7\4\2\2\u01cf\u01d1\5R"+
		"*\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2"+
		"\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d6\7\5"+
		"\2\2\u01d6E\3\2\2\2\u01d7\u01d8\7\27\2\2\u01d8\u01d9\7S\2\2\u01d9\u01dd"+
		"\7\4\2\2\u01da\u01dc\5H%\2\u01db\u01da\3\2\2\2\u01dc\u01df\3\2\2\2\u01dd"+
		"\u01db\3\2\2\2\u01dd\u01de\3\2\2\2\u01de\u01e0\3\2\2\2\u01df\u01dd\3\2"+
		"\2\2\u01e0\u01e1\7\5\2\2\u01e1G\3\2\2\2\u01e2\u01e7\5Z.\2\u01e3\u01e7"+
		"\5P)\2\u01e4\u01e7\5\u009aN\2\u01e5\u01e7\5\u009cO\2\u01e6\u01e2\3\2\2"+
		"\2\u01e6\u01e3\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e6\u01e5\3\2\2\2\u01e7I"+
		"\3\2\2\2\u01e8\u01e9\7\30\2\2\u01e9\u01ea\7S\2\2\u01ea\u01ee\7\4\2\2\u01eb"+
		"\u01ed\5L\'\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee\u01ec\3\2"+
		"\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f1\3\2\2\2\u01f0\u01ee\3\2\2\2\u01f1"+
		"\u01f2\7\5\2\2\u01f2K\3\2\2\2\u01f3\u01f6\5T+\2\u01f4\u01f6\5V,\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f4\3\2\2\2\u01f6M\3\2\2\2\u01f7\u01f8\7\31\2\2"+
		"\u01f8\u01f9\7\32\2\2\u01f9\u01fa\7T\2\2\u01fa\u01fb\7\33\2\2\u01fbO\3"+
		"\2\2\2\u01fc\u01fd\7\34\2\2\u01fd\u01fe\7\32\2\2\u01fe\u01ff\7T\2\2\u01ff"+
		"\u0200\7\33\2\2\u0200Q\3\2\2\2\u0201\u0202\7\35\2\2\u0202\u0203\7\32\2"+
		"\2\u0203\u0204\7T\2\2\u0204\u0205\7\33\2\2\u0205S\3\2\2\2\u0206\u0207"+
		"\7\36\2\2\u0207\u0208\7\32\2\2\u0208\u0209\7T\2\2\u0209\u020a\7\33\2\2"+
		"\u020aU\3\2\2\2\u020b\u020c\7\37\2\2\u020c\u020d\7\32\2\2\u020d\u020e"+
		"\7S\2\2\u020e\u020f\7\33\2\2\u020fW\3\2\2\2\u0210\u0211\7 \2\2\u0211\u0212"+
		"\7\32\2\2\u0212\u0213\5`\61\2\u0213\u0214\7\33\2\2\u0214Y\3\2\2\2\u0215"+
		"\u0216\7 \2\2\u0216\u0217\7\32\2\2\u0217\u0218\5b\62\2\u0218\u0219\7\33"+
		"\2\2\u0219[\3\2\2\2\u021a\u021b\7!\2\2\u021b\u021c\7\32\2\2\u021c\u021d"+
		"\5d\63\2\u021d\u021e\7\33\2\2\u021e]\3\2\2\2\u021f\u0220\7!\2\2\u0220"+
		"\u0221\7\32\2\2\u0221\u0222\5f\64\2\u0222\u0223\7\33\2\2\u0223_\3\2\2"+
		"\2\u0224\u0225\t\2\2\2\u0225a\3\2\2\2\u0226\u0227\t\3\2\2\u0227c\3\2\2"+
		"\2\u0228\u0229\t\4\2\2\u0229e\3\2\2\2\u022a\u022b\t\5\2\2\u022bg\3\2\2"+
		"\2\u022c\u022d\7\64\2\2\u022d\u022e\7\32\2\2\u022e\u022f\5\u00a0Q\2\u022f"+
		"\u0230\7\33\2\2\u0230i\3\2\2\2\u0231\u0232\7\65\2\2\u0232\u0233\7\32\2"+
		"\2\u0233\u0234\5\u009eP\2\u0234\u0235\7\33\2\2\u0235k\3\2\2\2\u0236\u0237"+
		"\7\66\2\2\u0237\u0238\7\32\2\2\u0238\u0239\5\u00a0Q\2\u0239\u023a\7\33"+
		"\2\2\u023am\3\2\2\2\u023b\u023c\7\67\2\2\u023c\u023d\7\32\2\2\u023d\u023e"+
		"\5\u00a0Q\2\u023e\u023f\7\33\2\2\u023fo\3\2\2\2\u0240\u0241\78\2\2\u0241"+
		"\u0242\7\32\2\2\u0242\u0243\5\u00a0Q\2\u0243\u0244\7\33\2\2\u0244q\3\2"+
		"\2\2\u0245\u0246\79\2\2\u0246\u0247\7\32\2\2\u0247\u0248\5\u009eP\2\u0248"+
		"\u0249\7\33\2\2\u0249s\3\2\2\2\u024a\u024b\7:\2\2\u024b\u024c\7\32\2\2"+
		"\u024c\u024d\5\u00a0Q\2\u024d\u024e\7\33\2\2\u024eu\3\2\2\2\u024f\u0250"+
		"\7;\2\2\u0250\u0251\7\32\2\2\u0251\u0252\5\u00a0Q\2\u0252\u0253\7\33\2"+
		"\2\u0253w\3\2\2\2\u0254\u0255\7<\2\2\u0255\u0256\7\32\2\2\u0256\u0257"+
		"\5\u00a0Q\2\u0257\u0258\7\33\2\2\u0258y\3\2\2\2\u0259\u025a\7=\2\2\u025a"+
		"\u025b\7\32\2\2\u025b\u025c\5\u00a0Q\2\u025c\u025d\7\33\2\2\u025d{\3\2"+
		"\2\2\u025e\u025f\7>\2\2\u025f\u0260\7\32\2\2\u0260\u0261\5\u009eP\2\u0261"+
		"\u0262\7\33\2\2\u0262}\3\2\2\2\u0263\u0264\7?\2\2\u0264\u0265\7\32\2\2"+
		"\u0265\u0266\5\u009eP\2\u0266\u0267\7\33\2\2\u0267\177\3\2\2\2\u0268\u0269"+
		"\7@\2\2\u0269\u026a\7\32\2\2\u026a\u026b\5\u00a0Q\2\u026b\u026c\7\33\2"+
		"\2\u026c\u0081\3\2\2\2\u026d\u026e\7A\2\2\u026e\u026f\7\32\2\2\u026f\u0270"+
		"\5\u009eP\2\u0270\u0271\7\33\2\2\u0271\u0083\3\2\2\2\u0272\u0273\7B\2"+
		"\2\u0273\u0274\7\32\2\2\u0274\u0275\5\u00a0Q\2\u0275\u0276\7\33\2\2\u0276"+
		"\u0085\3\2\2\2\u0277\u0278\7C\2\2\u0278\u0279\7\32\2\2\u0279\u027a\5\u00a0"+
		"Q\2\u027a\u027b\7\33\2\2\u027b\u0087\3\2\2\2\u027c\u027d\7D\2\2\u027d"+
		"\u027e\7\32\2\2\u027e\u027f\5\u00a0Q\2\u027f\u0280\7\33\2\2\u0280\u0089"+
		"\3\2\2\2\u0281\u0282\7E\2\2\u0282\u0283\7\32\2\2\u0283\u0284\5\u00a0Q"+
		"\2\u0284\u0285\7\33\2\2\u0285\u008b\3\2\2\2\u0286\u0287\7F\2\2\u0287\u0288"+
		"\7\32\2\2\u0288\u0289\5\u00a0Q\2\u0289\u028a\7\33\2\2\u028a\u008d\3\2"+
		"\2\2\u028b\u028c\7G\2\2\u028c\u028d\7\32\2\2\u028d\u028e\5\u009eP\2\u028e"+
		"\u028f\7\33\2\2\u028f\u008f\3\2\2\2\u0290\u0291\7H\2\2\u0291\u0292\7\32"+
		"\2\2\u0292\u0293\5\u00a0Q\2\u0293\u0294\7\33\2\2\u0294\u0091\3\2\2\2\u0295"+
		"\u0296\7I\2\2\u0296\u0297\7\32\2\2\u0297\u0298\5\u00a0Q\2\u0298\u0299"+
		"\7\33\2\2\u0299\u0093\3\2\2\2\u029a\u029b\7J\2\2\u029b\u029c\7\32\2\2"+
		"\u029c\u029d\5\u00a0Q\2\u029d\u029e\7\33\2\2\u029e\u0095\3\2\2\2\u029f"+
		"\u02a0\7K\2\2\u02a0\u02a1\7\32\2\2\u02a1\u02a2\5\u009eP\2\u02a2\u02a3"+
		"\7\33\2\2\u02a3\u0097\3\2\2\2\u02a4\u02a5\7L\2\2\u02a5\u02a6\7\32\2\2"+
		"\u02a6\u02a7\5\u009eP\2\u02a7\u02a8\7\33\2\2\u02a8\u0099\3\2\2\2\u02a9"+
		"\u02aa\7M\2\2\u02aa\u02ab\7\32\2\2\u02ab\u02ac\5\u00a0Q\2\u02ac\u02ad"+
		"\7\33\2\2\u02ad\u009b\3\2\2\2\u02ae\u02af\7N\2\2\u02af\u02b0\7\32\2\2"+
		"\u02b0\u02b1\5\u00a0Q\2\u02b1\u02b2\7\33\2\2\u02b2\u009d\3\2\2\2\u02b3"+
		"\u02b4\7O\2\2\u02b4\u02b5\7S\2\2\u02b5\u009f\3\2\2\2\u02b6\u02bf\7P\2"+
		"\2\u02b7\u02bc\5\u009eP\2\u02b8\u02b9\7Q\2\2\u02b9\u02bb\5\u009eP\2\u02ba"+
		"\u02b8\3\2\2\2\u02bb\u02be\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bc\u02bd\3\2"+
		"\2\2\u02bd\u02c0\3\2\2\2\u02be\u02bc\3\2\2\2\u02bf\u02b7\3\2\2\2\u02bf"+
		"\u02c0\3\2\2\2\u02c0\u02c1\3\2\2\2\u02c1\u02c2\7R\2\2\u02c2\u00a1\3\2"+
		"\2\2*\u00a8\u00c1\u00c9\u00d4\u00dc\u00e5\u00ed\u00f7\u00ff\u010a\u0111"+
		"\u0119\u0121\u0129\u0130\u0138\u013f\u0147\u014f\u0157\u0160\u0168\u0172"+
		"\u017a\u0188\u0190\u0198\u01a0\u01a8\u01b0\u01bb\u01c3\u01ca\u01d2\u01dd"+
		"\u01e6\u01ee\u01f5\u02bc\u02bf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}