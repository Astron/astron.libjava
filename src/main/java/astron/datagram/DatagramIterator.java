package main.java.astron.datagram;

public class DatagramIterator extends Datagram {

    private int offset = 0;

    public DatagramIterator(byte[] bytes) {
        super(bytes);
    }

    public DatagramIterator(Datagram datagram) {
        super(datagram);
    }

    public byte getByte() {
        return 1;
    }

    public boolean getBool() {
        return true;
    }

    public char getChar() {
        return '1';
    }

    public String getString() {
        return "";
    }

    public int getInt8() {
        return 1;
    }

    public int getInt16() {
        return 1;
    }

    public int getInt32() {
        return 1;
    }

    public int getInt64() {
        return 1;
    }

    public int getUint8() {
        return 1;
    }

    public int getUint16() {
        int value = (int) this.buffer.getChar(this.offset);
        this.offset += 2;
        return value;
    }

    public int getUint32() {
        return 1;
    }

    public int getUint64() {
        return 1;
    }

    public int getOffset() {
        return this.offset;
    }

}
