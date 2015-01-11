package astron.dc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chandler14362
 */
public class DCTokens {

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
