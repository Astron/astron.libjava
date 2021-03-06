package astron.dc;

import java.util.HashMap;
import java.util.Map;

public class DCTokens {

    public static final String COMMENT = "//";
    public static final String FROM = "from";
    public static final String IMPORT = "import";
    public static final String STRUCT = "struct";
    public static final String CLASS = "dclass";
    public static final String TYPEDEF = "typedef";
    public static final String STATEMENT_END = ";";
    public static final String METHOD_START = "\\(";
    public static final String METHOD_END = ")";
    public static final String INCLOSURE_START = "{";
    public static final String INCLOSURE_END = "};";
    public static final String INHERITANCE = ":";
    public static final String SEPARATOR = ",";
    public static final String TYPE_SEPARATOR = "/";
    public static final String EQUALS = "=";

    public static final Map<String, DDataTypes> DATA_TYPES = new HashMap<String, DDataTypes>();
    public static final Map<DDataTypes, Class<?>> DATA_CLASSES = new HashMap<DDataTypes, Class<?>>();

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
        DATA_TYPES.put("float32", DDataTypes.FLOAT32);
        DATA_TYPES.put("float64", DDataTypes.FLOAT64);

        DATA_CLASSES.put(DDataTypes.STRING, String.class);
        DATA_CLASSES.put(DDataTypes.BOOL, Boolean.class);
        DATA_CLASSES.put(DDataTypes.INT8, Byte.class);
        DATA_CLASSES.put(DDataTypes.INT16, Short.class);
        DATA_CLASSES.put(DDataTypes.INT32, Integer.class);
        DATA_CLASSES.put(DDataTypes.INT64, Long.class);
        DATA_CLASSES.put(DDataTypes.UINT8, Short.class);
        DATA_CLASSES.put(DDataTypes.UINT16, Integer.class);
        DATA_CLASSES.put(DDataTypes.UINT32, Long.class);
        DATA_CLASSES.put(DDataTypes.UINT64, Long.class);
        DATA_CLASSES.put(DDataTypes.FLOAT32, Float.class);
        DATA_CLASSES.put(DDataTypes.FLOAT64, Double.class);

    }

}
