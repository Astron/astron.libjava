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
        if (value.length() > 65535) {
            throw new IllegalArgumentException("String is too long to be packed into a Datagram");
        }
        this.addUint16(value.length());
        for (char chr : value.toCharArray()) {
            this.addChar(chr);
        }
    }

    public void addInt8(final byte value) {
        _buffer.put(value);
    }

    public void addInt16(final short value) {
        _buffer.putShort(value);
    }

    public void addInt32(final int value) {
        _buffer.putInt(value);
    }

    public void addInt64(final long value) {
        _buffer.putLong(value);
    }

    /**
     * Add a uint8 to the datagram.
     *
     * This method accepts a single byte directly.
     * @param value byte to append
     */
    public void addUint8(final byte value) {
        _buffer.put(value);
    }

    /**
     * Add a uint8 to the datagram.
     *
     * This method accepts a long such that a programmer may perform a call like "dg.addUint8(100)" without hassle.
     * Since integral literals are of the type int when "L" is not suffixed, Java will promote the integer provided
     * to a long when this method is called.
     * @param value integral between 0 and 255 to pack into the Datagram as a uint8.
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint8
     */
    public void addUint8(final long value) {
        if (value < 0 || value > 255) {
            throw new IllegalArgumentException("Provided value " + value + " is too large for a uint8");
        }
        addUint8((byte) value);
    }

    /**
     * Add a uint16 to the datagram.
     *
     * This method directly accepts a short.
     * @param value short to append
     */
    public void addUint16(final short value) {
        _buffer.putShort(value);
    }

    /**
     * Add a uint16 to the datagram.
     *
     * This is a convenience method in the same manner as the {@link #addUint8(long)} method.
     * @param value integral between 0 and 65535 to pack into the Datagram as a uint16.
     */
    public void addUint16(final long value) {
        if (value < 0 || value > 65535) {
            throw new IllegalArgumentException("Provided value " + value + " is too large for a uint16");
        }
        addUint16((short) value);
    }

    public void addUint32(final int value) {
        _buffer.putInt(value);
    }

    /**
     * Add a uint32 to the datagram.
     *
     * This is a convienence method in the same manner as the {@link #addUint8(long)} method.
     * @param value integral between 0 and 4294967295
     */
    public void addUint32(final long value) {
        if (value < 0 || value > 4294967295L) {
            throw new IllegalArgumentException("Provided value " + value + " is too large for a uint32");
        }
        addUint16((int) value);
    }

    /**
     * Add a uint64 to the datagram.
     *
     * Because Java's longest primitive type is the signed long, valid uint64s may be represented by Java as negative numbers.
     * @param value long to append
     */
    public void addUint64(final long value) {
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
                datagram.addInt8((Byte) value);
            case INT16:
                datagram.addInt16((Short) value);
            case INT32:
                datagram.addInt32((Integer) value);
            case INT64:
                datagram.addInt64((Long) value);
            // For uint8-uint32, use the convenience methods that take a long
            case UINT8:
                datagram.addUint8((Long) value);
            case UINT16:
                datagram.addUint16((Long) value);
            case UINT32:
                datagram.addUint32((Long) value);
            case UINT64:
                datagram.addUint64((Long) value);
            default:
                break;
        }
    }
}
