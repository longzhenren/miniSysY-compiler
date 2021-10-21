// Generated from D:/Projects/IDEA/Compile/src\P2.g4 by ANTLR 4.9.1
package com.miniSysY.P2;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P2Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LParser=1, RParser=2, LBrace=3, RBrace=4, RETURN_KW=5, INT_KW=6, ADD=7, 
		SUB=8, MUL=9, DIV=10, MOD=11, Semicolumn=12, WhiteSpace=13, FuncIdent=14, 
		DecimalConst=15, OctalConst=16, HexadecimalConst=17, BlockComment=18, 
		LineComment=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", "ADD", 
			"SUB", "MUL", "DIV", "MOD", "Semicolumn", "WhiteSpace", "FuncIdent", 
			"DecimalConst", "OctalConst", "HexadecimalConst", "BlockComment", "LineComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'return'", "'int'", "'+'", "'-'", 
			"'*'", "'/'", "'%'", "';'", null, "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"ADD", "SUB", "MUL", "DIV", "MOD", "Semicolumn", "WhiteSpace", "FuncIdent", 
			"DecimalConst", "OctalConst", "HexadecimalConst", "BlockComment", "LineComment"
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


	public P2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\177\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20T\n"+
		"\20\f\20\16\20W\13\20\3\21\3\21\7\21[\n\21\f\21\16\21^\13\21\3\22\3\22"+
		"\3\22\6\22c\n\22\r\22\16\22d\3\23\3\23\3\23\3\23\7\23k\n\23\f\23\16\23"+
		"n\13\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24y\n\24\f\24\16"+
		"\24|\13\24\3\24\3\24\3l\2\25\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25\3\2\n\5\2\13\f\17"+
		"\17\"\"\3\2\63;\3\2\62;\3\2\62\62\3\2\629\4\2ZZzz\5\2\62;CHch\4\2\f\f"+
		"\17\17\2\u0083\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\3)\3\2\2\2\5+\3\2\2\2\7-\3\2"+
		"\2\2\t/\3\2\2\2\13\61\3\2\2\2\r8\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23@\3"+
		"\2\2\2\25B\3\2\2\2\27D\3\2\2\2\31F\3\2\2\2\33H\3\2\2\2\35L\3\2\2\2\37"+
		"Q\3\2\2\2!X\3\2\2\2#_\3\2\2\2%f\3\2\2\2\'t\3\2\2\2)*\7*\2\2*\4\3\2\2\2"+
		"+,\7+\2\2,\6\3\2\2\2-.\7}\2\2.\b\3\2\2\2/\60\7\177\2\2\60\n\3\2\2\2\61"+
		"\62\7t\2\2\62\63\7g\2\2\63\64\7v\2\2\64\65\7w\2\2\65\66\7t\2\2\66\67\7"+
		"p\2\2\67\f\3\2\2\289\7k\2\29:\7p\2\2:;\7v\2\2;\16\3\2\2\2<=\7-\2\2=\20"+
		"\3\2\2\2>?\7/\2\2?\22\3\2\2\2@A\7,\2\2A\24\3\2\2\2BC\7\61\2\2C\26\3\2"+
		"\2\2DE\7\'\2\2E\30\3\2\2\2FG\7=\2\2G\32\3\2\2\2HI\t\2\2\2IJ\3\2\2\2JK"+
		"\b\16\2\2K\34\3\2\2\2LM\7o\2\2MN\7c\2\2NO\7k\2\2OP\7p\2\2P\36\3\2\2\2"+
		"QU\t\3\2\2RT\t\4\2\2SR\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2V \3\2\2\2"+
		"WU\3\2\2\2X\\\t\5\2\2Y[\t\6\2\2ZY\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2"+
		"\2\2]\"\3\2\2\2^\\\3\2\2\2_`\t\5\2\2`b\t\7\2\2ac\t\b\2\2ba\3\2\2\2cd\3"+
		"\2\2\2db\3\2\2\2de\3\2\2\2e$\3\2\2\2fg\7\61\2\2gh\7,\2\2hl\3\2\2\2ik\13"+
		"\2\2\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3\2\2\2mo\3\2\2\2nl\3\2\2\2op\7"+
		",\2\2pq\7\61\2\2qr\3\2\2\2rs\b\23\2\2s&\3\2\2\2tu\7\61\2\2uv\7\61\2\2"+
		"vz\3\2\2\2wy\n\t\2\2xw\3\2\2\2y|\3\2\2\2zx\3\2\2\2z{\3\2\2\2{}\3\2\2\2"+
		"|z\3\2\2\2}~\b\24\2\2~(\3\2\2\2\b\2U\\dlz\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}