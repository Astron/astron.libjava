package astron.dc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chandler14362
 */
public class Struct extends DistributedType {

    private File _file;
    private int _id;
    private String _name;

    private final ArrayList<Field> _fields = new ArrayList<Field>();
    private final Map<String, Field> _fieldsByName = new HashMap<String, Field>();
    private final Map<Integer, Field> _fieldsById = new HashMap<Integer, Field>();

    public Struct(File file, String name) {}

    public FundamentalType getFundamentalType() {
        return FundamentalType.STRUCT;
    }

    public File getFile() {
        return _file;
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }

    protected void setId(final int id) {
        _id = id;
    }

    protected void generateHash(HashGenerator hashgen) {}
}
