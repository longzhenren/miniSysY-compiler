// Generated from D:/Projects/IDEA/Compile/src\P7.g4 by ANTLR 4.9.2
package com.miniSysY.P7;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P7Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, LParser=4, RParser=5, LBrace=6, RBrace=7, RETURN_KW=8, 
		INT_KW=9, CONST_KW=10, WHILE_KW=11, IF_KW=12, ELSE_KW=13, BREAK_KW=14, 
		CONTINUE_KW=15, LT_KW=16, GT_KW=17, LE_KW=18, GE_KW=19, EQ_KW=20, NEQ_KW=21, 
		LAND_KW=22, LOR_KW=23, ASSIGN=24, ADD=25, SUB=26, MUL=27, DIV=28, MOD=29, 
		NOT=30, Semicolon=31, WhiteSpace=32, FuncIdent=33, DecimalConst=34, OctalConst=35, 
		HexadecimalConst=36, BlockComment=37, LineComment=38, Ident=39;
	public static final int
		RULE_compUnit = 0, RULE_funcType = 1, RULE_funcIdent = 2, RULE_funcDef = 3, 
		RULE_block = 4, RULE_blockItem = 5, RULE_stmt = 6, RULE_lVal = 7, RULE_number = 8, 
		RULE_intConst = 9, RULE_returnStmt = 10, RULE_exp = 11, RULE_cond = 12, 
		RULE_relExp = 13, RULE_eqExp = 14, RULE_lAndExp = 15, RULE_lOrExp = 16, 
		RULE_addExp = 17, RULE_mulExp = 18, RULE_unaryExp = 19, RULE_primaryExp = 20, 
		RULE_decl = 21, RULE_constDecl = 22, RULE_bType = 23, RULE_constDef = 24, 
		RULE_constInitVal = 25, RULE_constExp = 26, RULE_varDecl = 27, RULE_varDef = 28, 
		RULE_initVal = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"compUnit", "funcType", "funcIdent", "funcDef", "block", "blockItem", 
			"stmt", "lVal", "number", "intConst", "returnStmt", "exp", "cond", "relExp", 
			"eqExp", "lAndExp", "lOrExp", "addExp", "mulExp", "unaryExp", "primaryExp", 
			"decl", "constDecl", "bType", "constDef", "constInitVal", "constExp", 
			"varDecl", "varDef", "initVal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'['", "']'", "','", "'('", "')'", "'{'", "'}'", "'return'", "'int'", 
			"'const'", "'while'", "'if'", "'else'", "'break'", "'continue'", "'<'", 
			"'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", "'||'", null, "'+'", "'-'", 
			"'*'", "'/'", "'%'", "'!'", "';'", null, "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", 
			"INT_KW", "CONST_KW", "WHILE_KW", "IF_KW", "ELSE_KW", "BREAK_KW", "CONTINUE_KW", 
			"LT_KW", "GT_KW", "LE_KW", "GE_KW", "EQ_KW", "NEQ_KW", "LAND_KW", "LOR_KW", 
			"ASSIGN", "ADD", "SUB", "MUL", "DIV", "MOD", "NOT", "Semicolon", "WhiteSpace", 
			"FuncIdent", "DecimalConst", "OctalConst", "HexadecimalConst", "BlockComment", 
			"LineComment", "Ident"
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
	public String getGrammarFileName() { return "P7.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public P7Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompUnitContext extends ParserRuleContext {
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public CompUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterCompUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitCompUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitCompUnit(this);
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
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(60);
					decl();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(66);
			funcDef();
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
		public TerminalNode INT_KW() { return getToken(P7Parser.INT_KW, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
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

	public static class FuncIdentContext extends ParserRuleContext {
		public TerminalNode FuncIdent() { return getToken(P7Parser.FuncIdent, 0); }
		public FuncIdentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcIdent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterFuncIdent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitFuncIdent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitFuncIdent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncIdentContext funcIdent() throws RecognitionException {
		FuncIdentContext _localctx = new FuncIdentContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_funcIdent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(FuncIdent);
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
		public FuncIdentContext funcIdent() {
			return getRuleContext(FuncIdentContext.class,0);
		}
		public TerminalNode LParser() { return getToken(P7Parser.LParser, 0); }
		public TerminalNode RParser() { return getToken(P7Parser.RParser, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			funcType();
			setState(73);
			funcIdent();
			setState(74);
			match(LParser);
			setState(75);
			match(RParser);
			setState(76);
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

	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBrace() { return getToken(P7Parser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(P7Parser.RBrace, 0); }
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(LBrace);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << RETURN_KW) | (1L << INT_KW) | (1L << CONST_KW) | (1L << WHILE_KW) | (1L << IF_KW) | (1L << BREAK_KW) | (1L << CONTINUE_KW) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << Semicolon) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
				{
				{
				setState(79);
				blockItem();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterBlockItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitBlockItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitBlockItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockItemContext blockItem() throws RecognitionException {
		BlockItemContext _localctx = new BlockItemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_blockItem);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT_KW:
			case CONST_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
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
				setState(88);
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
		public TerminalNode ASSIGN() { return getToken(P7Parser.ASSIGN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(P7Parser.Semicolon, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode IF_KW() { return getToken(P7Parser.IF_KW, 0); }
		public TerminalNode LParser() { return getToken(P7Parser.LParser, 0); }
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public TerminalNode RParser() { return getToken(P7Parser.RParser, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE_KW() { return getToken(P7Parser.ELSE_KW, 0); }
		public TerminalNode WHILE_KW() { return getToken(P7Parser.WHILE_KW, 0); }
		public TerminalNode BREAK_KW() { return getToken(P7Parser.BREAK_KW, 0); }
		public TerminalNode CONTINUE_KW() { return getToken(P7Parser.CONTINUE_KW, 0); }
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		int _la;
		try {
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				lVal();
				setState(92);
				match(ASSIGN);
				setState(93);
				exp();
				setState(94);
				match(Semicolon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(97);
					exp();
					}
				}

				setState(100);
				match(Semicolon);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				match(IF_KW);
				setState(102);
				match(LParser);
				setState(103);
				cond();
				setState(104);
				match(RParser);
				setState(105);
				stmt();
				setState(108);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(106);
					match(ELSE_KW);
					setState(107);
					stmt();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(WHILE_KW);
				setState(111);
				match(LParser);
				setState(112);
				cond();
				setState(113);
				match(RParser);
				setState(114);
				stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(116);
				match(BREAK_KW);
				setState(117);
				match(Semicolon);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(118);
				match(CONTINUE_KW);
				setState(119);
				match(Semicolon);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(120);
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
		public TerminalNode Ident() { return getToken(P7Parser.Ident, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public LValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterLVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitLVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitLVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValContext lVal() throws RecognitionException {
		LValContext _localctx = new LValContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lVal);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(Ident);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					match(T__0);
					setState(125);
					exp();
					setState(126);
					match(T__1);
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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
		public TerminalNode DecimalConst() { return getToken(P7Parser.DecimalConst, 0); }
		public TerminalNode OctalConst() { return getToken(P7Parser.OctalConst, 0); }
		public TerminalNode HexadecimalConst() { return getToken(P7Parser.HexadecimalConst, 0); }
		public IntConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterIntConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitIntConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitIntConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntConstContext intConst() throws RecognitionException {
		IntConstContext _localctx = new IntConstContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_intConst);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
		public TerminalNode RETURN_KW() { return getToken(P7Parser.RETURN_KW, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(P7Parser.Semicolon, 0); }
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(RETURN_KW);
			setState(138);
			exp();
			setState(139);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitCond(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitCond(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		CondContext _localctx = new CondContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
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
		public TerminalNode LT_KW() { return getToken(P7Parser.LT_KW, 0); }
		public TerminalNode GT_KW() { return getToken(P7Parser.GT_KW, 0); }
		public TerminalNode LE_KW() { return getToken(P7Parser.LE_KW, 0); }
		public TerminalNode GE_KW() { return getToken(P7Parser.GE_KW, 0); }
		public RelExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterRelExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitRelExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitRelExp(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_relExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(146);
			addExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RelExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relExp);
					setState(148);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(149);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LT_KW) | (1L << GT_KW) | (1L << LE_KW) | (1L << GE_KW))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(150);
					addExp(0);
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public TerminalNode EQ_KW() { return getToken(P7Parser.EQ_KW, 0); }
		public TerminalNode NEQ_KW() { return getToken(P7Parser.NEQ_KW, 0); }
		public EqExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterEqExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitEqExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitEqExp(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_eqExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(157);
			relExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(164);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_eqExp);
					setState(159);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(160);
					_la = _input.LA(1);
					if ( !(_la==EQ_KW || _la==NEQ_KW) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(161);
					relExp(0);
					}
					} 
				}
				setState(166);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		public TerminalNode LAND_KW() { return getToken(P7Parser.LAND_KW, 0); }
		public LAndExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lAndExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterLAndExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitLAndExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitLAndExp(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_lAndExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(168);
			eqExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(175);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LAndExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lAndExp);
					setState(170);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(171);
					match(LAND_KW);
					setState(172);
					eqExp(0);
					}
					} 
				}
				setState(177);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		public TerminalNode LOR_KW() { return getToken(P7Parser.LOR_KW, 0); }
		public LOrExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lOrExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterLOrExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitLOrExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitLOrExp(this);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_lOrExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(179);
			lAndExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LOrExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lOrExp);
					setState(181);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(182);
					match(LOR_KW);
					setState(183);
					lAndExp(0);
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		public TerminalNode ADD() { return getToken(P7Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(P7Parser.SUB, 0); }
		public AddExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterAddExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitAddExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitAddExp(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_addExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(190);
			mulExp(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_addExp);
					setState(192);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(193);
					_la = _input.LA(1);
					if ( !(_la==ADD || _la==SUB) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(194);
					mulExp(0);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		public TerminalNode MUL() { return getToken(P7Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(P7Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(P7Parser.MOD, 0); }
		public MulExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterMulExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitMulExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitMulExp(this);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_mulExp, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(201);
			unaryExp();
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MulExpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mulExp);
					setState(203);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(204);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MUL) | (1L << DIV) | (1L << MOD))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(205);
					unaryExp();
					}
					} 
				}
				setState(210);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpContext extends ParserRuleContext {
		public TerminalNode Ident() { return getToken(P7Parser.Ident, 0); }
		public TerminalNode LParser() { return getToken(P7Parser.LParser, 0); }
		public TerminalNode RParser() { return getToken(P7Parser.RParser, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public TerminalNode ADD() { return getToken(P7Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(P7Parser.SUB, 0); }
		public TerminalNode NOT() { return getToken(P7Parser.NOT, 0); }
		public PrimaryExpContext primaryExp() {
			return getRuleContext(PrimaryExpContext.class,0);
		}
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_unaryExp);
		int _la;
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(Ident);
				setState(212);
				match(LParser);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(213);
					exp();
					setState(218);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(214);
						match(T__2);
						setState(215);
						exp();
						}
						}
						setState(220);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(223);
				match(RParser);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ADD) | (1L << SUB) | (1L << NOT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(225);
				unaryExp();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
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
		public TerminalNode LParser() { return getToken(P7Parser.LParser, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode RParser() { return getToken(P7Parser.RParser, 0); }
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterPrimaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitPrimaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitPrimaryExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpContext primaryExp() throws RecognitionException {
		PrimaryExpContext _localctx = new PrimaryExpContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primaryExp);
		try {
			setState(235);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParser:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(LParser);
				setState(230);
				exp();
				setState(231);
				match(RParser);
				}
				break;
			case Ident:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				lVal();
				}
				break;
			case DecimalConst:
			case OctalConst:
			case HexadecimalConst:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_decl);
		try {
			setState(239);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST_KW:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				constDecl();
				}
				break;
			case INT_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
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
		public TerminalNode CONST_KW() { return getToken(P7Parser.CONST_KW, 0); }
		public BTypeContext bType() {
			return getRuleContext(BTypeContext.class,0);
		}
		public List<ConstDefContext> constDef() {
			return getRuleContexts(ConstDefContext.class);
		}
		public ConstDefContext constDef(int i) {
			return getRuleContext(ConstDefContext.class,i);
		}
		public TerminalNode Semicolon() { return getToken(P7Parser.Semicolon, 0); }
		public ConstDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterConstDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitConstDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitConstDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDeclContext constDecl() throws RecognitionException {
		ConstDeclContext _localctx = new ConstDeclContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			match(CONST_KW);
			setState(242);
			bType();
			setState(243);
			constDef();
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(244);
				match(T__2);
				setState(245);
				constDef();
				}
				}
				setState(250);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(251);
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
		public TerminalNode INT_KW() { return getToken(P7Parser.INT_KW, 0); }
		public BTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterBType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitBType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitBType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BTypeContext bType() throws RecognitionException {
		BTypeContext _localctx = new BTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253);
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
		public TerminalNode Ident() { return getToken(P7Parser.Ident, 0); }
		public TerminalNode ASSIGN() { return getToken(P7Parser.ASSIGN, 0); }
		public ConstInitValContext constInitVal() {
			return getRuleContext(ConstInitValContext.class,0);
		}
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterConstDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitConstDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitConstDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_constDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(Ident);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(256);
				match(T__0);
				setState(257);
				constExp();
				setState(258);
				match(T__1);
				}
				}
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(265);
			match(ASSIGN);
			setState(266);
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
		public TerminalNode LBrace() { return getToken(P7Parser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(P7Parser.RBrace, 0); }
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterConstInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitConstInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitConstInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstInitValContext constInitVal() throws RecognitionException {
		ConstInitValContext _localctx = new ConstInitValContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constInitVal);
		int _la;
		try {
			setState(281);
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
				setState(268);
				constExp();
				}
				break;
			case LBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(269);
				match(LBrace);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(270);
					constInitVal();
					setState(275);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(271);
						match(T__2);
						setState(272);
						constInitVal();
						}
						}
						setState(277);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(280);
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterConstExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitConstExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitConstExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstExpContext constExp() throws RecognitionException {
		ConstExpContext _localctx = new ConstExpContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_constExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
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
		public TerminalNode Semicolon() { return getToken(P7Parser.Semicolon, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_varDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			bType();
			setState(286);
			varDef();
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(287);
				match(T__2);
				setState(288);
				varDef();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
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
		public TerminalNode Ident() { return getToken(P7Parser.Ident, 0); }
		public List<ConstExpContext> constExp() {
			return getRuleContexts(ConstExpContext.class);
		}
		public ConstExpContext constExp(int i) {
			return getRuleContext(ConstExpContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(P7Parser.ASSIGN, 0); }
		public InitValContext initVal() {
			return getRuleContext(InitValContext.class,0);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_varDef);
		int _la;
		try {
			setState(318);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(Ident);
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(297);
					match(T__0);
					setState(298);
					constExp();
					setState(299);
					match(T__1);
					}
					}
					setState(305);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				match(Ident);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(307);
					match(T__0);
					setState(308);
					constExp();
					setState(309);
					match(T__1);
					}
					}
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(316);
				match(ASSIGN);
				setState(317);
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
		public TerminalNode LBrace() { return getToken(P7Parser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(P7Parser.RBrace, 0); }
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
			if ( listener instanceof P7Listener ) ((P7Listener)listener).enterInitVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof P7Listener ) ((P7Listener)listener).exitInitVal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof P7Visitor ) return ((P7Visitor<? extends T>)visitor).visitInitVal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InitValContext initVal() throws RecognitionException {
		InitValContext _localctx = new InitValContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_initVal);
		int _la;
		try {
			setState(333);
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
				setState(320);
				exp();
				}
				break;
			case LBrace:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(LBrace);
				setState(330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LParser) | (1L << LBrace) | (1L << ADD) | (1L << SUB) | (1L << NOT) | (1L << DecimalConst) | (1L << OctalConst) | (1L << HexadecimalConst) | (1L << Ident))) != 0)) {
					{
					setState(322);
					initVal();
					setState(327);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__2) {
						{
						{
						setState(323);
						match(T__2);
						setState(324);
						initVal();
						}
						}
						setState(329);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(332);
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
		case 13:
			return relExp_sempred((RelExpContext)_localctx, predIndex);
		case 14:
			return eqExp_sempred((EqExpContext)_localctx, predIndex);
		case 15:
			return lAndExp_sempred((LAndExpContext)_localctx, predIndex);
		case 16:
			return lOrExp_sempred((LOrExpContext)_localctx, predIndex);
		case 17:
			return addExp_sempred((AddExpContext)_localctx, predIndex);
		case 18:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0152\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\7\6S\n\6\f\6\16\6V\13\6\3\6\3\6\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\5\be\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bo\n\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b|\n\b\3\t\3\t\3\t\3\t\3\t\7"+
		"\t\u0083\n\t\f\t\16\t\u0086\13\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u009a\n\17\f\17\16\17"+
		"\u009d\13\17\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00a5\n\20\f\20\16\20"+
		"\u00a8\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00b0\n\21\f\21\16\21"+
		"\u00b3\13\21\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00bb\n\22\f\22\16\22"+
		"\u00be\13\22\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c6\n\23\f\23\16\23"+
		"\u00c9\13\23\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00d1\n\24\f\24\16\24"+
		"\u00d4\13\24\3\25\3\25\3\25\3\25\3\25\7\25\u00db\n\25\f\25\16\25\u00de"+
		"\13\25\5\25\u00e0\n\25\3\25\3\25\3\25\3\25\5\25\u00e6\n\25\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\5\26\u00ee\n\26\3\27\3\27\5\27\u00f2\n\27\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u00f9\n\30\f\30\16\30\u00fc\13\30\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\7\32\u0107\n\32\f\32\16\32\u010a\13\32"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0114\n\33\f\33\16\33\u0117"+
		"\13\33\5\33\u0119\n\33\3\33\5\33\u011c\n\33\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\7\35\u0124\n\35\f\35\16\35\u0127\13\35\3\35\3\35\3\36\3\36\3\36\3"+
		"\36\3\36\7\36\u0130\n\36\f\36\16\36\u0133\13\36\3\36\3\36\3\36\3\36\3"+
		"\36\7\36\u013a\n\36\f\36\16\36\u013d\13\36\3\36\3\36\5\36\u0141\n\36\3"+
		"\37\3\37\3\37\3\37\3\37\7\37\u0148\n\37\f\37\16\37\u014b\13\37\5\37\u014d"+
		"\n\37\3\37\5\37\u0150\n\37\3\37\2\b\34\36 \"$& \2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<\2\b\3\2$&\3\2\22\25\3\2\26\27"+
		"\3\2\33\34\3\2\35\37\4\2\33\34  \2\u0159\2A\3\2\2\2\4F\3\2\2\2\6H\3\2"+
		"\2\2\bJ\3\2\2\2\nP\3\2\2\2\f[\3\2\2\2\16{\3\2\2\2\20}\3\2\2\2\22\u0087"+
		"\3\2\2\2\24\u0089\3\2\2\2\26\u008b\3\2\2\2\30\u008f\3\2\2\2\32\u0091\3"+
		"\2\2\2\34\u0093\3\2\2\2\36\u009e\3\2\2\2 \u00a9\3\2\2\2\"\u00b4\3\2\2"+
		"\2$\u00bf\3\2\2\2&\u00ca\3\2\2\2(\u00e5\3\2\2\2*\u00ed\3\2\2\2,\u00f1"+
		"\3\2\2\2.\u00f3\3\2\2\2\60\u00ff\3\2\2\2\62\u0101\3\2\2\2\64\u011b\3\2"+
		"\2\2\66\u011d\3\2\2\28\u011f\3\2\2\2:\u0140\3\2\2\2<\u014f\3\2\2\2>@\5"+
		",\27\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\5"+
		"\b\5\2E\3\3\2\2\2FG\7\13\2\2G\5\3\2\2\2HI\7#\2\2I\7\3\2\2\2JK\5\4\3\2"+
		"KL\5\6\4\2LM\7\6\2\2MN\7\7\2\2NO\5\n\6\2O\t\3\2\2\2PT\7\b\2\2QS\5\f\7"+
		"\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2\2\2VT\3\2\2\2WX\7\t\2"+
		"\2X\13\3\2\2\2Y\\\5,\27\2Z\\\5\16\b\2[Y\3\2\2\2[Z\3\2\2\2\\\r\3\2\2\2"+
		"]^\5\20\t\2^_\7\32\2\2_`\5\30\r\2`a\7!\2\2a|\3\2\2\2b|\5\n\6\2ce\5\30"+
		"\r\2dc\3\2\2\2de\3\2\2\2ef\3\2\2\2f|\7!\2\2gh\7\16\2\2hi\7\6\2\2ij\5\32"+
		"\16\2jk\7\7\2\2kn\5\16\b\2lm\7\17\2\2mo\5\16\b\2nl\3\2\2\2no\3\2\2\2o"+
		"|\3\2\2\2pq\7\r\2\2qr\7\6\2\2rs\5\32\16\2st\7\7\2\2tu\5\16\b\2u|\3\2\2"+
		"\2vw\7\20\2\2w|\7!\2\2xy\7\21\2\2y|\7!\2\2z|\5\26\f\2{]\3\2\2\2{b\3\2"+
		"\2\2{d\3\2\2\2{g\3\2\2\2{p\3\2\2\2{v\3\2\2\2{x\3\2\2\2{z\3\2\2\2|\17\3"+
		"\2\2\2}\u0084\7)\2\2~\177\7\3\2\2\177\u0080\5\30\r\2\u0080\u0081\7\4\2"+
		"\2\u0081\u0083\3\2\2\2\u0082~\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\21\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0088\5\24\13\2\u0088\23\3\2\2\2\u0089\u008a\t\2\2\2\u008a\25\3\2\2\2"+
		"\u008b\u008c\7\n\2\2\u008c\u008d\5\30\r\2\u008d\u008e\7!\2\2\u008e\27"+
		"\3\2\2\2\u008f\u0090\5$\23\2\u0090\31\3\2\2\2\u0091\u0092\5\"\22\2\u0092"+
		"\33\3\2\2\2\u0093\u0094\b\17\1\2\u0094\u0095\5$\23\2\u0095\u009b\3\2\2"+
		"\2\u0096\u0097\f\3\2\2\u0097\u0098\t\3\2\2\u0098\u009a\5$\23\2\u0099\u0096"+
		"\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\35\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\b\20\1\2\u009f\u00a0\5\34"+
		"\17\2\u00a0\u00a6\3\2\2\2\u00a1\u00a2\f\3\2\2\u00a2\u00a3\t\4\2\2\u00a3"+
		"\u00a5\5\34\17\2\u00a4\u00a1\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\37\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\b\21\1\2\u00aa\u00ab\5\36\20\2\u00ab\u00b1\3\2\2\2\u00ac\u00ad"+
		"\f\3\2\2\u00ad\u00ae\7\30\2\2\u00ae\u00b0\5\36\20\2\u00af\u00ac\3\2\2"+
		"\2\u00b0\u00b3\3\2\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2!"+
		"\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\b\22\1\2\u00b5\u00b6\5 \21\2"+
		"\u00b6\u00bc\3\2\2\2\u00b7\u00b8\f\3\2\2\u00b8\u00b9\7\31\2\2\u00b9\u00bb"+
		"\5 \21\2\u00ba\u00b7\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc"+
		"\u00bd\3\2\2\2\u00bd#\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\b\23\1\2"+
		"\u00c0\u00c1\5&\24\2\u00c1\u00c7\3\2\2\2\u00c2\u00c3\f\3\2\2\u00c3\u00c4"+
		"\t\5\2\2\u00c4\u00c6\5&\24\2\u00c5\u00c2\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8%\3\2\2\2\u00c9\u00c7\3\2\2\2"+
		"\u00ca\u00cb\b\24\1\2\u00cb\u00cc\5(\25\2\u00cc\u00d2\3\2\2\2\u00cd\u00ce"+
		"\f\3\2\2\u00ce\u00cf\t\6\2\2\u00cf\u00d1\5(\25\2\u00d0\u00cd\3\2\2\2\u00d1"+
		"\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\'\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7)\2\2\u00d6\u00df\7\6\2\2\u00d7\u00dc"+
		"\5\30\r\2\u00d8\u00d9\7\5\2\2\u00d9\u00db\5\30\r\2\u00da\u00d8\3\2\2\2"+
		"\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00e0"+
		"\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e6\7\7\2\2\u00e2\u00e3\t\7\2\2\u00e3\u00e6\5("+
		"\25\2\u00e4\u00e6\5*\26\2\u00e5\u00d5\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5"+
		"\u00e4\3\2\2\2\u00e6)\3\2\2\2\u00e7\u00e8\7\6\2\2\u00e8\u00e9\5\30\r\2"+
		"\u00e9\u00ea\7\7\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ee\5\20\t\2\u00ec\u00ee"+
		"\5\22\n\2\u00ed\u00e7\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed\u00ec\3\2\2\2"+
		"\u00ee+\3\2\2\2\u00ef\u00f2\5.\30\2\u00f0\u00f2\58\35\2\u00f1\u00ef\3"+
		"\2\2\2\u00f1\u00f0\3\2\2\2\u00f2-\3\2\2\2\u00f3\u00f4\7\f\2\2\u00f4\u00f5"+
		"\5\60\31\2\u00f5\u00fa\5\62\32\2\u00f6\u00f7\7\5\2\2\u00f7\u00f9\5\62"+
		"\32\2\u00f8\u00f6\3\2\2\2\u00f9\u00fc\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa"+
		"\u00fb\3\2\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\7!"+
		"\2\2\u00fe/\3\2\2\2\u00ff\u0100\7\13\2\2\u0100\61\3\2\2\2\u0101\u0108"+
		"\7)\2\2\u0102\u0103\7\3\2\2\u0103\u0104\5\66\34\2\u0104\u0105\7\4\2\2"+
		"\u0105\u0107\3\2\2\2\u0106\u0102\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106"+
		"\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u010b\3\2\2\2\u010a\u0108\3\2\2\2\u010b"+
		"\u010c\7\32\2\2\u010c\u010d\5\64\33\2\u010d\63\3\2\2\2\u010e\u011c\5\66"+
		"\34\2\u010f\u0118\7\b\2\2\u0110\u0115\5\64\33\2\u0111\u0112\7\5\2\2\u0112"+
		"\u0114\5\64\33\2\u0113\u0111\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3"+
		"\2\2\2\u0115\u0116\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0118"+
		"\u0110\3\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\7\t"+
		"\2\2\u011b\u010e\3\2\2\2\u011b\u010f\3\2\2\2\u011c\65\3\2\2\2\u011d\u011e"+
		"\5$\23\2\u011e\67\3\2\2\2\u011f\u0120\5\60\31\2\u0120\u0125\5:\36\2\u0121"+
		"\u0122\7\5\2\2\u0122\u0124\5:\36\2\u0123\u0121\3\2\2\2\u0124\u0127\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0128\u0129\7!\2\2\u01299\3\2\2\2\u012a\u0131\7)\2\2\u012b"+
		"\u012c\7\3\2\2\u012c\u012d\5\66\34\2\u012d\u012e\7\4\2\2\u012e\u0130\3"+
		"\2\2\2\u012f\u012b\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0131"+
		"\u0132\3\2\2\2\u0132\u0141\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u013b\7)"+
		"\2\2\u0135\u0136\7\3\2\2\u0136\u0137\5\66\34\2\u0137\u0138\7\4\2\2\u0138"+
		"\u013a\3\2\2\2\u0139\u0135\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2"+
		"\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e"+
		"\u013f\7\32\2\2\u013f\u0141\5<\37\2\u0140\u012a\3\2\2\2\u0140\u0134\3"+
		"\2\2\2\u0141;\3\2\2\2\u0142\u0150\5\30\r\2\u0143\u014c\7\b\2\2\u0144\u0149"+
		"\5<\37\2\u0145\u0146\7\5\2\2\u0146\u0148\5<\37\2\u0147\u0145\3\2\2\2\u0148"+
		"\u014b\3\2\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014d\3\2"+
		"\2\2\u014b\u0149\3\2\2\2\u014c\u0144\3\2\2\2\u014c\u014d\3\2\2\2\u014d"+
		"\u014e\3\2\2\2\u014e\u0150\7\t\2\2\u014f\u0142\3\2\2\2\u014f\u0143\3\2"+
		"\2\2\u0150=\3\2\2\2 AT[dn{\u0084\u009b\u00a6\u00b1\u00bc\u00c7\u00d2\u00dc"+
		"\u00df\u00e5\u00ed\u00f1\u00fa\u0108\u0115\u0118\u011b\u0125\u0131\u013b"+
		"\u0140\u0149\u014c\u014f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}