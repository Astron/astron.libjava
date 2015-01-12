package astron.dc;

/**
 * @author chandler14362
 */
public class DImport {

    private String _package;
    private String _symbols;

    public DImport(final String pack) {
        _package = pack;
    }

    public DImport(final String pack, final String symbols) {
        _package = pack;
        _symbols = symbols;
    }

    public DImport() {}

    public void setPackage(final String pack) {
        _package = pack;
    }

    public String getPackage() {
        return _package;
    }

    public void setSymbols(final String symbols) {
        _symbols = symbols;
    }

    public String getSymbols() {
        return _symbols;
    }

    public String toString() {
        return String.format("---DImport---\n Package: %s\n Symbols: %s", _package, _symbols);
    }

}
