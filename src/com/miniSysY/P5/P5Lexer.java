// Generated from D:/Projects/IDEA/Compile/src\P5.g4 by ANTLR 4.9.2
package com.miniSysY.P5;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P5Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LParser=2, RParser=3, LBrace=4, RBrace=5, RETURN_KW=6, INT_KW=7, 
		CONST_KW=8, IF_KW=9, ELSE_KW=10, LT_KW=11, GT_KW=12, LE_KW=13, GE_KW=14, 
		EQ_KW=15, NEQ_KW=16, LAND_KW=17, LOR_KW=18, ASSIGN=19, ADD=20, SUB=21, 
		MUL=22, DIV=23, MOD=24, NOT=25, Semicolon=26, WhiteSpace=27, FuncIdent=28, 
		DecimalConst=29, OctalConst=30, HexadecimalConst=31, BlockComment=32, 
		LineComment=33, Ident=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "IF_KW", "ELSE_KW", "LT_KW", "GT_KW", "LE_KW", "GE_KW", "EQ_KW", 
			"NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "NOT", "Semicolon", "WhiteSpace", "FuncIdent", "DecimalConst", 
			"OctalConst", "HexadecimalConst", "BlockComment", "LineComment", "Ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'{'", "'}'", "'return'", "'int'", "'const'", 
			"'if'", "'else'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&&'", 
			"'||'", null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "';'", null, 
			"'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "IF_KW", "ELSE_KW", "LT_KW", "GT_KW", "LE_KW", "GE_KW", "EQ_KW", 
			"NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "NOT", "Semicolon", "WhiteSpace", "FuncIdent", "DecimalConst", 
			"OctalConst", "HexadecimalConst", "BlockComment", "LineComment", "Ident"
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


	public P5Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P5.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00e5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0098\n\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\35\3\35\3\35\3\35\3\35\3\36\3\36\7\36\u00b3\n\36\f\36\16\36\u00b6\13"+
		"\36\3\37\3\37\7\37\u00ba\n\37\f\37\16\37\u00bd\13\37\3 \3 \3 \6 \u00c2"+
		"\n \r \16 \u00c3\3!\3!\3!\3!\7!\u00ca\n!\f!\16!\u00cd\13!\3!\3!\3!\3!"+
		"\3!\3\"\3\"\3\"\3\"\7\"\u00d8\n\"\f\"\16\"\u00db\13\"\3\"\3\"\3#\3#\7"+
		"#\u00e1\n#\f#\16#\u00e4\13#\3\u00cb\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\f\5\2\13\f\17\17\""+
		"\"\3\2\63;\3\2\62;\3\2\62\62\3\2\629\4\2ZZzz\5\2\62;CHch\4\2\f\f\17\17"+
		"\5\2C\\aac|\6\2\62;C\\aac|\2\u00f4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5I\3\2\2\2\7K\3\2\2\2\tM\3\2\2\2\13"+
		"O\3\2\2\2\rQ\3\2\2\2\17X\3\2\2\2\21\\\3\2\2\2\23b\3\2\2\2\25e\3\2\2\2"+
		"\27j\3\2\2\2\31l\3\2\2\2\33n\3\2\2\2\35q\3\2\2\2\37t\3\2\2\2!w\3\2\2\2"+
		"#z\3\2\2\2%}\3\2\2\2\'\u0097\3\2\2\2)\u0099\3\2\2\2+\u009b\3\2\2\2-\u009d"+
		"\3\2\2\2/\u009f\3\2\2\2\61\u00a1\3\2\2\2\63\u00a3\3\2\2\2\65\u00a5\3\2"+
		"\2\2\67\u00a7\3\2\2\29\u00ab\3\2\2\2;\u00b0\3\2\2\2=\u00b7\3\2\2\2?\u00be"+
		"\3\2\2\2A\u00c5\3\2\2\2C\u00d3\3\2\2\2E\u00de\3\2\2\2GH\7.\2\2H\4\3\2"+
		"\2\2IJ\7*\2\2J\6\3\2\2\2KL\7+\2\2L\b\3\2\2\2MN\7}\2\2N\n\3\2\2\2OP\7\177"+
		"\2\2P\f\3\2\2\2QR\7t\2\2RS\7g\2\2ST\7v\2\2TU\7w\2\2UV\7t\2\2VW\7p\2\2"+
		"W\16\3\2\2\2XY\7k\2\2YZ\7p\2\2Z[\7v\2\2[\20\3\2\2\2\\]\7e\2\2]^\7q\2\2"+
		"^_\7p\2\2_`\7u\2\2`a\7v\2\2a\22\3\2\2\2bc\7k\2\2cd\7h\2\2d\24\3\2\2\2"+
		"ef\7g\2\2fg\7n\2\2gh\7u\2\2hi\7g\2\2i\26\3\2\2\2jk\7>\2\2k\30\3\2\2\2"+
		"lm\7@\2\2m\32\3\2\2\2no\7>\2\2op\7?\2\2p\34\3\2\2\2qr\7@\2\2rs\7?\2\2"+
		"s\36\3\2\2\2tu\7?\2\2uv\7?\2\2v \3\2\2\2wx\7#\2\2xy\7?\2\2y\"\3\2\2\2"+
		"z{\7(\2\2{|\7(\2\2|$\3\2\2\2}~\7~\2\2~\177\7~\2\2\177&\3\2\2\2\u0080\u0098"+
		"\7?\2\2\u0081\u0082\7,\2\2\u0082\u0098\7?\2\2\u0083\u0084\7\61\2\2\u0084"+
		"\u0098\7?\2\2\u0085\u0086\7\'\2\2\u0086\u0098\7?\2\2\u0087\u0088\7-\2"+
		"\2\u0088\u0098\7?\2\2\u0089\u008a\7/\2\2\u008a\u0098\7?\2\2\u008b\u008c"+
		"\7>\2\2\u008c\u008d\7>\2\2\u008d\u0098\7?\2\2\u008e\u008f\7@\2\2\u008f"+
		"\u0090\7@\2\2\u0090\u0098\7?\2\2\u0091\u0092\7(\2\2\u0092\u0098\7?\2\2"+
		"\u0093\u0094\7`\2\2\u0094\u0098\7?\2\2\u0095\u0096\7~\2\2\u0096\u0098"+
		"\7?\2\2\u0097\u0080\3\2\2\2\u0097\u0081\3\2\2\2\u0097\u0083\3\2\2\2\u0097"+
		"\u0085\3\2\2\2\u0097\u0087\3\2\2\2\u0097\u0089\3\2\2\2\u0097\u008b\3\2"+
		"\2\2\u0097\u008e\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0093\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098(\3\2\2\2\u0099\u009a\7-\2\2\u009a*\3\2\2\2\u009b"+
		"\u009c\7/\2\2\u009c,\3\2\2\2\u009d\u009e\7,\2\2\u009e.\3\2\2\2\u009f\u00a0"+
		"\7\61\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7\'\2\2\u00a2\62\3\2\2\2\u00a3"+
		"\u00a4\7#\2\2\u00a4\64\3\2\2\2\u00a5\u00a6\7=\2\2\u00a6\66\3\2\2\2\u00a7"+
		"\u00a8\t\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa\b\34\2\2\u00aa8\3\2\2\2"+
		"\u00ab\u00ac\7o\2\2\u00ac\u00ad\7c\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af"+
		"\7p\2\2\u00af:\3\2\2\2\u00b0\u00b4\t\3\2\2\u00b1\u00b3\t\4\2\2\u00b2\u00b1"+
		"\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5"+
		"<\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00bb\t\5\2\2\u00b8\u00ba\t\6\2\2"+
		"\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc>\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00bf\t\5\2\2\u00bf"+
		"\u00c1\t\7\2\2\u00c0\u00c2\t\b\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4@\3\2\2\2\u00c5\u00c6"+
		"\7\61\2\2\u00c6\u00c7\7,\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00ca\13\2\2\2"+
		"\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\7,\2\2\u00cf"+
		"\u00d0\7\61\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b!\2\2\u00d2B\3\2\2\2"+
		"\u00d3\u00d4\7\61\2\2\u00d4\u00d5\7\61\2\2\u00d5\u00d9\3\2\2\2\u00d6\u00d8"+
		"\n\t\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00dd\b\""+
		"\2\2\u00ddD\3\2\2\2\u00de\u00e2\t\n\2\2\u00df\u00e1\t\13\2\2\u00e0\u00df"+
		"\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3"+
		"F\3\2\2\2\u00e4\u00e2\3\2\2\2\n\2\u0097\u00b4\u00bb\u00c3\u00cb\u00d9"+
		"\u00e2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}