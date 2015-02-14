package astron.dc.parser;

import astron.dc.DType;

/**
 * @author chandler14362
 */
public final class ArrayData extends ParserData {

    private ArrayType _type;
    private int _start;
    private int _end;

    public static enum ArrayType {
        NORMAL,
        FIXED,
        RANGE
    }

    public void setStart(final int start) {
        _start = start;
    }

    public void setEnd(final int end) {
        _end = end;
    }

    public void setType(final ArrayType type) {
        _type = type;
    }

    public DType construct() {
        return DType.INVALID_TYPE;
    }

}
