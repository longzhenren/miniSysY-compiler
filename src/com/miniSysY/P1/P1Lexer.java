// Generated from D:/Projects/IDEA/Compile/src\P1.g4 by ANTLR 4.9.1
package com.miniSysY.P1;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class P1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LParser=1, RParser=2, LBrace=3, RBrace=4, RETURN_KW=5, INT_KW=6, Semicolumn=7, 
		WhiteSpace=8, FuncIdent=9, DecimalConst=10, OctalConst=11, HexadecimalConst=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", "Semicolumn", 
			"WhiteSpace", "FuncIdent", "DecimalConst", "OctalConst", "HexadecimalConst"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'return'", "'int'", "';'", null, "'main'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LParser", "RParser", "LBrace", "RBrace", "RETURN_KW", "INT_KW", 
			"Semicolumn", "WhiteSpace", "FuncIdent", "DecimalConst", "OctalConst", 
			"HexadecimalConst"
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


	public P1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "P1.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16N\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\13\3\13\7\13<\n\13\f\13\16\13?\13\13\3\f\3\f\7\fC\n\f\f\f\16\fF\13"+
		"\f\3\r\3\r\3\r\6\rK\n\r\r\r\16\rL\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\3\2\t\5\2\13\f\17\17\"\"\3\2\63;\3\2\62;\3"+
		"\2\62\62\3\2\629\4\2ZZzz\5\2\62;CHch\2P\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5\35"+
		"\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3\2\2\2\r*\3\2\2\2\17.\3\2\2\2\21"+
		"\60\3\2\2\2\23\64\3\2\2\2\259\3\2\2\2\27@\3\2\2\2\31G\3\2\2\2\33\34\7"+
		"*\2\2\34\4\3\2\2\2\35\36\7+\2\2\36\6\3\2\2\2\37 \7}\2\2 \b\3\2\2\2!\""+
		"\7\177\2\2\"\n\3\2\2\2#$\7t\2\2$%\7g\2\2%&\7v\2\2&\'\7w\2\2\'(\7t\2\2"+
		"()\7p\2\2)\f\3\2\2\2*+\7k\2\2+,\7p\2\2,-\7v\2\2-\16\3\2\2\2./\7=\2\2/"+
		"\20\3\2\2\2\60\61\t\2\2\2\61\62\3\2\2\2\62\63\b\t\2\2\63\22\3\2\2\2\64"+
		"\65\7o\2\2\65\66\7c\2\2\66\67\7k\2\2\678\7p\2\28\24\3\2\2\29=\t\3\2\2"+
		":<\t\4\2\2;:\3\2\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>\26\3\2\2\2?=\3\2\2"+
		"\2@D\t\5\2\2AC\t\6\2\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3\2\2\2E\30\3\2"+
		"\2\2FD\3\2\2\2GH\t\5\2\2HJ\t\7\2\2IK\t\b\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2"+
		"\2\2LM\3\2\2\2M\32\3\2\2\2\6\2=DL\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}