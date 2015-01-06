package astron.datagram;

import astron.dc.DDataTypes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DatagramIterator {

    private int _offset = 0;
    private ByteBuffer _buffer;

    public DatagramIterator(final byte[] bytes) {
        _buffer = ByteBuffer.allocate(bytes.length);
        _buffer.order(ByteOrder.LITTLE_ENDIAN);
        _buffer.put(bytes);
    }

    public DatagramIterator(final Datagram datagram) {
        this(datagram.getBytes());
    }

    public byte getByte() {
        byte value = _buffer.get(_offset);
        _offset += 1;
        return value;
    }

    public boolean getBool() {
        int value = this.getUint8();

        if (value == 0) {
            return false;
        } else {
            return true;
        }
    }

    public char getChar() {
        char value = (char) _buffer.get(_offset);
        _offset += 1;
        return value;
    }

    public String getString() {
        StringBuilder sb = new StringBuilder();

        int length = this.getUint16();

        for (int i=0; i<length; i++) {
            sb.append(this.getChar());
        }

        return sb.toString();
    }

    public byte getInt8() {
        byte value = _buffer.get(_offset);
        _offset += 1;
        return value;
    }

    public short getInt16() {
        short value = _buffer.getShort(_offset);
        _offset += 2;
        return value;
    }

    public int getInt32() {
        int value = _buffer.getInt(_offset);
        _offset += 4;
        return value;
    }

    public long getInt64() {
        long value = (int) _buffer.getLong(_offset);
        _offset += 8;
        return value;
    }

    public short getUint8() {
        short value = _buffer.get(_offset);
        _offset += 1;
        return value;
    }

    public int getUint16() {
        int value = _buffer.getShort(_offset);
        _offset += 2;
        return value;
    }

    public long getUint32() {
        long value = _buffer.getInt(_offset);
        _offset += 4;
        return value;
    }

    public int getDoId() {
        int value = _buffer.getInt(_offset);
        _offset += 4;
        return value;
    }

    public long getUint64() {
        long value = _buffer.getLong(_offset);
        _offset += 8;
        return value;
    }

    public float getFloat32() {
        float value = _buffer.getFloat(_offset);
        _offset += 4;
        return value;
    }

    public double getFloat64() {
        double value = _buffer.getDouble(_offset);
        _offset += 8;
        return value;
    }

    public int getOffset() {
        return _offset;
    }

    public static Object getDataType(final DatagramIterator datagram, final DDataTypes dataType) {
        switch (dataType) {
            case BOOL:
                return datagram.getBool();
            case STRING:
                return datagram.getString();
            case INT8:
                return datagram.getInt8();
            case INT16:
                return datagram.getInt16();
            case INT32:
                return datagram.getInt32();
            case INT64:
                return datagram.getInt64();
            case UINT8:
                return datagram.getUint8();
            case UINT16:
                return datagram.getUint16();
            case UINT32:
                return datagram.getUint32();
            case UINT64:
                return datagram.getUint64();
            case FLOAT32:
                return datagram.getFloat32();
            case FLOAT64:
                return datagram.getFloat64();
            default:
                return null;
        }
    }

}
