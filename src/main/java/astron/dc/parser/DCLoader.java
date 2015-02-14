package astron.dc.parser;

import astron.dc.parser.DCBaseListener;
import astron.dc.parser.DCParser;
import astron.dc.DCFile;
import astron.dc.DImport;
import org.antlr.v4.runtime.misc.NotNull;

/**
 * @author chandler14362
 */
public class DCLoader extends DCBaseListener {

    private ParserData _parserData;
    private final DCFile _dc = new DCFile();

    // Imports

    public void enterImportDClass(@NotNull DCParser.ImportDClassContext ctx) {
        _parserData = new ImportData();
    }

    public void enterImportModule(@NotNull DCParser.ImportModuleContext ctx) {
        ((ImportData) _parserData).addToPackage(ctx.importAlternatives().getText());
    }

    public void enterImportSymbols(@NotNull DCParser.ImportSymbolsContext ctx) {
        String[] symbols = ctx.getText().split(",");

        for (int i=0; i < symbols.length-1; i++) {
            String symbol = symbols[i];

            ImportData importData = ((ImportData) _parserData).copy();
            importData.setSymbols(symbol);
            _dc.addImport((DImport) importData.construct());
        }

        ((ImportData) _parserData).setSymbols(symbols[symbols.length-1]);
    }

    public void exitImportDClass(@NotNull DCParser.ImportDClassContext ctx) {
        _dc.addImport((DImport) _parserData.construct());
        _parserData = null;
    }

    // Keywords

    public void enterKeywordDef(@NotNull DCParser.KeywordDefContext ctx) {
        _parserData = new KeywordData(ctx.IDENTIFIER().toString());
    }

    public void exitKeywordDef(@NotNull DCParser.KeywordDefContext ctx) {
        _dc.addKeyword(_parserData.construct().getAlias());
        _parserData = null;
    }

    // Typedefs

    public void enterTypedef(@NotNull DCParser.TypedefContext ctx) {}

    public DCFile getDcFile() {
        return _dc;
    }

}