package astron.dc;

import org.antlr.v4.runtime.misc.NotNull;

/**
 * @author chandler14362
 */
public class DCLoader extends DCBaseListener {

    private final DCFile _dc = new DCFile();

    private DImport _currentImport;

    public void enterImportDclass(@NotNull DCParser.ImportDclassContext ctx) {
        _currentImport = new DImport(ctx.importModule().getText());
    }

    public void exitImportDclass(@NotNull DCParser.ImportDclassContext ctx) {
        _dc.addImport(_currentImport);
    }

    public DCFile getDcFile() {
        return _dc;
    }

}