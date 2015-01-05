package astron.datagram;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import astron.dc.DDataTypes;

public class Datagram {

    private ByteBuffer buffer;

    /* Constructors */

    public Datagram() {
        this.buffer = ByteBuffer.allocate(65535);
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Datagram(byte[] bytes) {
        this.buffer = ByteBuffer.allocate(bytes.length);
        this.buffer.order(ByteOrder.LITTLE_ENDIAN);
        this.buffer.put(bytes);
    }

    public Datagram(Datagram datagram) {
        this(datagram.getBytes());
    }

    public Datagram(int messageType) {
        this();
        this.addUint16(messageType);
    }

    /* Utility Functions */

    public int getLength() {
        return this.buffer.position();
    }

    public byte[] getBytes() {
        return Arrays.copyOf(this.buffer.array(), this.buffer.position());
    }

    public byte[] toArray() {
        return this.buffer.array();
    }

    public String toString() {
        return Arrays.toString(this.getBytes());
    }

    /* Data Types */

    public void addByte(byte value) {
        this.buffer.put(value);
    }

    public void addBool(boolean value) {
        if (value) {
            this.addUint8(1);
        } else {
            this.addUint8(0);
        }
    }

    public void addChar(char value) {
        this.buffer.put((byte) value);
    }

    public void addString(String value) {
        try {
            this.addUint16(value.length());
            for (char chr: value.toCharArray()) {
                this.addChar(chr);
            }
        } catch (Exception e) { System.out.println(e.toString()); }
    }

    public void addInt8(int value) {
        this.buffer.put((byte) value);
    }

    public void addInt16(int value) {
        this.buffer.putChar((char) value);
    }

    public void addInt32(int value) {
        this.buffer.putInt(value);
    }

    public void addInt64(int value) {
        this.buffer.putLong(value);
    }

    public void addUint8(int value) {
        this.buffer.put((byte) value);
    }

    public void addUint16(int value) {
        this.buffer.putChar((char) value);
    }

    public void addUint32(int value) {
        this.buffer.putInt(value);
    }

    public void addUint64(int value) {
        this.buffer.putLong(value);
    }

    /* Writing to a DataOutputStream */

    public void writeTo(DataOutputStream output) {
        try {
            ByteBuffer data = ByteBuffer.allocate(this.getLength() + 2);
            data.order(ByteOrder.LITTLE_ENDIAN);
            data.putChar((char) this.getLength());
            data.put(this.getBytes());
            output.write(data.array());
        } catch (Exception e) { System.out.println(e.toString()); }
    }

    public static void addDataType(Datagram datagram, DDataTypes dataType, Object value) {
        switch (dataType) {
            case BOOL:
                datagram.addBool((Boolean) value);
            case STRING:
                datagram.addString((String) value);
            case INT8:
                datagram.addInt8((Integer) value);
            case INT16:
                datagram.addInt16((Integer) value);
            case INT32:
                datagram.addInt32((Integer) value);
            case INT64:
                datagram.addInt64((Integer) value);
            case UINT8:
                datagram.addUint8((Integer) value);
            case UINT16:
                datagram.addUint16((Integer) value);
            case UINT32:
                datagram.addUint32((Integer) value);
            case UINT64:
                datagram.addUint64((Integer) value);
            default:
                break;
        }
    }
}
