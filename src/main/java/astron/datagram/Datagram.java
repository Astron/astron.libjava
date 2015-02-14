package astron.datagram;

import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import astron.dc.FundamentalType;

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
        addUint16(messageType);
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
        return Arrays.toString(getBytes());
    }

    /* Data Types */

    public void addByte(final byte value) {
        _buffer.put(value);
    }

    public void addBool(final boolean value) {
        if (value) {
            addUint8(1);
        } else {
            addUint8(0);
        }
    }

    public void addChar(final char value) {
        _buffer.put((byte) value);
    }

    public void addString(final String value) {
        if (value.length() > UnsignedNumbers.UINT16_MAX) {
            throw new IllegalArgumentException("String is too long to be packed into a Datagram");
        }
        addUint16(value.length());
        for (char chr : value.toCharArray()) {
            addChar(chr);
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
     * @param value integral between 0 and {@link astron.datagram.UnsignedNumbers#UINT8_MAX} to pack into the Datagram as a uint8.
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint8
     * @see astron.datagram.UnsignedNumbers
     */
    public void addUint8(final long value) {
        addUint8(UnsignedNumbers.checkedUint8Cast(value));
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
     * @param value integral between 0 and {@link astron.datagram.UnsignedNumbers#UINT16_MAX} to pack into the Datagram as a uint16.
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint16
     * @see astron.datagram.UnsignedNumbers
     */
    public void addUint16(final long value) {
        addUint16(UnsignedNumbers.checkedUint16Cast(value));
    }

    /**
     * Add a uint32 to the datagram.
     *
     * This method directly accepts an int.
     * @param value int to append
     */
    public void addUint32(final int value) {
        _buffer.putInt(value);
    }

    /**
     * Add a uint32 to the datagram.
     *
     * This is a convenience method in the same manner as the {@link #addUint8(long)} method.
     * @param value integral between 0 and {@link astron.datagram.UnsignedNumbers#UINT32_MAX} to pack into the Datagram as a uint32.
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint16
     * @see astron.datagram.UnsignedNumbers
     */
    public void addUint32(final long value) {
        addUint32((int) value);
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

    /**
     * Add a wrapped uint64 to the datagram.
     * @param value Wrapped uint64 to append to the datagram
     * @see astron.datagram.Uint64
     */
    public void addUint64(final Uint64 value) {
        _buffer.putLong(value.getValue());
    }

    /**
     * Add a 32-bit (single precision) floating point number to the datagram.
     *
     * @param value float to append
     */
    public void addFloat32(final float value) {
        _buffer.putFloat(value);
    }

    /**
     * Add a 64-bit (double precision) floating point number to the datagram.
     *
     * @param value double to append
     */
    public void addFloat64(final double value) {
        _buffer.putDouble(value);
    }

    /* Writing to a DataOutputStream */

    public void writeTo(final DataOutputStream output) {
        try {
            ByteBuffer data = ByteBuffer.allocate(getLength() + 2);
            data.order(ByteOrder.LITTLE_ENDIAN);
            data.putChar((char) getLength());
            data.put(getBytes());
            output.write(data.array());
        } catch (Exception e) { System.out.println(e.toString()); }
    }

    public static void addDataType(final Datagram datagram, final FundamentalType dataType, final Object value) {
        switch (dataType) {
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
