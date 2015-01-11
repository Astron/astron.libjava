// Generated from astron/dc/DC.g4 by ANTLR 4.3
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
	public static final String[] tokenNames = {
		"<INVALID>", "'.'", "','", "'*'", "'/'", "';'", "'dclass'", "'struct'", 
		"'from'", "'import'", "'typedef'", "'keyword'", "'string'", "'blob'", 
		"'int8'", "'int16'", "'int32'", "'int64'", "'uint8'", "'uint16'", "'uint32'", 
		"'uint64'", "'float32'", "'float64'", "LINE_COMMENT", "BLOCK_COMMENT", 
		"IDENTIFIER", "WS"
	};
	public static final int
		RULE_init = 0, RULE_statement = 1, RULE_importDclass = 2, RULE_importModule = 3, 
		RULE_importSymbols = 4, RULE_importSymbolList = 5, RULE_importAlternatives = 6, 
		RULE_keywordDef = 7;
	public static final String[] ruleNames = {
		"init", "statement", "importDclass", "importModule", "importSymbols", 
		"importSymbolList", "importAlternatives", "keywordDef"
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
	public static class InitContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public InitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitInit(this);
		}
	}

	public final InitContext init() throws RecognitionException {
		InitContext _localctx = new InitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_init);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KW_FROM) | (1L << KW_IMPORT) | (1L << KW_KEYWORD))) != 0)) {
				{
				{
				setState(16); statement();
				}
				}
				setState(21);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatementContext extends ParserRuleContext {
		public ImportDclassContext importDclass() {
			return getRuleContext(ImportDclassContext.class,0);
		}
		public KeywordDefContext keywordDef() {
			return getRuleContext(KeywordDefContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(24);
			switch (_input.LA(1)) {
			case KW_FROM:
			case KW_IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(22); importDclass();
				}
				break;
			case KW_KEYWORD:
				enterOuterAlt(_localctx, 2);
				{
				setState(23); keywordDef();
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

	public static class ImportDclassContext extends ParserRuleContext {
		public ImportSymbolsContext importSymbols() {
			return getRuleContext(ImportSymbolsContext.class,0);
		}
		public TerminalNode KW_FROM() { return getToken(DCParser.KW_FROM, 0); }
		public ImportModuleContext importModule() {
			return getRuleContext(ImportModuleContext.class,0);
		}
		public TerminalNode KW_IMPORT() { return getToken(DCParser.KW_IMPORT, 0); }
		public ImportDclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImportDclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImportDclass(this);
		}
	}

	public final ImportDclassContext importDclass() throws RecognitionException {
		ImportDclassContext _localctx = new ImportDclassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDclass);
		try {
			setState(33);
			switch (_input.LA(1)) {
			case KW_IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(26); match(KW_IMPORT);
				setState(27); importModule(0);
				}
				break;
			case KW_FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(28); match(KW_FROM);
				setState(29); importModule(0);
				setState(30); match(KW_IMPORT);
				setState(31); importSymbols();
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

	public static class ImportModuleContext extends ParserRuleContext {
		public ImportModuleContext importModule() {
			return getRuleContext(ImportModuleContext.class,0);
		}
		public ImportAlternativesContext importAlternatives() {
			return getRuleContext(ImportAlternativesContext.class,0);
		}
		public ImportModuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importModule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImportModule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImportModule(this);
		}
	}

	public final ImportModuleContext importModule() throws RecognitionException {
		return importModule(0);
	}

	private ImportModuleContext importModule(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ImportModuleContext _localctx = new ImportModuleContext(_ctx, _parentState);
		ImportModuleContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_importModule, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(36); importAlternatives(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ImportModuleContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_importModule);
					setState(38);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(39); match(T__4);
					setState(40); importAlternatives(0);
					}
					} 
				}
				setState(45);
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

	public static class ImportSymbolsContext extends ParserRuleContext {
		public ImportSymbolListContext importSymbolList() {
			return getRuleContext(ImportSymbolListContext.class,0);
		}
		public ImportSymbolsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSymbols; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImportSymbols(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImportSymbols(this);
		}
	}

	public final ImportSymbolsContext importSymbols() throws RecognitionException {
		ImportSymbolsContext _localctx = new ImportSymbolsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importSymbols);
		try {
			setState(48);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(46); importSymbolList(0);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); match(T__2);
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

	public static class ImportSymbolListContext extends ParserRuleContext {
		public ImportSymbolListContext importSymbolList() {
			return getRuleContext(ImportSymbolListContext.class,0);
		}
		public ImportAlternativesContext importAlternatives() {
			return getRuleContext(ImportAlternativesContext.class,0);
		}
		public ImportSymbolListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importSymbolList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImportSymbolList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImportSymbolList(this);
		}
	}

	public final ImportSymbolListContext importSymbolList() throws RecognitionException {
		return importSymbolList(0);
	}

	private ImportSymbolListContext importSymbolList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ImportSymbolListContext _localctx = new ImportSymbolListContext(_ctx, _parentState);
		ImportSymbolListContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_importSymbolList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(51); importAlternatives(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ImportSymbolListContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_importSymbolList);
					setState(53);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(54); match(T__3);
					setState(55); importAlternatives(0);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class ImportAlternativesContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DCParser.IDENTIFIER, 0); }
		public ImportAlternativesContext importAlternatives() {
			return getRuleContext(ImportAlternativesContext.class,0);
		}
		public ImportAlternativesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importAlternatives; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterImportAlternatives(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitImportAlternatives(this);
		}
	}

	public final ImportAlternativesContext importAlternatives() throws RecognitionException {
		return importAlternatives(0);
	}

	private ImportAlternativesContext importAlternatives(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ImportAlternativesContext _localctx = new ImportAlternativesContext(_ctx, _parentState);
		ImportAlternativesContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_importAlternatives, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(62); match(IDENTIFIER);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ImportAlternativesContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_importAlternatives);
					setState(64);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(65); match(T__1);
					setState(66); match(IDENTIFIER);
					}
					} 
				}
				setState(71);
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
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class KeywordDefContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(DCParser.IDENTIFIER, 0); }
		public TerminalNode KW_KEYWORD() { return getToken(DCParser.KW_KEYWORD, 0); }
		public KeywordDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keywordDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).enterKeywordDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DCListener ) ((DCListener)listener).exitKeywordDef(this);
		}
	}

	public final KeywordDefContext keywordDef() throws RecognitionException {
		KeywordDefContext _localctx = new KeywordDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_keywordDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72); match(KW_KEYWORD);
			setState(73); match(IDENTIFIER);
			setState(74); match(T__0);
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
		case 3: return importModule_sempred((ImportModuleContext)_localctx, predIndex);

		case 5: return importSymbolList_sempred((ImportSymbolListContext)_localctx, predIndex);

		case 6: return importAlternatives_sempred((ImportAlternativesContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean importAlternatives_sempred(ImportAlternativesContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean importSymbolList_sempred(ImportSymbolListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean importModule_sempred(ImportModuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\35O\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\7\2\24\n\2\f\2"+
		"\16\2\27\13\2\3\3\3\3\5\3\33\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4$\n\4"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\3\6\3\6\5\6\63\n\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7;\n\7\f\7\16\7>\13\7\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\bF\n\b\f\b\16\bI\13\b\3\t\3\t\3\t\3\t\3\t\2\5\b\f\16\n\2\4\6\b\n\f"+
		"\16\20\2\2M\2\25\3\2\2\2\4\32\3\2\2\2\6#\3\2\2\2\b%\3\2\2\2\n\62\3\2\2"+
		"\2\f\64\3\2\2\2\16?\3\2\2\2\20J\3\2\2\2\22\24\5\4\3\2\23\22\3\2\2\2\24"+
		"\27\3\2\2\2\25\23\3\2\2\2\25\26\3\2\2\2\26\3\3\2\2\2\27\25\3\2\2\2\30"+
		"\33\5\6\4\2\31\33\5\20\t\2\32\30\3\2\2\2\32\31\3\2\2\2\33\5\3\2\2\2\34"+
		"\35\7\13\2\2\35$\5\b\5\2\36\37\7\n\2\2\37 \5\b\5\2 !\7\13\2\2!\"\5\n\6"+
		"\2\"$\3\2\2\2#\34\3\2\2\2#\36\3\2\2\2$\7\3\2\2\2%&\b\5\1\2&\'\5\16\b\2"+
		"\'-\3\2\2\2()\f\3\2\2)*\7\3\2\2*,\5\16\b\2+(\3\2\2\2,/\3\2\2\2-+\3\2\2"+
		"\2-.\3\2\2\2.\t\3\2\2\2/-\3\2\2\2\60\63\5\f\7\2\61\63\7\5\2\2\62\60\3"+
		"\2\2\2\62\61\3\2\2\2\63\13\3\2\2\2\64\65\b\7\1\2\65\66\5\16\b\2\66<\3"+
		"\2\2\2\678\f\3\2\289\7\4\2\29;\5\16\b\2:\67\3\2\2\2;>\3\2\2\2<:\3\2\2"+
		"\2<=\3\2\2\2=\r\3\2\2\2><\3\2\2\2?@\b\b\1\2@A\7\34\2\2AG\3\2\2\2BC\f\3"+
		"\2\2CD\7\6\2\2DF\7\34\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\17"+
		"\3\2\2\2IG\3\2\2\2JK\7\r\2\2KL\7\34\2\2LM\7\7\2\2M\21\3\2\2\2\t\25\32"+
		"#-\62<G";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}