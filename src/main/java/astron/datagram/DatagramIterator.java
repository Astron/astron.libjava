package main.java.astron.datagram;

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

    public int getInt8() {
        int value = this.buffer.get(this.offset);
        this.offset += 1;
        return value;
    }

    public int getInt16() {
        int value = this.buffer.getChar(this.offset);
        this.offset += 2;
        return value;
    }

    public int getInt32() {
        int value = this.buffer.getInt(this.offset);
        this.offset += 4;
        return value;
    }

    public int getInt64() {
        int value = (int) this.buffer.getLong(this.offset);
        this.offset += 8;
        return value;
    }

    public int getUint8() {
        int value = this.buffer.get(this.offset);
        this.offset += 1;
        return value;
    }

    public int getUint16() {
        int value = this.buffer.getChar(this.offset);
        this.offset += 2;
        return value;
    }

    public int getUint32() {
        int value = this.buffer.getInt(this.offset);
        this.offset += 4;
        return value;
    }

    public int getUint64() {
        int value = (int) this.buffer.getLong(this.offset);
        this.offset += 8;
        return value;
    }

    public int getOffset() {
        return this.offset;
    }

}
