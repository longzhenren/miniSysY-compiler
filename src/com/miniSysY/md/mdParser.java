// Generated from D:/Projects/IDEA/Compile/src\md.g4 by ANTLR 4.9.2
package com.miniSysY.md;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mdParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LParser=2, RParser=3, LBrace=4, RBrace=5, LBracket=6, RBracket=7, 
		RETURN_KW=8, INT_KW=9, VOID_KW=10, CONST_KW=11, WHILE_KW=12, IF_KW=13, 
		ELSE_KW=14, BREAK_KW=15, CONTINUE_KW=16, LT_KW=17, GT_KW=18, LE_KW=19, 
		GE_KW=20, EQ_KW=21, NEQ_KW=22, LAND_KW=23, LOR_KW=24, ASSIGN=25, ADD=26, 
		SUB=27, MUL=28, DIV=29, MOD=30, NOT=31, Semicolon=32, WhiteSpace=33, DecimalConst=34, 
		OctalConst=35, HexadecimalConst=36, BlockComment=37, LineComment=38, Ident=39;
	public static final int
		RULE_compUnit = 0, RULE_funcType = 1, RULE_funcDef = 2, RULE_funcFParams = 3, 
		RULE_funcFParam = 4, RULE_block = 5, RULE_blockItem = 6, RULE_stmt = 7, 
		RULE_lVal = 8, RULE_number = 9, RULE_intConst = 10, RULE_returnStmt = 11, 
		RULE_exp = 12, RULE_cond = 13, RULE_relExp = 14, RULE_eqExp = 15, RULE_lAndExp = 16, 
		RULE_lOrExp = 17, RULE_addExp = 18, RULE_mulExp = 19, RULE_unaryExp = 20, 
		RULE_primaryExp = 21, RULE_decl = 22, RULE_constDecl = 23, RULE_bType = 24, 
		RULE_constDef = 25, RULE_constInitVal = 26, RULE_constExp = 27, RULE_varDecl = 28, 
		RULE_varDef = 29, RULE_initVal = 30;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcType", "funcDef", "funcFParams", "funcFParam", "block", 
			"blockItem", "stmt", "lVal", "number", "intConst", "returnStmt", "exp", 
			"cond", "relExp", "eqExp", "lAndExp", "lOrExp", "addExp", "mulExp", "unaryExp", 
			"primaryExp", "decl", "constDecl", "bType", "constDef", "constInitVal", 
			"constExp", "varDecl", "varDef", "initVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'{'", "'}'", "'['", "']'", "'return'", "'int'", 
			"'void'", "'const'", "'while'", "'if'", "'else'", "'break'", "'continue'", 
			"'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", null, "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'!'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LParser", "RParser", "LBrace", "RBrace", "LBracket", "RBracket", 
			"RETURN_KW", "INT_KW", "VOID_KW", "CONST_KW", "WHILE_KW", "IF_KW", "ELSE_KW", 
			"BREAK_KW", "CONTINUE_KW", "LT_KW", "GT_KW", "LE_KW", "GE_KW", "EQ_KW", 
			"NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "NOT", "Semicolon", "WhiteSpace", "DecimalConst", "OctalConst", 
			"HexadecimalConst", "BlockComment", "LineComment", "Ident"
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
	public String getGrammarFileName() { return "md.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mdParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterCompUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitCompUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitCompUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompUnitContext compUnit() throws RecognitionException {
		CompUnitContext _localctx = new CompUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compUnit);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(64);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
					case 1:
						{
						setState(62);
						decl();
						}
						break;
					case 2:
						{
						setState(63);
						funcDef();
						}
						break;
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(69);
				decl();
				}
				break;
			case 2:
				{
				setState(70);
				funcDef();
				}
				break;
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

	public static class FuncTypeContext extends ParserRuleContext {
		public TerminalNode INT_KW() { return getToken(mdParser.INT_KW, 0); }
		public TerminalNode VOID_KW() { return getToken(mdParser.VOID_KW, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==INT_KW || _la==VOID_KW) ) {
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

	public static class FuncDefContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public TerminalNode LParser() { return getToken(mdParser.LParser, 0); }
		public TerminalNode RParser() { return getToken(mdParser.RParser, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncFParamsContext funcFParams() {
			return getRuleContext(FuncFParamsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			funcType();
			setState(76);
			match(Ident);
			setState(77);
			match(LParser);
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT_KW) {
				{
				setState(78);
				funcFParams();
				}
			}

			setState(81);
			match(RParser);
			setState(82);
			block();
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

	public static class FuncFParamsContext extends ParserRuleContext {
		public List<FuncFParamContext> funcFParam() {
			return getRuleContexts(FuncFParamContext.class);
		}
		public FuncFParamContext funcFParam(int i) {
			return getRuleContext(FuncFParamContext.class,i);
		}
		public FuncFParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcFParams; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterFuncFParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitFuncFParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitFuncFParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncFParamsContext funcFParams() throws RecognitionException {
		FuncFParamsContext _localctx = new FuncFParamsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcFParams);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			funcFParam();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(85);
				match(T__0);
				setState(86);
				funcFParam();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FuncFParamContext extends ParserRuleContext {
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public List<TerminalNode> LBracket() { return getTokens(mdParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(mdParser.LBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(mdParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(mdParser.RBracket, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public FuncFParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcFParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterFuncFParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitFuncFParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitFuncFParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncFParamContext funcFParam() throws RecognitionException {
		FuncFParamContext _localctx = new FuncFParamContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcFParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			bType();
			setState(93);
			match(Ident);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBracket) {
				{
				setState(94);
				match(LBracket);
				setState(95);
				match(RBracket);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBracket) {
					{
					{
					setState(96);
					match(LBracket);
					setState(97);
					exp();
					setState(98);
					match(RBracket);
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(mdParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(mdParser.RBrace, 0); }
		public List<BlockItemContext> blockItem() {
			return getRuleContexts(BlockItemContext.class);
		}
		public BlockItemContext blockItem(int i) {
			return getRuleContext(BlockItemContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(LBrace);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << RETURN_KW) | (1L << INT_KW) | (1L << CONST_KW) | (1L << WHILE_KW) | (1L << IF_KW) | (1L << BREAK_KW) | (1L << CONTINUE_KW) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << Semicolon) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
				{
				{
				setState(108);
				blockItem();
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(RBrace);
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

	public static class BlockItemContext extends ParserRuleContext {
		public DeclContext decl() {
			return getRuleContext(DeclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public BlockItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_blockItem);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_KW:
			case CONST_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				decl();
				}
				break;
			case LParser:
			case LBrace:
			case RETURN_KW:
			case WHILE_KW:
			case IF_KW:
			case BREAK_KW:
			case CONTINUE_KW:
			case ADD:
			case SUB:
			case NOT:
			case Semicolon:
			case DecimalConst:
			case OctalConst:
			case HexadecimalConst:
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				stmt();
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

	public static class StmtContext extends ParserRuleContext {
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(mdParser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(mdParser.Semicolon, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IF_KW() { return getToken(mdParser.IF_KW, 0); }
		public TerminalNode LParser() { return getToken(mdParser.LParser, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RParser() { return getToken(mdParser.RParser, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE_KW() { return getToken(mdParser.ELSE_KW, 0); }
		public TerminalNode WHILE_KW() { return getToken(mdParser.WHILE_KW, 0); }
		public TerminalNode BREAK_KW() { return getToken(mdParser.BREAK_KW, 0); }
		public TerminalNode CONTINUE_KW() { return getToken(mdParser.CONTINUE_KW, 0); }
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		int _la;
		try {
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				lVal();
				setState(121);
				match(ASSIGN);
				setState(122);
				exp();
				setState(123);
				match(Semicolon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(126);
					exp();
					}
				}

				setState(129);
				match(Semicolon);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(IF_KW);
				setState(131);
				match(LParser);
				setState(132);
				cond();
				setState(133);
				match(RParser);
				setState(134);
				stmt();
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(135);
					match(ELSE_KW);
					setState(136);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				match(WHILE_KW);
				setState(140);
				match(LParser);
				setState(141);
				cond();
				setState(142);
				match(RParser);
				setState(143);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(145);
				match(BREAK_KW);
				setState(146);
				match(Semicolon);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(147);
				match(CONTINUE_KW);
				setState(148);
				match(Semicolon);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(149);
				returnStmt();
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

	public static class LValContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public List<TerminalNode> LBracket() { return getTokens(mdParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(mdParser.LBracket, i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(mdParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(mdParser.RBracket, i);
		}
		public LValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterLVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitLVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitLVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValContext lVal() throws RecognitionException {
		LValContext _localctx = new LValContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lVal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(Ident);
			setState(159);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(153);
					match(LBracket);
					setState(154);
					exp();
					setState(155);
					match(RBracket);
					}
					} 
				}
				setState(161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class NumberContext extends ParserRuleContext {
		public IntConstContext intConst() {
			return getRuleContext(IntConstContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			intConst();
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

	public static class IntConstContext extends ParserRuleContext {
		public TerminalNode DecimalConst() { return getToken(mdParser.DecimalConst, 0); }
		public TerminalNode OctalConst() { return getToken(mdParser.OctalConst, 0); }
		public TerminalNode HexadecimalConst() { return getToken(mdParser.HexadecimalConst, 0); }
		public IntConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterIntConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitIntConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitIntConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntConstContext intConst() throws RecognitionException {
		IntConstContext _localctx = new IntConstContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_intConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst))) != 0)) ) {
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

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode RETURN_KW() { return getToken(mdParser.RETURN_KW, 0); }
		public TerminalNode Semicolon() { return getToken(mdParser.Semicolon, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(RETURN_KW);
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
				{
				setState(167);
				exp();
				}
			}

			setState(170);
			match(Semicolon);
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

	public static class ExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			addExp(0);
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

	public static class CondContext extends ParserRuleContext {
		public LOrExpContext lOrExp() {
			return getRuleContext(LOrExpContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			lOrExp(0);
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

	public static class RelExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public TerminalNode LT_KW() { return getToken(mdParser.LT_KW, 0); }
		public TerminalNode GT_KW() { return getToken(mdParser.GT_KW, 0); }
		public TerminalNode LE_KW() { return getToken(mdParser.LE_KW, 0); }
		public TerminalNode GE_KW() { return getToken(mdParser.GE_KW, 0); }
		public RelExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterRelExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitRelExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitRelExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelExpContext relExp() throws RecognitionException {
		return relExp(0);
	}

	private RelExpContext relExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelExpContext _localctx = new RelExpContext(_ctx, _parentState);
		RelExpContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_relExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(177);
			addExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relExp);
					setState(179);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(180);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_KW) | (1L << GT_KW) | (1L << LE_KW) | (1L << GE_KW))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(181);
					addExp(0);
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqExpContext extends ParserRuleContext {
		public RelExpContext relExp() {
			return getRuleContext(RelExpContext.class,0);
		}
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public TerminalNode EQ_KW() { return getToken(mdParser.EQ_KW, 0); }
		public TerminalNode NEQ_KW() { return getToken(mdParser.NEQ_KW, 0); }
		public EqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterEqExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitEqExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitEqExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqExpContext eqExp() throws RecognitionException {
		return eqExp(0);
	}

	private EqExpContext eqExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqExpContext _localctx = new EqExpContext(_ctx, _parentState);
		EqExpContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_eqExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(188);
			relExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(195);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqExp);
					setState(190);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(191);
					_la = _input.LA(1);
					if ( !(_la==EQ_KW || _la==NEQ_KW) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(192);
					relExp(0);
					}
					} 
				}
				setState(197);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LAndExpContext extends ParserRuleContext {
		public EqExpContext eqExp() {
			return getRuleContext(EqExpContext.class,0);
		}
		public LAndExpContext lAndExp() {
			return getRuleContext(LAndExpContext.class,0);
		}
		public TerminalNode LAND_KW() { return getToken(mdParser.LAND_KW, 0); }
		public LAndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lAndExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterLAndExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitLAndExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitLAndExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LAndExpContext lAndExp() throws RecognitionException {
		return lAndExp(0);
	}

	private LAndExpContext lAndExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LAndExpContext _localctx = new LAndExpContext(_ctx, _parentState);
		LAndExpContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lAndExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(199);
			eqExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LAndExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lAndExp);
					setState(201);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(202);
					match(LAND_KW);
					setState(203);
					eqExp(0);
					}
					} 
				}
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LOrExpContext extends ParserRuleContext {
		public LAndExpContext lAndExp() {
			return getRuleContext(LAndExpContext.class,0);
		}
		public LOrExpContext lOrExp() {
			return getRuleContext(LOrExpContext.class,0);
		}
		public TerminalNode LOR_KW() { return getToken(mdParser.LOR_KW, 0); }
		public LOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lOrExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterLOrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitLOrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitLOrExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LOrExpContext lOrExp() throws RecognitionException {
		return lOrExp(0);
	}

	private LOrExpContext lOrExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LOrExpContext _localctx = new LOrExpContext(_ctx, _parentState);
		LOrExpContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_lOrExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(210);
			lAndExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOrExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lOrExp);
					setState(212);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(213);
					match(LOR_KW);
					setState(214);
					lAndExp(0);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AddExpContext extends ParserRuleContext {
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(mdParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(mdParser.SUB, 0); }
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterAddExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitAddExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitAddExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddExpContext addExp() throws RecognitionException {
		return addExp(0);
	}

	private AddExpContext addExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AddExpContext _localctx = new AddExpContext(_ctx, _parentState);
		AddExpContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_addExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(221);
			mulExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExp);
					setState(223);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(224);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(225);
					mulExp(0);
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MulExpContext extends ParserRuleContext {
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public MulExpContext mulExp() {
			return getRuleContext(MulExpContext.class,0);
		}
		public TerminalNode MUL() { return getToken(mdParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(mdParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(mdParser.MOD, 0); }
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterMulExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitMulExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitMulExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulExpContext mulExp() throws RecognitionException {
		return mulExp(0);
	}

	private MulExpContext mulExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulExpContext _localctx = new MulExpContext(_ctx, _parentState);
		MulExpContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_mulExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(232);
			unaryExp();
			}
			_ctx.stop = _input.LT(-1);
			setState(239);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExp);
					setState(234);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(235);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(236);
					unaryExp();
					}
					} 
				}
				setState(241);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public TerminalNode LParser() { return getToken(mdParser.LParser, 0); }
		public TerminalNode RParser() { return getToken(mdParser.RParser, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(mdParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(mdParser.SUB, 0); }
		public TerminalNode NOT() { return getToken(mdParser.NOT, 0); }
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unaryExp);
		int _la;
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(242);
				match(Ident);
				setState(243);
				match(LParser);
				setState(252);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(244);
					exp();
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(245);
						match(T__0);
						setState(246);
						exp();
						}
						}
						setState(251);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(254);
				match(RParser);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(256);
				unaryExp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(257);
				primaryExp();
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

	public static class PrimaryExpContext extends ParserRuleContext {
		public TerminalNode LParser() { return getToken(mdParser.LParser, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RParser() { return getToken(mdParser.RParser, 0); }
		public LValContext lVal() {
			return getRuleContext(LValContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public PrimaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterPrimaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitPrimaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitPrimaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_primaryExp);
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParser:
				enterOuterAlt(_localctx, 1);
				{
				setState(260);
				match(LParser);
				setState(261);
				exp();
				setState(262);
				match(RParser);
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(264);
				lVal();
				}
				break;
			case DecimalConst:
			case OctalConst:
			case HexadecimalConst:
				enterOuterAlt(_localctx, 3);
				{
				setState(265);
				number();
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

	public static class DeclContext extends ParserRuleContext {
		public ConstDeclContext constDecl() {
			return getRuleContext(ConstDeclContext.class,0);
		}
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_decl);
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(268);
				constDecl();
				}
				break;
			case INT_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				varDecl();
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

	public static class ConstDeclContext extends ParserRuleContext {
		public TerminalNode CONST_KW() { return getToken(mdParser.CONST_KW, 0); }
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(mdParser.Semicolon, 0); }
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(CONST_KW);
			setState(273);
			bType();
			setState(274);
			constDef();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(275);
				match(T__0);
				setState(276);
				constDef();
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(Semicolon);
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

	public static class BTypeContext extends ParserRuleContext {
		public TerminalNode INT_KW() { return getToken(mdParser.INT_KW, 0); }
		public BTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterBType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitBType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitBType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_bType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(INT_KW);
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

	public static class ConstDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public TerminalNode ASSIGN() { return getToken(mdParser.ASSIGN, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public List<TerminalNode> LBracket() { return getTokens(mdParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(mdParser.LBracket, i);
		}
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(mdParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(mdParser.RBracket, i);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(Ident);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(287);
				match(LBracket);
				setState(288);
				constExp();
				setState(289);
				match(RBracket);
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
			match(ASSIGN);
			setState(297);
			constInitVal();
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

	public static class ConstInitValContext extends ParserRuleContext {
		public ConstExpContext constExp() {
			return getRuleContext(ConstExpContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(mdParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(mdParser.RBrace, 0); }
		public List<ConstInitValContext> constInitVal() {
			return getRuleContexts(ConstInitValContext.class);
		}
		public ConstInitValContext constInitVal(int i) {
			return getRuleContext(ConstInitValContext.class,i);
		}
		public ConstInitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constInitVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterConstInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitConstInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constInitVal);
		int _la;
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParser:
			case ADD:
			case SUB:
			case NOT:
			case DecimalConst:
			case OctalConst:
			case HexadecimalConst:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				constExp();
				}
				break;
			case LBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				match(LBrace);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(301);
					constInitVal();
					setState(306);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(302);
						match(T__0);
						setState(303);
						constInitVal();
						}
						}
						setState(308);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(311);
				match(RBrace);
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

	public static class ConstExpContext extends ParserRuleContext {
		public AddExpContext addExp() {
			return getRuleContext(AddExpContext.class,0);
		}
		public ConstExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterConstExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitConstExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			addExp(0);
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

	public static class VarDeclContext extends ParserRuleContext {
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(mdParser.Semicolon, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			bType();
			setState(317);
			varDef();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(318);
				match(T__0);
				setState(319);
				varDef();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
			match(Semicolon);
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

	public static class VarDefContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(mdParser.Ident, 0); }
		public List<TerminalNode> LBracket() { return getTokens(mdParser.LBracket); }
		public TerminalNode LBracket(int i) {
			return getToken(mdParser.LBracket, i);
		}
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public List<TerminalNode> RBracket() { return getTokens(mdParser.RBracket); }
		public TerminalNode RBracket(int i) {
			return getToken(mdParser.RBracket, i);
		}
		public TerminalNode ASSIGN() { return getToken(mdParser.ASSIGN, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_varDef);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				match(Ident);
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBracket) {
					{
					{
					setState(328);
					match(LBracket);
					setState(329);
					constExp();
					setState(330);
					match(RBracket);
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(337);
				match(Ident);
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBracket) {
					{
					{
					setState(338);
					match(LBracket);
					setState(339);
					constExp();
					setState(340);
					match(RBracket);
					}
					}
					setState(346);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(347);
				match(ASSIGN);
				setState(348);
				initVal();
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

	public static class InitValContext extends ParserRuleContext {
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode LBrace() { return getToken(mdParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(mdParser.RBrace, 0); }
		public List<InitValContext> initVal() {
			return getRuleContexts(InitValContext.class);
		}
		public InitValContext initVal(int i) {
			return getRuleContext(InitValContext.class,i);
		}
		public InitValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).enterInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof mdListener ) ((mdListener)listener).exitInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof mdVisitor ) return ((mdVisitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_initVal);
		int _la;
		try {
			setState(364);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParser:
			case ADD:
			case SUB:
			case NOT:
			case DecimalConst:
			case OctalConst:
			case HexadecimalConst:
			case Ident:
				enterOuterAlt(_localctx, 1);
				{
				setState(351);
				exp();
				}
				break;
			case LBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(LBrace);
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(353);
					initVal();
					setState(358);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__0) {
						{
						{
						setState(354);
						match(T__0);
						setState(355);
						initVal();
						}
						}
						setState(360);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(363);
				match(RBrace);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return relExp_sempred((RelExpContext)_localctx, predIndex);
		case 15:
			return eqExp_sempred((EqExpContext)_localctx, predIndex);
		case 16:
			return lAndExp_sempred((LAndExpContext)_localctx, predIndex);
		case 17:
			return lOrExp_sempred((LOrExpContext)_localctx, predIndex);
		case 18:
			return addExp_sempred((AddExpContext)_localctx, predIndex);
		case 19:
			return mulExp_sempred((MulExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean relExp_sempred(RelExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean eqExp_sempred(EqExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lAndExp_sempred(LAndExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lOrExp_sempred(LOrExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean addExp_sempred(AddExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean mulExp_sempred(MulExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0171\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\7\2C\n\2\f\2\16\2F\13\2\3\2\3\2\5\2J\n\2\3\3\3\3\3\4\3\4\3\4\3\4"+
		"\5\4R\n\4\3\4\3\4\3\4\3\5\3\5\3\5\7\5Z\n\5\f\5\16\5]\13\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\5\6l\n\6\3\7\3\7\7\7p\n\7"+
		"\f\7\16\7s\13\7\3\7\3\7\3\b\3\b\5\by\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5"+
		"\t\u0082\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0099\n\t\3\n\3\n\3\n\3\n\3\n\7\n"+
		"\u00a0\n\n\f\n\16\n\u00a3\13\n\3\13\3\13\3\f\3\f\3\r\3\r\5\r\u00ab\n\r"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00b9"+
		"\n\20\f\20\16\20\u00bc\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00c4"+
		"\n\21\f\21\16\21\u00c7\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00cf"+
		"\n\22\f\22\16\22\u00d2\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00da"+
		"\n\23\f\23\16\23\u00dd\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00e5"+
		"\n\24\f\24\16\24\u00e8\13\24\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00f0"+
		"\n\25\f\25\16\25\u00f3\13\25\3\26\3\26\3\26\3\26\3\26\7\26\u00fa\n\26"+
		"\f\26\16\26\u00fd\13\26\5\26\u00ff\n\26\3\26\3\26\3\26\3\26\5\26\u0105"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u010d\n\27\3\30\3\30\5\30\u0111"+
		"\n\30\3\31\3\31\3\31\3\31\3\31\7\31\u0118\n\31\f\31\16\31\u011b\13\31"+
		"\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0126\n\33\f\33\16"+
		"\33\u0129\13\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u0133\n\34"+
		"\f\34\16\34\u0136\13\34\5\34\u0138\n\34\3\34\5\34\u013b\n\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\7\36\u0143\n\36\f\36\16\36\u0146\13\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\7\37\u014f\n\37\f\37\16\37\u0152\13\37\3\37"+
		"\3\37\3\37\3\37\3\37\7\37\u0159\n\37\f\37\16\37\u015c\13\37\3\37\3\37"+
		"\5\37\u0160\n\37\3 \3 \3 \3 \3 \7 \u0167\n \f \16 \u016a\13 \5 \u016c"+
		"\n \3 \5 \u016f\n \3 \2\b\36 \"$&(!\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"$&(*,.\60\62\64\668:<>\2\t\3\2\13\f\3\2$&\3\2\23\26\3\2\27\30\3"+
		"\2\34\35\3\2\36 \4\2\34\35!!\2\u017e\2D\3\2\2\2\4K\3\2\2\2\6M\3\2\2\2"+
		"\bV\3\2\2\2\n^\3\2\2\2\fm\3\2\2\2\16x\3\2\2\2\20\u0098\3\2\2\2\22\u009a"+
		"\3\2\2\2\24\u00a4\3\2\2\2\26\u00a6\3\2\2\2\30\u00a8\3\2\2\2\32\u00ae\3"+
		"\2\2\2\34\u00b0\3\2\2\2\36\u00b2\3\2\2\2 \u00bd\3\2\2\2\"\u00c8\3\2\2"+
		"\2$\u00d3\3\2\2\2&\u00de\3\2\2\2(\u00e9\3\2\2\2*\u0104\3\2\2\2,\u010c"+
		"\3\2\2\2.\u0110\3\2\2\2\60\u0112\3\2\2\2\62\u011e\3\2\2\2\64\u0120\3\2"+
		"\2\2\66\u013a\3\2\2\28\u013c\3\2\2\2:\u013e\3\2\2\2<\u015f\3\2\2\2>\u016e"+
		"\3\2\2\2@C\5.\30\2AC\5\6\4\2B@\3\2\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2D"+
		"E\3\2\2\2EI\3\2\2\2FD\3\2\2\2GJ\5.\30\2HJ\5\6\4\2IG\3\2\2\2IH\3\2\2\2"+
		"J\3\3\2\2\2KL\t\2\2\2L\5\3\2\2\2MN\5\4\3\2NO\7)\2\2OQ\7\4\2\2PR\5\b\5"+
		"\2QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\7\5\2\2TU\5\f\7\2U\7\3\2\2\2V[\5\n"+
		"\6\2WX\7\3\2\2XZ\5\n\6\2YW\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\\t"+
		"\3\2\2\2][\3\2\2\2^_\5\62\32\2_k\7)\2\2`a\7\b\2\2ah\7\t\2\2bc\7\b\2\2"+
		"cd\5\32\16\2de\7\t\2\2eg\3\2\2\2fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2"+
		"\2il\3\2\2\2jh\3\2\2\2k`\3\2\2\2kl\3\2\2\2l\13\3\2\2\2mq\7\6\2\2np\5\16"+
		"\b\2on\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\7"+
		"\2\2u\r\3\2\2\2vy\5.\30\2wy\5\20\t\2xv\3\2\2\2xw\3\2\2\2y\17\3\2\2\2z"+
		"{\5\22\n\2{|\7\33\2\2|}\5\32\16\2}~\7\"\2\2~\u0099\3\2\2\2\177\u0099\5"+
		"\f\7\2\u0080\u0082\5\32\16\2\u0081\u0080\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0083\3\2\2\2\u0083\u0099\7\"\2\2\u0084\u0085\7\17\2\2\u0085\u0086\7"+
		"\4\2\2\u0086\u0087\5\34\17\2\u0087\u0088\7\5\2\2\u0088\u008b\5\20\t\2"+
		"\u0089\u008a\7\20\2\2\u008a\u008c\5\20\t\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u0099\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u008f\7\4\2\2"+
		"\u008f\u0090\5\34\17\2\u0090\u0091\7\5\2\2\u0091\u0092\5\20\t\2\u0092"+
		"\u0099\3\2\2\2\u0093\u0094\7\21\2\2\u0094\u0099\7\"\2\2\u0095\u0096\7"+
		"\22\2\2\u0096\u0099\7\"\2\2\u0097\u0099\5\30\r\2\u0098z\3\2\2\2\u0098"+
		"\177\3\2\2\2\u0098\u0081\3\2\2\2\u0098\u0084\3\2\2\2\u0098\u008d\3\2\2"+
		"\2\u0098\u0093\3\2\2\2\u0098\u0095\3\2\2\2\u0098\u0097\3\2\2\2\u0099\21"+
		"\3\2\2\2\u009a\u00a1\7)\2\2\u009b\u009c\7\b\2\2\u009c\u009d\5\32\16\2"+
		"\u009d\u009e\7\t\2\2\u009e\u00a0\3\2\2\2\u009f\u009b\3\2\2\2\u00a0\u00a3"+
		"\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\23\3\2\2\2\u00a3"+
		"\u00a1\3\2\2\2\u00a4\u00a5\5\26\f\2\u00a5\25\3\2\2\2\u00a6\u00a7\t\3\2"+
		"\2\u00a7\27\3\2\2\2\u00a8\u00aa\7\n\2\2\u00a9\u00ab\5\32\16\2\u00aa\u00a9"+
		"\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\7\"\2\2\u00ad"+
		"\31\3\2\2\2\u00ae\u00af\5&\24\2\u00af\33\3\2\2\2\u00b0\u00b1\5$\23\2\u00b1"+
		"\35\3\2\2\2\u00b2\u00b3\b\20\1\2\u00b3\u00b4\5&\24\2\u00b4\u00ba\3\2\2"+
		"\2\u00b5\u00b6\f\3\2\2\u00b6\u00b7\t\4\2\2\u00b7\u00b9\5&\24\2\u00b8\u00b5"+
		"\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb"+
		"\37\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00be\b\21\1\2\u00be\u00bf\5\36"+
		"\20\2\u00bf\u00c5\3\2\2\2\u00c0\u00c1\f\3\2\2\u00c1\u00c2\t\5\2\2\u00c2"+
		"\u00c4\5\36\20\2\u00c3\u00c0\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3"+
		"\2\2\2\u00c5\u00c6\3\2\2\2\u00c6!\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9"+
		"\b\22\1\2\u00c9\u00ca\5 \21\2\u00ca\u00d0\3\2\2\2\u00cb\u00cc\f\3\2\2"+
		"\u00cc\u00cd\7\31\2\2\u00cd\u00cf\5 \21\2\u00ce\u00cb\3\2\2\2\u00cf\u00d2"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1#\3\2\2\2\u00d2"+
		"\u00d0\3\2\2\2\u00d3\u00d4\b\23\1\2\u00d4\u00d5\5\"\22\2\u00d5\u00db\3"+
		"\2\2\2\u00d6\u00d7\f\3\2\2\u00d7\u00d8\7\32\2\2\u00d8\u00da\5\"\22\2\u00d9"+
		"\u00d6\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc\3\2"+
		"\2\2\u00dc%\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\b\24\1\2\u00df\u00e0"+
		"\5(\25\2\u00e0\u00e6\3\2\2\2\u00e1\u00e2\f\3\2\2\u00e2\u00e3\t\6\2\2\u00e3"+
		"\u00e5\5(\25\2\u00e4\u00e1\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4\3\2"+
		"\2\2\u00e6\u00e7\3\2\2\2\u00e7\'\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ea"+
		"\b\25\1\2\u00ea\u00eb\5*\26\2\u00eb\u00f1\3\2\2\2\u00ec\u00ed\f\3\2\2"+
		"\u00ed\u00ee\t\7\2\2\u00ee\u00f0\5*\26\2\u00ef\u00ec\3\2\2\2\u00f0\u00f3"+
		"\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2)\3\2\2\2\u00f3"+
		"\u00f1\3\2\2\2\u00f4\u00f5\7)\2\2\u00f5\u00fe\7\4\2\2\u00f6\u00fb\5\32"+
		"\16\2\u00f7\u00f8\7\3\2\2\u00f8\u00fa\5\32\16\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00ff\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fe\u00f6\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0105\7\5\2\2\u0101\u0102\t\b\2\2\u0102\u0105\5*"+
		"\26\2\u0103\u0105\5,\27\2\u0104\u00f4\3\2\2\2\u0104\u0101\3\2\2\2\u0104"+
		"\u0103\3\2\2\2\u0105+\3\2\2\2\u0106\u0107\7\4\2\2\u0107\u0108\5\32\16"+
		"\2\u0108\u0109\7\5\2\2\u0109\u010d\3\2\2\2\u010a\u010d\5\22\n\2\u010b"+
		"\u010d\5\24\13\2\u010c\u0106\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3"+
		"\2\2\2\u010d-\3\2\2\2\u010e\u0111\5\60\31\2\u010f\u0111\5:\36\2\u0110"+
		"\u010e\3\2\2\2\u0110\u010f\3\2\2\2\u0111/\3\2\2\2\u0112\u0113\7\r\2\2"+
		"\u0113\u0114\5\62\32\2\u0114\u0119\5\64\33\2\u0115\u0116\7\3\2\2\u0116"+
		"\u0118\5\64\33\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3"+
		"\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2\2\2\u011c"+
		"\u011d\7\"\2\2\u011d\61\3\2\2\2\u011e\u011f\7\13\2\2\u011f\63\3\2\2\2"+
		"\u0120\u0127\7)\2\2\u0121\u0122\7\b\2\2\u0122\u0123\58\35\2\u0123\u0124"+
		"\7\t\2\2\u0124\u0126\3\2\2\2\u0125\u0121\3\2\2\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2"+
		"\2\2\u012a\u012b\7\33\2\2\u012b\u012c\5\66\34\2\u012c\65\3\2\2\2\u012d"+
		"\u013b\58\35\2\u012e\u0137\7\6\2\2\u012f\u0134\5\66\34\2\u0130\u0131\7"+
		"\3\2\2\u0131\u0133\5\66\34\2\u0132\u0130\3\2\2\2\u0133\u0136\3\2\2\2\u0134"+
		"\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2"+
		"\2\2\u0137\u012f\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\7\7\2\2\u013a\u012d\3\2\2\2\u013a\u012e\3\2\2\2\u013b\67\3\2\2"+
		"\2\u013c\u013d\5&\24\2\u013d9\3\2\2\2\u013e\u013f\5\62\32\2\u013f\u0144"+
		"\5<\37\2\u0140\u0141\7\3\2\2\u0141\u0143\5<\37\2\u0142\u0140\3\2\2\2\u0143"+
		"\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2"+
		"\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7\"\2\2\u0148;\3\2\2\2\u0149\u0150"+
		"\7)\2\2\u014a\u014b\7\b\2\2\u014b\u014c\58\35\2\u014c\u014d\7\t\2\2\u014d"+
		"\u014f\3\2\2\2\u014e\u014a\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2"+
		"\2\2\u0150\u0151\3\2\2\2\u0151\u0160\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u015a\7)\2\2\u0154\u0155\7\b\2\2\u0155\u0156\58\35\2\u0156\u0157\7\t"+
		"\2\2\u0157\u0159\3\2\2\2\u0158\u0154\3\2\2\2\u0159\u015c\3\2\2\2\u015a"+
		"\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015d\3\2\2\2\u015c\u015a\3\2"+
		"\2\2\u015d\u015e\7\33\2\2\u015e\u0160\5> \2\u015f\u0149\3\2\2\2\u015f"+
		"\u0153\3\2\2\2\u0160=\3\2\2\2\u0161\u016f\5\32\16\2\u0162\u016b\7\6\2"+
		"\2\u0163\u0168\5> \2\u0164\u0165\7\3\2\2\u0165\u0167\5> \2\u0166\u0164"+
		"\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169"+
		"\u016c\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u0163\3\2\2\2\u016b\u016c\3\2"+
		"\2\2\u016c\u016d\3\2\2\2\u016d\u016f\7\7\2\2\u016e\u0161\3\2\2\2\u016e"+
		"\u0162\3\2\2\2\u016f?\3\2\2\2\'BDIQ[hkqx\u0081\u008b\u0098\u00a1\u00aa"+
		"\u00ba\u00c5\u00d0\u00db\u00e6\u00f1\u00fb\u00fe\u0104\u010c\u0110\u0119"+
		"\u0127\u0134\u0137\u013a\u0144\u0150\u015a\u015f\u0168\u016b\u016e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}