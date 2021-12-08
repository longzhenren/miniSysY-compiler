// Generated from D:/Projects/IDEA/Compile/src\P6.g4 by ANTLR 4.9.2
package com.miniSysY.P6;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P6Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LParser=2, RParser=3, LBrace=4, RBrace=5, RETURN_KW=6, INT_KW=7, 
		CONST_KW=8, WHILE_KW=9, IF_KW=10, ELSE_KW=11, LT_KW=12, GT_KW=13, LE_KW=14, 
		GE_KW=15, EQ_KW=16, NEQ_KW=17, LAND_KW=18, LOR_KW=19, ASSIGN=20, ADD=21, 
		SUB=22, MUL=23, DIV=24, MOD=25, NOT=26, Semicolon=27, WhiteSpace=28, FuncIdent=29, 
		DecimalConst=30, OctalConst=31, HexadecimalConst=32, BlockComment=33, 
		LineComment=34, Ident=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "WHILE_KW", "IF_KW", "ELSE_KW", "LT_KW", "GT_KW", "LE_KW", 
			"GE_KW", "EQ_KW", "NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", 
			"MUL", "DIV", "MOD", "NOT", "Semicolon", "WhiteSpace", "FuncIdent", "DecimalConst", 
			"OctalConst", "HexadecimalConst", "BlockComment", "LineComment", "Ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'{'", "'}'", "'return'", "'int'", "'const'", 
			"'while'", "'if'", "'else'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", 
			"'&&'", "'||'", null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", "';'", 
			null, "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "WHILE_KW", "IF_KW", "ELSE_KW", "LT_KW", "GT_KW", "LE_KW", 
			"GE_KW", "EQ_KW", "NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", 
			"MUL", "DIV", "MOD", "NOT", "Semicolon", "WhiteSpace", "FuncIdent", "DecimalConst", 
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


	public P6Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P6.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00ed\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00a0\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\7\37"+
		"\u00bb\n\37\f\37\16\37\u00be\13\37\3 \3 \7 \u00c2\n \f \16 \u00c5\13 "+
		"\3!\3!\3!\6!\u00ca\n!\r!\16!\u00cb\3\"\3\"\3\"\3\"\7\"\u00d2\n\"\f\"\16"+
		"\"\u00d5\13\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\7#\u00e0\n#\f#\16#\u00e3"+
		"\13#\3#\3#\3$\3$\7$\u00e9\n$\f$\16$\u00ec\13$\3\u00d3\2%\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\f\5\2\13\f\17\17\"\"\3\2\63;\3\2\62;\3\2\62\62\3\2\629\4\2ZZzz\5"+
		"\2\62;CHch\4\2\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\2\u00fc\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3I\3\2\2\2"+
		"\5K\3\2\2\2\7M\3\2\2\2\tO\3\2\2\2\13Q\3\2\2\2\rS\3\2\2\2\17Z\3\2\2\2\21"+
		"^\3\2\2\2\23d\3\2\2\2\25j\3\2\2\2\27m\3\2\2\2\31r\3\2\2\2\33t\3\2\2\2"+
		"\35v\3\2\2\2\37y\3\2\2\2!|\3\2\2\2#\177\3\2\2\2%\u0082\3\2\2\2\'\u0085"+
		"\3\2\2\2)\u009f\3\2\2\2+\u00a1\3\2\2\2-\u00a3\3\2\2\2/\u00a5\3\2\2\2\61"+
		"\u00a7\3\2\2\2\63\u00a9\3\2\2\2\65\u00ab\3\2\2\2\67\u00ad\3\2\2\29\u00af"+
		"\3\2\2\2;\u00b3\3\2\2\2=\u00b8\3\2\2\2?\u00bf\3\2\2\2A\u00c6\3\2\2\2C"+
		"\u00cd\3\2\2\2E\u00db\3\2\2\2G\u00e6\3\2\2\2IJ\7.\2\2J\4\3\2\2\2KL\7*"+
		"\2\2L\6\3\2\2\2MN\7+\2\2N\b\3\2\2\2OP\7}\2\2P\n\3\2\2\2QR\7\177\2\2R\f"+
		"\3\2\2\2ST\7t\2\2TU\7g\2\2UV\7v\2\2VW\7w\2\2WX\7t\2\2XY\7p\2\2Y\16\3\2"+
		"\2\2Z[\7k\2\2[\\\7p\2\2\\]\7v\2\2]\20\3\2\2\2^_\7e\2\2_`\7q\2\2`a\7p\2"+
		"\2ab\7u\2\2bc\7v\2\2c\22\3\2\2\2de\7y\2\2ef\7j\2\2fg\7k\2\2gh\7n\2\2h"+
		"i\7g\2\2i\24\3\2\2\2jk\7k\2\2kl\7h\2\2l\26\3\2\2\2mn\7g\2\2no\7n\2\2o"+
		"p\7u\2\2pq\7g\2\2q\30\3\2\2\2rs\7>\2\2s\32\3\2\2\2tu\7@\2\2u\34\3\2\2"+
		"\2vw\7>\2\2wx\7?\2\2x\36\3\2\2\2yz\7@\2\2z{\7?\2\2{ \3\2\2\2|}\7?\2\2"+
		"}~\7?\2\2~\"\3\2\2\2\177\u0080\7#\2\2\u0080\u0081\7?\2\2\u0081$\3\2\2"+
		"\2\u0082\u0083\7(\2\2\u0083\u0084\7(\2\2\u0084&\3\2\2\2\u0085\u0086\7"+
		"~\2\2\u0086\u0087\7~\2\2\u0087(\3\2\2\2\u0088\u00a0\7?\2\2\u0089\u008a"+
		"\7,\2\2\u008a\u00a0\7?\2\2\u008b\u008c\7\61\2\2\u008c\u00a0\7?\2\2\u008d"+
		"\u008e\7\'\2\2\u008e\u00a0\7?\2\2\u008f\u0090\7-\2\2\u0090\u00a0\7?\2"+
		"\2\u0091\u0092\7/\2\2\u0092\u00a0\7?\2\2\u0093\u0094\7>\2\2\u0094\u0095"+
		"\7>\2\2\u0095\u00a0\7?\2\2\u0096\u0097\7@\2\2\u0097\u0098\7@\2\2\u0098"+
		"\u00a0\7?\2\2\u0099\u009a\7(\2\2\u009a\u00a0\7?\2\2\u009b\u009c\7`\2\2"+
		"\u009c\u00a0\7?\2\2\u009d\u009e\7~\2\2\u009e\u00a0\7?\2\2\u009f\u0088"+
		"\3\2\2\2\u009f\u0089\3\2\2\2\u009f\u008b\3\2\2\2\u009f\u008d\3\2\2\2\u009f"+
		"\u008f\3\2\2\2\u009f\u0091\3\2\2\2\u009f\u0093\3\2\2\2\u009f\u0096\3\2"+
		"\2\2\u009f\u0099\3\2\2\2\u009f\u009b\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"*\3\2\2\2\u00a1\u00a2\7-\2\2\u00a2,\3\2\2\2\u00a3\u00a4\7/\2\2\u00a4."+
		"\3\2\2\2\u00a5\u00a6\7,\2\2\u00a6\60\3\2\2\2\u00a7\u00a8\7\61\2\2\u00a8"+
		"\62\3\2\2\2\u00a9\u00aa\7\'\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\7#\2\2\u00ac"+
		"\66\3\2\2\2\u00ad\u00ae\7=\2\2\u00ae8\3\2\2\2\u00af\u00b0\t\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\b\35\2\2\u00b2:\3\2\2\2\u00b3\u00b4\7o\2\2"+
		"\u00b4\u00b5\7c\2\2\u00b5\u00b6\7k\2\2\u00b6\u00b7\7p\2\2\u00b7<\3\2\2"+
		"\2\u00b8\u00bc\t\3\2\2\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd>\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c3\t\5\2\2\u00c0\u00c2\t\6\2\2\u00c1\u00c0\3\2"+
		"\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"@\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\t\5\2\2\u00c7\u00c9\t\7\2\2"+
		"\u00c8\u00ca\t\b\2\2\u00c9\u00c8\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9"+
		"\3\2\2\2\u00cb\u00cc\3\2\2\2\u00ccB\3\2\2\2\u00cd\u00ce\7\61\2\2\u00ce"+
		"\u00cf\7,\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d2\13\2\2\2\u00d1\u00d0\3\2"+
		"\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d7\7,\2\2\u00d7\u00d8\7\61"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b\"\2\2\u00daD\3\2\2\2\u00db\u00dc"+
		"\7\61\2\2\u00dc\u00dd\7\61\2\2\u00dd\u00e1\3\2\2\2\u00de\u00e0\n\t\2\2"+
		"\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2"+
		"\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\b#\2\2\u00e5"+
		"F\3\2\2\2\u00e6\u00ea\t\n\2\2\u00e7\u00e9\t\13\2\2\u00e8\u00e7\3\2\2\2"+
		"\u00e9\u00ec\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ebH\3"+
		"\2\2\2\u00ec\u00ea\3\2\2\2\n\2\u009f\u00bc\u00c3\u00cb\u00d3\u00e1\u00ea"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}