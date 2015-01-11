// Generated from astron/dc/DC.g4 by ANTLR 4.3
package astron.dc;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DCLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, KW_DCLASS=6, KW_STRUCT=7, KW_FROM=8, 
		KW_IMPORT=9, KW_TYPEDEF=10, KW_KEYWORD=11, KW_STRING=12, KW_BLOB=13, KW_INT8=14, 
		KW_INT16=15, KW_INT32=16, KW_INT64=17, KW_UINT8=18, KW_UINT16=19, KW_UINT32=20, 
		KW_UINT64=21, KW_FLOAT32=22, KW_FLOAT64=23, LINE_COMMENT=24, BLOCK_COMMENT=25, 
		IDENTIFIER=26, WS=27;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'"
	};
	public static final String[] ruleNames = {
		"T__4", "T__3", "T__2", "T__1", "T__0", "KW_DCLASS", "KW_STRUCT", "KW_FROM", 
		"KW_IMPORT", "KW_TYPEDEF", "KW_KEYWORD", "KW_STRING", "KW_BLOB", "KW_INT8", 
		"KW_INT16", "KW_INT32", "KW_INT64", "KW_UINT8", "KW_UINT16", "KW_UINT32", 
		"KW_UINT64", "KW_FLOAT32", "KW_FLOAT64", "LINE_COMMENT", "BLOCK_COMMENT", 
		"IDENTIFIER", "WS"
	};


	public DCLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "DC.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\35\u00e1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\7\31\u00c0\n\31\f\31\16\31\u00c3\13\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\7\32\u00cb\n\32\f\32\16\32\u00ce\13\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\33\3\33\6\33\u00d7\n\33\r\33\16\33\u00d8\3\34\6"+
		"\34\u00dc\n\34\r\34\16\34\u00dd\3\34\3\34\3\u00cc\2\35\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\6\4\2\f\f\17\17\5\2"+
		"C\\aac|\6\2\62;C\\aac|\5\2\13\f\17\17\"\"\u00e4\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\t?\3"+
		"\2\2\2\13A\3\2\2\2\rC\3\2\2\2\17J\3\2\2\2\21Q\3\2\2\2\23V\3\2\2\2\25]"+
		"\3\2\2\2\27e\3\2\2\2\31m\3\2\2\2\33t\3\2\2\2\35y\3\2\2\2\37~\3\2\2\2!"+
		"\u0084\3\2\2\2#\u008a\3\2\2\2%\u0090\3\2\2\2\'\u0096\3\2\2\2)\u009d\3"+
		"\2\2\2+\u00a4\3\2\2\2-\u00ab\3\2\2\2/\u00b3\3\2\2\2\61\u00bb\3\2\2\2\63"+
		"\u00c6\3\2\2\2\65\u00d4\3\2\2\2\67\u00db\3\2\2\29:\7\60\2\2:\4\3\2\2\2"+
		";<\7.\2\2<\6\3\2\2\2=>\7,\2\2>\b\3\2\2\2?@\7\61\2\2@\n\3\2\2\2AB\7=\2"+
		"\2B\f\3\2\2\2CD\7f\2\2DE\7e\2\2EF\7n\2\2FG\7c\2\2GH\7u\2\2HI\7u\2\2I\16"+
		"\3\2\2\2JK\7u\2\2KL\7v\2\2LM\7t\2\2MN\7w\2\2NO\7e\2\2OP\7v\2\2P\20\3\2"+
		"\2\2QR\7h\2\2RS\7t\2\2ST\7q\2\2TU\7o\2\2U\22\3\2\2\2VW\7k\2\2WX\7o\2\2"+
		"XY\7r\2\2YZ\7q\2\2Z[\7t\2\2[\\\7v\2\2\\\24\3\2\2\2]^\7v\2\2^_\7{\2\2_"+
		"`\7r\2\2`a\7g\2\2ab\7f\2\2bc\7g\2\2cd\7h\2\2d\26\3\2\2\2ef\7m\2\2fg\7"+
		"g\2\2gh\7{\2\2hi\7y\2\2ij\7q\2\2jk\7t\2\2kl\7f\2\2l\30\3\2\2\2mn\7u\2"+
		"\2no\7v\2\2op\7t\2\2pq\7k\2\2qr\7p\2\2rs\7i\2\2s\32\3\2\2\2tu\7d\2\2u"+
		"v\7n\2\2vw\7q\2\2wx\7d\2\2x\34\3\2\2\2yz\7k\2\2z{\7p\2\2{|\7v\2\2|}\7"+
		":\2\2}\36\3\2\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0081\7v\2\2\u0081"+
		"\u0082\7\63\2\2\u0082\u0083\78\2\2\u0083 \3\2\2\2\u0084\u0085\7k\2\2\u0085"+
		"\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087\u0088\7\65\2\2\u0088\u0089\7\64"+
		"\2\2\u0089\"\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u008d"+
		"\7v\2\2\u008d\u008e\78\2\2\u008e\u008f\7\66\2\2\u008f$\3\2\2\2\u0090\u0091"+
		"\7w\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093\u0094\7v\2\2\u0094"+
		"\u0095\7:\2\2\u0095&\3\2\2\2\u0096\u0097\7w\2\2\u0097\u0098\7k\2\2\u0098"+
		"\u0099\7p\2\2\u0099\u009a\7v\2\2\u009a\u009b\7\63\2\2\u009b\u009c\78\2"+
		"\2\u009c(\3\2\2\2\u009d\u009e\7w\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7"+
		"p\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7\65\2\2\u00a2\u00a3\7\64\2\2\u00a3"+
		"*\3\2\2\2\u00a4\u00a5\7w\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7p\2\2\u00a7"+
		"\u00a8\7v\2\2\u00a8\u00a9\78\2\2\u00a9\u00aa\7\66\2\2\u00aa,\3\2\2\2\u00ab"+
		"\u00ac\7h\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7c\2\2"+
		"\u00af\u00b0\7v\2\2\u00b0\u00b1\7\65\2\2\u00b1\u00b2\7\64\2\2\u00b2.\3"+
		"\2\2\2\u00b3\u00b4\7h\2\2\u00b4\u00b5\7n\2\2\u00b5\u00b6\7q\2\2\u00b6"+
		"\u00b7\7c\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\78\2\2\u00b9\u00ba\7\66\2"+
		"\2\u00ba\60\3\2\2\2\u00bb\u00bc\7\61\2\2\u00bc\u00bd\7\61\2\2\u00bd\u00c1"+
		"\3\2\2\2\u00be\u00c0\n\2\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2"+
		"\2\2\u00c4\u00c5\b\31\2\2\u00c5\62\3\2\2\2\u00c6\u00c7\7\61\2\2\u00c7"+
		"\u00c8\7,\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\13\2\2\2\u00ca\u00c9\3\2"+
		"\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd"+
		"\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7,\2\2\u00d0\u00d1\7\61"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d3\b\32\2\2\u00d3\64\3\2\2\2\u00d4\u00d6"+
		"\t\3\2\2\u00d5\u00d7\t\4\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\66\3\2\2\2\u00da\u00dc\t\5\2"+
		"\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de"+
		"\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\b\34\2\2\u00e08\3\2\2\2\7\2\u00c1"+
		"\u00cc\u00d8\u00dd\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}