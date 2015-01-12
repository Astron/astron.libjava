package astron.dc;

import org.antlr.v4.runtime.misc.NotNull;

/**
 * @author chandler14362
 */
public class DCLoader extends DCBaseListener {

    private final DCFile _dc = new DCFile();

    private String _currentImportPackage;

    // Imports

    public void enterImportDclass(@NotNull DCParser.ImportDclassContext ctx) {
        _currentImportPackage = ctx.importModule().getText();
    }

    public void enterImportSymbols(@NotNull DCParser.ImportSymbolsContext ctx) {
        String[] symbols = ctx.getText().split(",");

        for (String symbol: symbols) {
            DImport dimport = new DImport(_currentImportPackage);
            dimport.setSymbols(symbol);

            _dc.addImport(dimport);
        }
    }

    // Keywords

    public void enterKeywordDef(@NotNull DCParser.KeywordDefContext ctx) {
        _dc.addKeyword(ctx.IDENTIFIER().getText());
    }

    public DCFile getDcFile() {
        return _dc;
    }

}