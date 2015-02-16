package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public final class Import {

    private final String _package;
    private final ArrayList<String> _symbols;

    public Import(final String pack, final ArrayList<String> symbols) {
        _package = pack;
        _symbols = symbols;
    }

    public String getPackage() {
        return _package;
    }

    public ArrayList<String> getSymbols() {
        return _symbols;
    }

    public String toString() {
        return String.format("---Import---\n Package: %s\n Symbols: %s", _package, _symbols);
    }

}
