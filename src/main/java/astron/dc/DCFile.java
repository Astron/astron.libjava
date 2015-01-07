package astron.dc;

import java.util.Map;

public final class DCFile {

    private int _hash;

    private Map<String, String> _imports;

    private Map<String , DMethod> _name2dmethod;
    private Map<Integer, DMethod> _id2dmethod;

    private Map<String , DClass> _name2dclass;
    private Map<Integer, DClass> _id2dclass;

    public DCFile() {}

    public void setHash(final int hash) {
        _hash = hash;
    }

    public int getHash() {
        return _hash;
    }

    public String lookupImport(final DClass dclass) {
        return _imports.get(dclass.getName());
    }

    public DClass getDClass(final String name) {
        return _name2dclass.get(name);
    }

    public DMethod getDMethod(final int id) {
        return _id2dmethod.get(id);
    }

    public void setImports(final Map<String, String> imports) {
        _imports = imports;
    }

    public void setName2DMethod(final Map<String, DMethod> name2dmethod) {
        _name2dmethod = name2dmethod;
    }

    public void setId2DMethod(final Map<Integer, DMethod> id2dmethod) {
        _id2dmethod = id2dmethod;
    }

    public void setName2DClass(final Map<String, DClass> name2dclass) {
        _name2dclass = name2dclass;
    }

    public void setId2DClass(final Map<Integer, DClass> id2dclass) {
        _id2dclass = id2dclass;
    }

}
