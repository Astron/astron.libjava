package astron.datagram;

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
        int value = getUint8();

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

        int length = getUint16();

        for (int i=0; i<length; i++) {
            sb.append(getChar());
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

}
