package main.java.astron.dc;

import java.util.Map;

public class DCFile {

    private int hash;

    public Map<String, String> imports;

    public Map<String , DMethod> name2dmethod;
    public Map<Integer, DMethod> id2dmethod;

    public Map<String , DClass> name2dclass;
    public Map<Integer, DClass> id2dclass;

    public DCFile() {}

    public void setHash(int hash) {
        this.hash = hash;
    }

    public int getHash() {
        return this.hash;
    }

    public String lookupImport(DClass dclass) {
        return this.imports.get(dclass.getName());
    }

    public DClass getDClass(String name) {
        return this.name2dclass.get(name);
    }

    public void setImports(Map<String, String> imports) {
        this.imports = imports;
    }

    public void setName2DMethod(Map<String, DMethod> name2dmethod) {
        this.name2dmethod = name2dmethod;
    }

    public void setId2DMethod(Map<Integer, DMethod> id2dmethod) {
        this.id2dmethod = id2dmethod;
    }

    public void setName2DClass(Map<String, DClass> name2dclass) {
        this.name2dclass = name2dclass;
    }

    public void setId2DClass(Map<Integer, DClass> id2dclass) {
        this.id2dclass = id2dclass;
    }

}
