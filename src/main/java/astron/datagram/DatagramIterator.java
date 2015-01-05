package astron.datagram;

import astron.dc.DDataTypes;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class DatagramIterator {

    private int offset = 0;
    private ByteBuffer buffer;

    public DatagramIterator(byte[] bytes) {
        this.buffer = ByteBuffer.allocate(bytes.length);
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        this.buffer.put(bytes);
    }

    public DatagramIterator(Datagram datagram) {
        this(datagram.getBytes());
    }

    public byte getByte() {
        byte value = this.buffer.get(this.offset);
        this.offset += 1;
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
        char value = (char) this.buffer.get(this.offset);
        this.offset += 1;
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
        byte value = this.buffer.get(this.offset);
        this.offset += 1;
        return value;
    }

    public short getInt16() {
        short value = this.buffer.getShort(this.offset);
        this.offset += 2;
        return value;
    }

    public int getInt32() {
        int value = this.buffer.getInt(this.offset);
        this.offset += 4;
        return value;
    }

    public long getInt64() {
        long value = (int) this.buffer.getLong(this.offset);
        this.offset += 8;
        return value;
    }

    public short getUint8() {
        short value = this.buffer.get(this.offset);
        this.offset += 1;
        return value;
    }

    public int getUint16() {
        int value = this.buffer.getShort(this.offset);
        this.offset += 2;
        return value;
    }

    public long getUint32() {
        long value = this.buffer.getInt(this.offset);
        this.offset += 4;
        return value;
    }

    public long getUint64() {
        long value = this.buffer.getLong(this.offset);
        this.offset += 8;
        return value;
    }

    public int getOffset() {
        return this.offset;
    }

    public static Object getDataType(DatagramIterator datagram, DDataTypes dataType) {
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
            default:
                return null;
        }
    }

}
