package astron.dc;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * @author chandler14362
 */
public class DCFile {

    private final ArrayList<DImport> _imports = new ArrayList<DImport>();
    private final KeywordList _keywordList = new KeywordList();
    private final Map<String, DTypeDef> _typedefMap = new HashMap<String, DTypeDef>();

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

    public void addTypedef(final DTypeDef typedef) {
        _typedefMap.put(typedef.getAlias(), typedef);
    }

    public int getTypedefCount() {
        return _typedefMap.size();
    }

    public DType getTypeByName(String name) {
        return DType.INVALID_TYPE;
    }

    public int getHash() {
        return 2; // TODO
    }

    public void printInfo() {
        for (DImport dimport: _imports) {
            System.out.println(dimport.toString());
        }
        System.out.println(_keywordList.toString());
        for (DTypeDef typedef: _typedefMap.values()) {
            System.out.println(typedef.toString());
        }
    }

}
