// Generated from /Users/stowellc17/astron.libjava/src/main/antlr4/astron/dc/DC.g4 by ANTLR 4.4.1-dev
package astron.dc;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4.1-dev", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, KW_DCLASS=5, KW_STRUCT=6, KW_FROM=7, KW_IMPORT=8, 
		KW_TYPEDEF=9, KW_STRING=10, KW_BLOB=11, KW_INT8=12, KW_INT16=13, KW_INT32=14, 
		KW_INT64=15, KW_UINT8=16, KW_UINT16=17, KW_UINT32=18, KW_UINT64=19, IDENTIFIER=20, 
		WS=21;
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "','", "'*'", "'/'", "'dclass'", "'struct'", "'from'", 
		"'import'", "'typedef'", "'string'", "'blob'", "'int8'", "'int16'", "'int32'", 
		"'int64'", "'uint8'", "'uint16'", "'uint32'", "'uint64'", "IDENTIFIER", 
		"WS"
	};
	public static final int
		RULE_import_dclass = 0, RULE_import_module = 1, RULE_import_symbols = 2, 
		RULE_import_symbol_list = 3, RULE_import_alternatives = 4;
	public static final String[] ruleNames = {
		"import_dclass", "import_module", "import_symbols", "import_symbol_list", 
		"import_alternatives"
	};

	@Override
	public String getGrammarFileName() { return "DC.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Import_dclassContext extends ParserRuleContext {
		public Import_symbolsContext import_symbols() {
			return getRuleContext(Import_symbolsContext.class,0);
		}
		public TerminalNode KW_FROM() { return getToken(DCParser.KW_FROM, 0); }
		public Import_moduleContext import_module() {
			return getRuleContext(Import_moduleContext.class,0);
		}
		public TerminalNode KW_IMPORT() { return getToken(DCParser.KW_IMPORT, 0); }
		public Import_dclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_dclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImport_dclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImport_dclass(this);
		}
	}

	public final Import_dclassContext import_dclass() throws RecognitionException {
		Import_dclassContext _localctx = new Import_dclassContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_import_dclass);
		try {
			setState(17);
			switch (_input.LA(1)) {
			case KW_IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(10); match(KW_IMPORT);
				setState(11); import_module(0);
				}
				break;
			case KW_FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(12); match(KW_FROM);
				setState(13); import_module(0);
				setState(14); match(KW_IMPORT);
				setState(15); import_symbols();
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

	public static class Import_moduleContext extends ParserRuleContext {
		public Import_moduleContext import_module() {
			return getRuleContext(Import_moduleContext.class,0);
		}
		public Import_alternativesContext import_alternatives() {
			return getRuleContext(Import_alternativesContext.class,0);
		}
		public Import_moduleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_module; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImport_module(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImport_module(this);
		}
	}

	public final Import_moduleContext import_module() throws RecognitionException {
		return import_module(0);
	}

	private Import_moduleContext import_module(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Import_moduleContext _localctx = new Import_moduleContext(_ctx, _parentState);
		Import_moduleContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_import_module, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(20); import_alternatives(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Import_moduleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_import_module);
					setState(22);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(23); match(T__3);
					setState(24); import_alternatives(0);
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
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

	public static class Import_symbolsContext extends ParserRuleContext {
		public Import_symbol_listContext import_symbol_list() {
			return getRuleContext(Import_symbol_listContext.class,0);
		}
		public Import_symbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_symbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImport_symbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImport_symbols(this);
		}
	}

	public final Import_symbolsContext import_symbols() throws RecognitionException {
		Import_symbolsContext _localctx = new Import_symbolsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_import_symbols);
		try {
			setState(32);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(30); import_symbol_list(0);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(T__1);
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

	public static class Import_symbol_listContext extends ParserRuleContext {
		public Import_symbol_listContext import_symbol_list() {
			return getRuleContext(Import_symbol_listContext.class,0);
		}
		public Import_alternativesContext import_alternatives() {
			return getRuleContext(Import_alternativesContext.class,0);
		}
		public Import_symbol_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_symbol_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImport_symbol_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImport_symbol_list(this);
		}
	}

	public final Import_symbol_listContext import_symbol_list() throws RecognitionException {
		return import_symbol_list(0);
	}

	private Import_symbol_listContext import_symbol_list(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Import_symbol_listContext _localctx = new Import_symbol_listContext(_ctx, _parentState);
		Import_symbol_listContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_import_symbol_list, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(35); import_alternatives(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Import_symbol_listContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_import_symbol_list);
					setState(37);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(38); match(T__2);
					setState(39); import_alternatives(0);
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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

	public static class Import_alternativesContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DCParser.IDENTIFIER, 0); }
		public Import_alternativesContext import_alternatives() {
			return getRuleContext(Import_alternativesContext.class,0);
		}
		public Import_alternativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_alternatives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImport_alternatives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImport_alternatives(this);
		}
	}

	public final Import_alternativesContext import_alternatives() throws RecognitionException {
		return import_alternatives(0);
	}

	private Import_alternativesContext import_alternatives(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Import_alternativesContext _localctx = new Import_alternativesContext(_ctx, _parentState);
		Import_alternativesContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_import_alternatives, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(46); match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(53);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Import_alternativesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_import_alternatives);
					setState(48);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(49); match(T__0);
					setState(50); match(IDENTIFIER);
					}
					} 
				}
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return import_module_sempred((Import_moduleContext)_localctx, predIndex);
		case 3: return import_symbol_list_sempred((Import_symbol_listContext)_localctx, predIndex);
		case 4: return import_alternatives_sempred((Import_alternativesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean import_symbol_list_sempred(Import_symbol_listContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean import_alternatives_sempred(Import_alternativesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean import_module_sempred(Import_moduleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\27;\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\24\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\5\4#\n\4\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\6\3\6\3\6\3\6\3\6\3\6\7"+
		"\6\66\n\6\f\6\16\69\13\6\3\6\2\5\4\b\n\7\2\4\6\b\n\2\2:\2\23\3\2\2\2\4"+
		"\25\3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n/\3\2\2\2\f\r\7\n\2\2\r\24\5\4\3\2"+
		"\16\17\7\t\2\2\17\20\5\4\3\2\20\21\7\n\2\2\21\22\5\6\4\2\22\24\3\2\2\2"+
		"\23\f\3\2\2\2\23\16\3\2\2\2\24\3\3\2\2\2\25\26\b\3\1\2\26\27\5\n\6\2\27"+
		"\35\3\2\2\2\30\31\f\3\2\2\31\32\7\3\2\2\32\34\5\n\6\2\33\30\3\2\2\2\34"+
		"\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\5\3\2\2\2\37\35\3\2\2\2 #\5"+
		"\b\5\2!#\7\5\2\2\" \3\2\2\2\"!\3\2\2\2#\7\3\2\2\2$%\b\5\1\2%&\5\n\6\2"+
		"&,\3\2\2\2\'(\f\3\2\2()\7\4\2\2)+\5\n\6\2*\'\3\2\2\2+.\3\2\2\2,*\3\2\2"+
		"\2,-\3\2\2\2-\t\3\2\2\2.,\3\2\2\2/\60\b\6\1\2\60\61\7\26\2\2\61\67\3\2"+
		"\2\2\62\63\f\3\2\2\63\64\7\6\2\2\64\66\7\26\2\2\65\62\3\2\2\2\669\3\2"+
		"\2\2\67\65\3\2\2\2\678\3\2\2\28\13\3\2\2\29\67\3\2\2\2\7\23\35\",\67";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}