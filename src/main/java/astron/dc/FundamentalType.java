package astron.dc;

/**
 * Fundamental types of a DType.
 *
 * @author jjkoletar
 */
public enum FundamentalType {
    INT8,
    INT16,
    INT32,
    INT64,
    UINT8,
    UINT16,
    UINT32,
    UINT64,
    CHAR,
    FLOAT32,
    FLOAT64,

    STRING,
    VARSTRING,
    BLOB,
    VARBLOB,
    ARRAY,
    VARARRAY,

    STRUCT,
    METHOD,

    INVALID,
}