// Generated from astron/dc/DC.g4 by ANTLR 4.3
package astron.dc;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DCParser}.
 */
public interface DCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DCParser#importAlternatives}.
	 * @param ctx the parse tree
	 */
	void enterImportAlternatives(@NotNull DCParser.ImportAlternativesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#importAlternatives}.
	 * @param ctx the parse tree
	 */
	void exitImportAlternatives(@NotNull DCParser.ImportAlternativesContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull DCParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull DCParser.StatementContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#importSymbolList}.
	 * @param ctx the parse tree
	 */
	void enterImportSymbolList(@NotNull DCParser.ImportSymbolListContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#importSymbolList}.
	 * @param ctx the parse tree
	 */
	void exitImportSymbolList(@NotNull DCParser.ImportSymbolListContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#init}.
	 * @param ctx the parse tree
	 */
	void enterInit(@NotNull DCParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#init}.
	 * @param ctx the parse tree
	 */
	void exitInit(@NotNull DCParser.InitContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#keywordDef}.
	 * @param ctx the parse tree
	 */
	void enterKeywordDef(@NotNull DCParser.KeywordDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#keywordDef}.
	 * @param ctx the parse tree
	 */
	void exitKeywordDef(@NotNull DCParser.KeywordDefContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#importModule}.
	 * @param ctx the parse tree
	 */
	void enterImportModule(@NotNull DCParser.ImportModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#importModule}.
	 * @param ctx the parse tree
	 */
	void exitImportModule(@NotNull DCParser.ImportModuleContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#importDclass}.
	 * @param ctx the parse tree
	 */
	void enterImportDclass(@NotNull DCParser.ImportDclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#importDclass}.
	 * @param ctx the parse tree
	 */
	void exitImportDclass(@NotNull DCParser.ImportDclassContext ctx);

	/**
	 * Enter a parse tree produced by {@link DCParser#importSymbols}.
	 * @param ctx the parse tree
	 */
	void enterImportSymbols(@NotNull DCParser.ImportSymbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#importSymbols}.
	 * @param ctx the parse tree
	 */
	void exitImportSymbols(@NotNull DCParser.ImportSymbolsContext ctx);
}