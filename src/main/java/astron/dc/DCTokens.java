package astron.dc;

import java.util.HashMap;
import java.util.Map;

public class DCTokens {

    public static final String COMMENT = "//";
    public static final String IMPORT_START = "from";
    public static final String STRUCT_START = "struct";
    public static final String CLASS_START = "dclass";
    public static final String INCLOSURE_END = "};";
    public static final String INHERITANCE = ":";
    public static final String SEPERATOR = ",";
    public static final String TYPEDEF = "typedef";

    public static final Map<String, DDataTypes> DATA_TYPES = new HashMap<String, DDataTypes>();

    static {

        DATA_TYPES.put("blob", DDataTypes.BLOB);
        DATA_TYPES.put("string", DDataTypes.STRING);
        DATA_TYPES.put("bool", DDataTypes.BOOL);
        DATA_TYPES.put("int8", DDataTypes.INT8);
        DATA_TYPES.put("int16", DDataTypes.INT16);
        DATA_TYPES.put("int32", DDataTypes.INT32);
        DATA_TYPES.put("int64", DDataTypes.INT64);
        DATA_TYPES.put("uint8", DDataTypes.UINT8);
        DATA_TYPES.put("uint16", DDataTypes.UINT16);
        DATA_TYPES.put("uint32", DDataTypes.UINT32);
        DATA_TYPES.put("uint64", DDataTypes.UINT64);

    }

}
