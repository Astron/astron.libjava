package astron.dc.parser;

import astron.dc.Import;
import astron.dc.File;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public final class ImportData extends ParserData {

    private final String _package;
    private final ArrayList<String> _symbols = new ArrayList<String>();

    public ImportData(final String pack) {
        _package = pack;
    }

    public void addSymbol(final String symbol) {
        _symbols.add(symbol);
    }

    public void construct(File file) {
        file.addImport(new Import(_package, _symbols));
    }

}
