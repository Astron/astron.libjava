package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public class File {

    private final ArrayList<Import> _imports = new ArrayList<Import>();
    private final ArrayList<Class> _classes = new ArrayList<Class>();
    private final ArrayList<Struct> _structs = new ArrayList<Struct>();
    private final KeywordList _keywordList = new KeywordList();

    public File() {}

    public void addImport(final Import dimport) {
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

    public int getHash() {
        HashGenerator hashgen = new HashGenerator();
        generateHash(hashgen);
        return hashgen.getHash();
    }

    private void generateHash(final HashGenerator hashgen) {
        hashgen.addInt(_classes.size());
        for (Class dclass: _classes) {
            dclass.generateHash(hashgen);
        }

        hashgen.addInt(_structs.size());
        for (Struct struct: _structs) {
            struct.generateHash(hashgen);
        }

        _keywordList.generateHash(hashgen);
    }

    public void printInfo() {
        for (Import dimport: _imports) {
            System.out.println(dimport.toString());
        }
        System.out.println(_keywordList.toString());
    }

}
