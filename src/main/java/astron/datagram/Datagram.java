package astron.datagram;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import astron.dc.DDataTypes;

public class Datagram {

    private ByteBuffer _buffer;

    /* Constructors */

    public Datagram() {
        _buffer = ByteBuffer.allocate(65535);
        _buffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    public Datagram(final byte[] bytes) {
        _buffer = ByteBuffer.allocate(bytes.length);
        _buffer.order(ByteOrder.LITTLE_ENDIAN);
        _buffer.put(bytes);
    }

    public Datagram(final Datagram datagram) {
        this(datagram.getBytes());
    }

    public Datagram(final int messageType) {
        this();
        this.addUint16(messageType);
    }

    /* Utility Functions */

    public int getLength() {
        return _buffer.position();
    }

    public byte[] getBytes() {
        return Arrays.copyOf(_buffer.array(), _buffer.position());
    }

    public byte[] toArray() {
        return _buffer.array();
    }

    public String toString() {
        return Arrays.toString(this.getBytes());
    }

    /* Data Types */

    public void addByte(final byte value) {
        _buffer.put(value);
    }

    public void addBool(final boolean value) {
        if (value) {
            this.addUint8(1);
        } else {
            this.addUint8(0);
        }
    }

    public void addChar(final char value) {
        _buffer.put((byte) value);
    }

    public void addString(final String value) {
        try {
            this.addUint16(value.length());
            for (char chr: value.toCharArray()) {
                this.addChar(chr);
            }
        } catch (Exception e) { System.out.println(e.toString()); }
    }

    public void addInt8(final int value) {
        _buffer.put((byte) value);
    }

    public void addInt16(final int value) {
        _buffer.putChar((char) value);
    }

    public void addInt32(final int value) {
        _buffer.putInt(value);
    }

    public void addInt64(final int value) {
        _buffer.putLong(value);
    }

    public void addUint8(final int value) {
        _buffer.put((byte) value);
    }

    public void addUint16(final int value) {
        _buffer.putChar((char) value);
    }

    public void addUint32(final int value) {
        _buffer.putInt(value);
    }

    public void addUint64(final int value) {
        _buffer.putLong(value);
    }

    /* Writing to a DataOutputStream */

    public void writeTo(final DataOutputStream output) {
        try {
            ByteBuffer data = ByteBuffer.allocate(this.getLength() + 2);
            data.order(ByteOrder.LITTLE_ENDIAN);
            data.putChar((char) this.getLength());
            data.put(this.getBytes());
            output.write(data.array());
        } catch (Exception e) { System.out.println(e.toString()); }
    }

    public static void addDataType(final Datagram datagram, final DDataTypes dataType, final Object value) {
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
