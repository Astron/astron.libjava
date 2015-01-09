// Generated from /Users/stowellc17/astron.libjava/src/main/antlr4/astron/dc/DC.g4 by ANTLR 4.4.1-dev
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
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, KW_DCLASS=5, KW_STRUCT=6, KW_FROM=7, KW_IMPORT=8, 
		KW_TYPEDEF=9, KW_STRING=10, KW_BLOB=11, KW_INT8=12, KW_INT16=13, KW_INT32=14, 
		KW_INT64=15, KW_UINT8=16, KW_UINT16=17, KW_UINT32=18, KW_UINT64=19, IDENTIFIER=20, 
		WS=21;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "KW_DCLASS", "KW_STRUCT", "KW_FROM", "KW_IMPORT", 
		"KW_TYPEDEF", "KW_STRING", "KW_BLOB", "KW_INT8", "KW_INT16", "KW_INT32", 
		"KW_INT64", "KW_UINT8", "KW_UINT16", "KW_UINT32", "KW_UINT64", "IDENTIFIER", 
		"WS"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\27\u00a1\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\6\25\u0097\n\25\r\25\16\25\u0098\3\26\6"+
		"\26\u009c\n\26\r\26\16\26\u009d\3\26\3\26\2\2\27\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27\3\2\4\5\2\60\60C\\c|\5\2\13\f\17\17\"\"\u00a2\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3-\3\2\2\2\5/\3\2\2\2\7\61\3\2\2\2\t"+
		"\63\3\2\2\2\13\65\3\2\2\2\r<\3\2\2\2\17C\3\2\2\2\21H\3\2\2\2\23O\3\2\2"+
		"\2\25W\3\2\2\2\27^\3\2\2\2\31c\3\2\2\2\33h\3\2\2\2\35n\3\2\2\2\37t\3\2"+
		"\2\2!z\3\2\2\2#\u0080\3\2\2\2%\u0087\3\2\2\2\'\u008e\3\2\2\2)\u0096\3"+
		"\2\2\2+\u009b\3\2\2\2-.\7\60\2\2.\4\3\2\2\2/\60\7.\2\2\60\6\3\2\2\2\61"+
		"\62\7,\2\2\62\b\3\2\2\2\63\64\7\61\2\2\64\n\3\2\2\2\65\66\7f\2\2\66\67"+
		"\7e\2\2\678\7n\2\289\7c\2\29:\7u\2\2:;\7u\2\2;\f\3\2\2\2<=\7u\2\2=>\7"+
		"v\2\2>?\7t\2\2?@\7w\2\2@A\7e\2\2AB\7v\2\2B\16\3\2\2\2CD\7h\2\2DE\7t\2"+
		"\2EF\7q\2\2FG\7o\2\2G\20\3\2\2\2HI\7k\2\2IJ\7o\2\2JK\7r\2\2KL\7q\2\2L"+
		"M\7t\2\2MN\7v\2\2N\22\3\2\2\2OP\7v\2\2PQ\7{\2\2QR\7r\2\2RS\7g\2\2ST\7"+
		"f\2\2TU\7g\2\2UV\7h\2\2V\24\3\2\2\2WX\7u\2\2XY\7v\2\2YZ\7t\2\2Z[\7k\2"+
		"\2[\\\7p\2\2\\]\7i\2\2]\26\3\2\2\2^_\7d\2\2_`\7n\2\2`a\7q\2\2ab\7d\2\2"+
		"b\30\3\2\2\2cd\7k\2\2de\7p\2\2ef\7v\2\2fg\7:\2\2g\32\3\2\2\2hi\7k\2\2"+
		"ij\7p\2\2jk\7v\2\2kl\7\63\2\2lm\78\2\2m\34\3\2\2\2no\7k\2\2op\7p\2\2p"+
		"q\7v\2\2qr\7\65\2\2rs\7\64\2\2s\36\3\2\2\2tu\7k\2\2uv\7p\2\2vw\7v\2\2"+
		"wx\78\2\2xy\7\66\2\2y \3\2\2\2z{\7w\2\2{|\7k\2\2|}\7p\2\2}~\7v\2\2~\177"+
		"\7:\2\2\177\"\3\2\2\2\u0080\u0081\7w\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7p\2\2\u0083\u0084\7v\2\2\u0084\u0085\7\63\2\2\u0085\u0086\78\2\2\u0086"+
		"$\3\2\2\2\u0087\u0088\7w\2\2\u0088\u0089\7k\2\2\u0089\u008a\7p\2\2\u008a"+
		"\u008b\7v\2\2\u008b\u008c\7\65\2\2\u008c\u008d\7\64\2\2\u008d&\3\2\2\2"+
		"\u008e\u008f\7w\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2\u0091\u0092"+
		"\7v\2\2\u0092\u0093\78\2\2\u0093\u0094\7\66\2\2\u0094(\3\2\2\2\u0095\u0097"+
		"\t\2\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2\2\2\u0098"+
		"\u0099\3\2\2\2\u0099*\3\2\2\2\u009a\u009c\t\3\2\2\u009b\u009a\3\2\2\2"+
		"\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f"+
		"\3\2\2\2\u009f\u00a0\b\26\2\2\u00a0,\3\2\2\2\5\2\u0098\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}