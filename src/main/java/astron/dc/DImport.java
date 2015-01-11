package astron.dc;

import java.util.ArrayList;

/**
 * @author chandler14362
 */
public class DImport {

    private final ArrayList<String> _alternatives = new ArrayList<String>();
    private String _package;
    private String _module;

    public DImport(String pack) {
        _package = pack;
    }

    public DImport(String pack, String module) {
        _package = pack;
        _module = module;
    }

    public DImport() {}

    public void setPackage(String pack) {
        _package = pack;
    }

    public String getPackage() {
        return _package;
    }

    public void setModule(String module) {
        _module = module;
    }

    public String getModule() {
        return _module;
    }

    public boolean isModule(String module) {
        return _module == module;
    }

    public void addAlternative(String alternative) {
        _alternatives.add(alternative);
    }

    public String getImport() {
        if (_module != null) {
            return String.format("%s.%s", _package, _module);
        } else {
            return _package;
        }
    }

    public String toString() {
        return String.format("---DImport---\n Import: %s",getImport());
    }

}
