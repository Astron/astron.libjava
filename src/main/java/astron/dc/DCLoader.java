package astron.dc;

import org.antlr.v4.runtime.misc.NotNull;

/**
 * @author chandler14362
 */
public class DCLoader extends DCBaseListener {

    private final DCFile _dc = new DCFile();

    // Imports

    public void enterImportDClassNoFrom(@NotNull DCParser.ImportDClassNoFromContext ctx) {
        String[] parts = ctx.importModule().getText().split("\\.");
        String symbols = parts[parts.length-1];
        String importPackage = "";

        for (int i=0; i<parts.length-1; i++) {
            importPackage += "." + parts[i];
        }

        importPackage = importPackage.substring(1);

        DImport dimport = new DImport(importPackage, symbols);
        _dc.addImport(dimport);
    }

    public void enterImportDClass(@NotNull DCParser.ImportDClassContext ctx) {
        String importPackage = ctx.importModule().getText();
        String[] symbols = ctx.importSymbols().getText().split(",");

        for (String symbol: symbols) {
            DImport dimport = new DImport(importPackage, symbol);
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