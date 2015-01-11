package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public class DCFile {

    private final ArrayList<DImport> _imports = new ArrayList<DImport>();

    public void addImport(final DImport dimport) {
        _imports.add(dimport);
    }

    public int getImportCount() {
        return _imports.size();
    }

    public DClass getDClass(final String name) {
        return new DClass("122121", 2);
    }

    public String lookupImport(final DClass dclass) {
        return "";
    }

    public int getHash() {
        return 2;
    }

    public DMethod getDMethod(final int id) {
        return new DMethod("adasds", 2);
    }

    public void printInfo() {
        for (DImport dimport: _imports) {
            System.out.println(dimport.toString());
        }
    }

}
