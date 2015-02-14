package astron.dc;

/**
 * @author chandler14362
 */
public final class DImport extends DType {

    private final String _package;
    private final String _symbols;

    public DImport(final String pack, final String symbols) {
        _package = pack;
        _symbols = symbols;
    }

    public FundamentalType getFundamentalType() {
        return null;
    }

    public String getPackage() {
        return _package;
    }

    public String getSymbols() {
        return _symbols;
    }

    public String toString() {
        return String.format("---DImport---\n Package: %s\n Symbols: %s", _package, _symbols);
    }

}
