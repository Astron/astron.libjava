package astron.dc.parser;

import astron.dc.File;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * @author chandler14362
 */
public class DCLoader extends DCBaseListener {

    private ParserData _parserData;
    private final File _file;

    public DCLoader(final File file) {
        _file = file;
    }

    // Imports

    public void enterImportDClass(@NotNull DCParser.ImportDClassContext ctx) {
        _parserData = new ImportData(ctx.importModule().getText());
    }

    public void enterImportSymbols(@NotNull DCParser.ImportSymbolsContext ctx) {
        String[] symbols = ctx.getText().split(",");

        for (int i=0; i < symbols.length; i++) {
            ((ImportData) _parserData).addSymbol(symbols[i]);
        }
    }

    // Keywords

    public void enterKeywordDef(@NotNull DCParser.KeywordDefContext ctx) {
        _parserData = new KeywordData(ctx.IDENTIFIER().toString());
    }

    // Typedefs

    public void enterTypedef(@NotNull DCParser.TypedefContext ctx) {}


    // Construct the _parserData once we exit the statement.
    public void exitStatement(@NotNull DCParser.StatementContext ctx) {
        if (_parserData != null) {
            _parserData.construct(_file);
            _parserData = null;
        }
    }

    public File getFile() {
        return _file;
    }

}