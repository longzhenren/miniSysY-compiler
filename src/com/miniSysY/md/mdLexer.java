// Generated from D:/Projects/IDEA/Compile/src\md.g4 by ANTLR 4.9.2
package com.miniSysY.md;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class mdLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "LParser", "RParser", "LBrace", "RBrace", "LBracket", "RBracket", 
			"RETURN_KW", "INT_KW", "VOID_KW", "CONST_KW", "WHILE_KW", "IF_KW", "ELSE_KW", 
			"BREAK_KW", "CONTINUE_KW", "LT_KW", "GT_KW", "LE_KW", "GE_KW", "EQ_KW", 
			"NEQ_KW", "LAND_KW", "LOR_KW", "ASSIGN", "ADD", "SUB", "MUL", "DIV", 
			"MOD", "NOT", "Semicolon", "WhiteSpace", "DecimalConst", "OctalConst", 
			"HexadecimalConst", "BlockComment", "LineComment", "Ident"
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


	public mdLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "md.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u0108\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\5\32\u00c0\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37"+
		"\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3#\3#\7#\u00d6\n#\f#\16#\u00d9\13#\3$\3$"+
		"\7$\u00dd\n$\f$\16$\u00e0\13$\3%\3%\3%\6%\u00e5\n%\r%\16%\u00e6\3&\3&"+
		"\3&\3&\7&\u00ed\n&\f&\16&\u00f0\13&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'"+
		"\u00fb\n\'\f\'\16\'\u00fe\13\'\3\'\3\'\3(\3(\7(\u0104\n(\f(\16(\u0107"+
		"\13(\3\u00ee\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\f\5\2\13\f\17\17\"\"\3\2\63"+
		";\3\2\62;\3\2\62\62\3\2\629\4\2ZZzz\5\2\62;CHch\4\2\f\f\17\17\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\2\u0117\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17"+
		"]\3\2\2\2\21_\3\2\2\2\23f\3\2\2\2\25j\3\2\2\2\27o\3\2\2\2\31u\3\2\2\2"+
		"\33{\3\2\2\2\35~\3\2\2\2\37\u0083\3\2\2\2!\u0089\3\2\2\2#\u0092\3\2\2"+
		"\2%\u0094\3\2\2\2\'\u0096\3\2\2\2)\u0099\3\2\2\2+\u009c\3\2\2\2-\u009f"+
		"\3\2\2\2/\u00a2\3\2\2\2\61\u00a5\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2"+
		"\2\2\67\u00c3\3\2\2\29\u00c5\3\2\2\2;\u00c7\3\2\2\2=\u00c9\3\2\2\2?\u00cb"+
		"\3\2\2\2A\u00cd\3\2\2\2C\u00cf\3\2\2\2E\u00d3\3\2\2\2G\u00da\3\2\2\2I"+
		"\u00e1\3\2\2\2K\u00e8\3\2\2\2M\u00f6\3\2\2\2O\u0101\3\2\2\2QR\7.\2\2R"+
		"\4\3\2\2\2ST\7*\2\2T\6\3\2\2\2UV\7+\2\2V\b\3\2\2\2WX\7}\2\2X\n\3\2\2\2"+
		"YZ\7\177\2\2Z\f\3\2\2\2[\\\7]\2\2\\\16\3\2\2\2]^\7_\2\2^\20\3\2\2\2_`"+
		"\7t\2\2`a\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2de\7p\2\2e\22\3\2\2\2fg\7k"+
		"\2\2gh\7p\2\2hi\7v\2\2i\24\3\2\2\2jk\7x\2\2kl\7q\2\2lm\7k\2\2mn\7f\2\2"+
		"n\26\3\2\2\2op\7e\2\2pq\7q\2\2qr\7p\2\2rs\7u\2\2st\7v\2\2t\30\3\2\2\2"+
		"uv\7y\2\2vw\7j\2\2wx\7k\2\2xy\7n\2\2yz\7g\2\2z\32\3\2\2\2{|\7k\2\2|}\7"+
		"h\2\2}\34\3\2\2\2~\177\7g\2\2\177\u0080\7n\2\2\u0080\u0081\7u\2\2\u0081"+
		"\u0082\7g\2\2\u0082\36\3\2\2\2\u0083\u0084\7d\2\2\u0084\u0085\7t\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0087\7c\2\2\u0087\u0088\7m\2\2\u0088 \3\2\2\2\u0089"+
		"\u008a\7e\2\2\u008a\u008b\7q\2\2\u008b\u008c\7p\2\2\u008c\u008d\7v\2\2"+
		"\u008d\u008e\7k\2\2\u008e\u008f\7p\2\2\u008f\u0090\7w\2\2\u0090\u0091"+
		"\7g\2\2\u0091\"\3\2\2\2\u0092\u0093\7>\2\2\u0093$\3\2\2\2\u0094\u0095"+
		"\7@\2\2\u0095&\3\2\2\2\u0096\u0097\7>\2\2\u0097\u0098\7?\2\2\u0098(\3"+
		"\2\2\2\u0099\u009a\7@\2\2\u009a\u009b\7?\2\2\u009b*\3\2\2\2\u009c\u009d"+
		"\7?\2\2\u009d\u009e\7?\2\2\u009e,\3\2\2\2\u009f\u00a0\7#\2\2\u00a0\u00a1"+
		"\7?\2\2\u00a1.\3\2\2\2\u00a2\u00a3\7(\2\2\u00a3\u00a4\7(\2\2\u00a4\60"+
		"\3\2\2\2\u00a5\u00a6\7~\2\2\u00a6\u00a7\7~\2\2\u00a7\62\3\2\2\2\u00a8"+
		"\u00c0\7?\2\2\u00a9\u00aa\7,\2\2\u00aa\u00c0\7?\2\2\u00ab\u00ac\7\61\2"+
		"\2\u00ac\u00c0\7?\2\2\u00ad\u00ae\7\'\2\2\u00ae\u00c0\7?\2\2\u00af\u00b0"+
		"\7-\2\2\u00b0\u00c0\7?\2\2\u00b1\u00b2\7/\2\2\u00b2\u00c0\7?\2\2\u00b3"+
		"\u00b4\7>\2\2\u00b4\u00b5\7>\2\2\u00b5\u00c0\7?\2\2\u00b6\u00b7\7@\2\2"+
		"\u00b7\u00b8\7@\2\2\u00b8\u00c0\7?\2\2\u00b9\u00ba\7(\2\2\u00ba\u00c0"+
		"\7?\2\2\u00bb\u00bc\7`\2\2\u00bc\u00c0\7?\2\2\u00bd\u00be\7~\2\2\u00be"+
		"\u00c0\7?\2\2\u00bf\u00a8\3\2\2\2\u00bf\u00a9\3\2\2\2\u00bf\u00ab\3\2"+
		"\2\2\u00bf\u00ad\3\2\2\2\u00bf\u00af\3\2\2\2\u00bf\u00b1\3\2\2\2\u00bf"+
		"\u00b3\3\2\2\2\u00bf\u00b6\3\2\2\2\u00bf\u00b9\3\2\2\2\u00bf\u00bb\3\2"+
		"\2\2\u00bf\u00bd\3\2\2\2\u00c0\64\3\2\2\2\u00c1\u00c2\7-\2\2\u00c2\66"+
		"\3\2\2\2\u00c3\u00c4\7/\2\2\u00c48\3\2\2\2\u00c5\u00c6\7,\2\2\u00c6:\3"+
		"\2\2\2\u00c7\u00c8\7\61\2\2\u00c8<\3\2\2\2\u00c9\u00ca\7\'\2\2\u00ca>"+
		"\3\2\2\2\u00cb\u00cc\7#\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7=\2\2\u00ceB\3"+
		"\2\2\2\u00cf\u00d0\t\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d2\b\"\2\2\u00d2"+
		"D\3\2\2\2\u00d3\u00d7\t\3\2\2\u00d4\u00d6\t\4\2\2\u00d5\u00d4\3\2\2\2"+
		"\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8F\3"+
		"\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00de\t\5\2\2\u00db\u00dd\t\6\2\2\u00dc"+
		"\u00db\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00dfH\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\t\5\2\2\u00e2\u00e4"+
		"\t\7\2\2\u00e3\u00e5\t\b\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7J\3\2\2\2\u00e8\u00e9\7\61\2\2"+
		"\u00e9\u00ea\7,\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\13\2\2\2\u00ec\u00eb"+
		"\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef"+
		"\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7,\2\2\u00f2\u00f3\7\61"+
		"\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f5\b&\2\2\u00f5L\3\2\2\2\u00f6\u00f7"+
		"\7\61\2\2\u00f7\u00f8\7\61\2\2\u00f8\u00fc\3\2\2\2\u00f9\u00fb\n\t\2\2"+
		"\u00fa\u00f9\3\2\2\2\u00fb\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd"+
		"\3\2\2\2\u00fd\u00ff\3\2\2\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\b\'\2\2\u0100"+
		"N\3\2\2\2\u0101\u0105\t\n\2\2\u0102\u0104\t\13\2\2\u0103\u0102\3\2\2\2"+
		"\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106P\3"+
		"\2\2\2\u0107\u0105\3\2\2\2\n\2\u00bf\u00d7\u00de\u00e6\u00ee\u00fc\u0105"+
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