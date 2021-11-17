// Generated from D:/Projects/IDEA/Compile/src\P3.g4 by ANTLR 4.9.2
package com.miniSysY.P3;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P3Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, LParser=2, RParser=3, LBrace=4, RBrace=5, RETURN_KW=6, INT_KW=7, 
		CONST_KW=8, ASSIGN=9, ADD=10, SUB=11, MUL=12, DIV=13, MOD=14, Semicolumn=15, 
		WhiteSpace=16, FuncIdent=17, DecimalConst=18, OctalConst=19, HexadecimalConst=20, 
		BlockComment=21, LineComment=22, Ident=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", "MOD", "Semicolumn", 
			"WhiteSpace", "FuncIdent", "DecimalConst", "OctalConst", "HexadecimalConst", 
			"BlockComment", "LineComment", "Ident"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'('", "')'", "'{'", "'}'", "'return'", "'int'", "'const'", 
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "';'", null, "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"CONST_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", "MOD", "Semicolumn", 
			"WhiteSpace", "FuncIdent", "DecimalConst", "OctalConst", "HexadecimalConst", 
			"BlockComment", "LineComment", "Ident"
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


	public P3Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P3.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u00af\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nd\n\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\7\23}\n\23\f\23\16\23\u0080\13\23"+
		"\3\24\3\24\7\24\u0084\n\24\f\24\16\24\u0087\13\24\3\25\3\25\3\25\6\25"+
		"\u008c\n\25\r\25\16\25\u008d\3\26\3\26\3\26\3\26\7\26\u0094\n\26\f\26"+
		"\16\26\u0097\13\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u00a2"+
		"\n\27\f\27\16\27\u00a5\13\27\3\27\3\27\3\30\3\30\7\30\u00ab\n\30\f\30"+
		"\16\30\u00ae\13\30\3\u0095\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\3\2\f\5\2\13\f\17\17\"\"\3\2\63;\3\2\62;\3\2\62\62\3\2\629\4\2ZZzz\5"+
		"\2\62;CHch\4\2\f\f\17\17\5\2C\\aac|\6\2\62;C\\aac|\2\u00be\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\3\61\3\2\2"+
		"\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2\2\2\17B\3"+
		"\2\2\2\21F\3\2\2\2\23c\3\2\2\2\25e\3\2\2\2\27g\3\2\2\2\31i\3\2\2\2\33"+
		"k\3\2\2\2\35m\3\2\2\2\37o\3\2\2\2!q\3\2\2\2#u\3\2\2\2%z\3\2\2\2\'\u0081"+
		"\3\2\2\2)\u0088\3\2\2\2+\u008f\3\2\2\2-\u009d\3\2\2\2/\u00a8\3\2\2\2\61"+
		"\62\7.\2\2\62\4\3\2\2\2\63\64\7*\2\2\64\6\3\2\2\2\65\66\7+\2\2\66\b\3"+
		"\2\2\2\678\7}\2\28\n\3\2\2\29:\7\177\2\2:\f\3\2\2\2;<\7t\2\2<=\7g\2\2"+
		"=>\7v\2\2>?\7w\2\2?@\7t\2\2@A\7p\2\2A\16\3\2\2\2BC\7k\2\2CD\7p\2\2DE\7"+
		"v\2\2E\20\3\2\2\2FG\7e\2\2GH\7q\2\2HI\7p\2\2IJ\7u\2\2JK\7v\2\2K\22\3\2"+
		"\2\2Ld\7?\2\2MN\7,\2\2Nd\7?\2\2OP\7\61\2\2Pd\7?\2\2QR\7\'\2\2Rd\7?\2\2"+
		"ST\7-\2\2Td\7?\2\2UV\7/\2\2Vd\7?\2\2WX\7>\2\2XY\7>\2\2Yd\7?\2\2Z[\7@\2"+
		"\2[\\\7@\2\2\\d\7?\2\2]^\7(\2\2^d\7?\2\2_`\7`\2\2`d\7?\2\2ab\7~\2\2bd"+
		"\7?\2\2cL\3\2\2\2cM\3\2\2\2cO\3\2\2\2cQ\3\2\2\2cS\3\2\2\2cU\3\2\2\2cW"+
		"\3\2\2\2cZ\3\2\2\2c]\3\2\2\2c_\3\2\2\2ca\3\2\2\2d\24\3\2\2\2ef\7-\2\2"+
		"f\26\3\2\2\2gh\7/\2\2h\30\3\2\2\2ij\7,\2\2j\32\3\2\2\2kl\7\61\2\2l\34"+
		"\3\2\2\2mn\7\'\2\2n\36\3\2\2\2op\7=\2\2p \3\2\2\2qr\t\2\2\2rs\3\2\2\2"+
		"st\b\21\2\2t\"\3\2\2\2uv\7o\2\2vw\7c\2\2wx\7k\2\2xy\7p\2\2y$\3\2\2\2z"+
		"~\t\3\2\2{}\t\4\2\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177"+
		"&\3\2\2\2\u0080~\3\2\2\2\u0081\u0085\t\5\2\2\u0082\u0084\t\6\2\2\u0083"+
		"\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086(\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u0089\t\5\2\2\u0089\u008b"+
		"\t\7\2\2\u008a\u008c\t\b\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e*\3\2\2\2\u008f\u0090\7\61\2\2"+
		"\u0090\u0091\7,\2\2\u0091\u0095\3\2\2\2\u0092\u0094\13\2\2\2\u0093\u0092"+
		"\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7,\2\2\u0099\u009a\7\61"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009c\b\26\2\2\u009c,\3\2\2\2\u009d\u009e"+
		"\7\61\2\2\u009e\u009f\7\61\2\2\u009f\u00a3\3\2\2\2\u00a0\u00a2\n\t\2\2"+
		"\u00a1\u00a0\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4"+
		"\3\2\2\2\u00a4\u00a6\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a6\u00a7\b\27\2\2"+
		"\u00a7.\3\2\2\2\u00a8\u00ac\t\n\2\2\u00a9\u00ab\t\13\2\2\u00aa\u00a9\3"+
		"\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\60\3\2\2\2\u00ae\u00ac\3\2\2\2\n\2c~\u0085\u008d\u0095\u00a3\u00ac\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}