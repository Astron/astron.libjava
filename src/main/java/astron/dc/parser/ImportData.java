package astron.dc.parser;

import astron.dc.DType;
import astron.dc.DImport;

/**
 * @author chandler14362
 */
public final class ImportData extends ParserData {

    private String _package;
    private String _symbols;

    public void setPackage(final String pack) {
        _package = pack;
    }

    public void addToPackage(final String pack) {
        if (_package != null) {
            _package = pack + "." + _package;
        } else {
            _package = pack;
        }
    }

    public void setSymbols(final String symbols) {
        _symbols = symbols;
    }

    public DType construct() {
        if (_symbols == null) {
            String[] packages = _package.split("\\.");
            String newPackage = null;

            for (int i=0; i < packages.length-1; i++) {
                if (newPackage != null) {
                    newPackage = newPackage + "." + packages[i];
                } else {
                    newPackage = packages[i];
                }
            }

            String newSymbols = packages[packages.length-1];

            return new DImport(newPackage, newSymbols);
        }

        return new DImport(_package, _symbols);
    }

    public ImportData copy() {
        ImportData importData = new ImportData();
        importData.setPackage(_package);
        importData.setSymbols(_symbols);
        return importData;
    }

}
