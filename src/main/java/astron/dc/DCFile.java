package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public class DCFile {

    private final ArrayList<DImport> _imports = new ArrayList<DImport>();
    private final KeywordList _keywordList = new KeywordList();

    public DCFile() {}

    public void addImport(final DImport dimport) {
        _imports.add(dimport);
    }

    public int getImportCount() {
        return _imports.size();
    }

    public void addKeyword(final String keyword) {
        _keywordList.addKeyword(keyword);
    }

    public int getKeywordCount() {
        return _keywordList.getKeywordCount();
    }

    public void printInfo() {
        for (DImport dimport: _imports) {
            System.out.println(dimport.toString());
        }
        System.out.println(_keywordList.toString());
    }

    // These are just some old methods that we need for the code to compile. This will be fixed soon...

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

}
