// Generated from /Users/stowellc17/astron.libjava/src/main/antlr4/astron/dc/DC.g4 by ANTLR 4.4.1-dev
package astron.dc;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DCParser}.
 */
public interface DCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DCParser#import_symbol_list}.
	 * @param ctx the parse tree
	 */
	void enterImport_symbol_list(@NotNull DCParser.Import_symbol_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#import_symbol_list}.
	 * @param ctx the parse tree
	 */
	void exitImport_symbol_list(@NotNull DCParser.Import_symbol_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCParser#import_alternatives}.
	 * @param ctx the parse tree
	 */
	void enterImport_alternatives(@NotNull DCParser.Import_alternativesContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#import_alternatives}.
	 * @param ctx the parse tree
	 */
	void exitImport_alternatives(@NotNull DCParser.Import_alternativesContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCParser#import_dclass}.
	 * @param ctx the parse tree
	 */
	void enterImport_dclass(@NotNull DCParser.Import_dclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#import_dclass}.
	 * @param ctx the parse tree
	 */
	void exitImport_dclass(@NotNull DCParser.Import_dclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCParser#import_module}.
	 * @param ctx the parse tree
	 */
	void enterImport_module(@NotNull DCParser.Import_moduleContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#import_module}.
	 * @param ctx the parse tree
	 */
	void exitImport_module(@NotNull DCParser.Import_moduleContext ctx);
	/**
	 * Enter a parse tree produced by {@link DCParser#import_symbols}.
	 * @param ctx the parse tree
	 */
	void enterImport_symbols(@NotNull DCParser.Import_symbolsContext ctx);
	/**
	 * Exit a parse tree produced by {@link DCParser#import_symbols}.
	 * @param ctx the parse tree
	 */
	void exitImport_symbols(@NotNull DCParser.Import_symbolsContext ctx);
}