package astron.datagram;

import com.google.common.primitives.UnsignedBytes;

/**
 * @author jjkoletar
 */
public final class UnsignedNumbers {
    private UnsignedNumbers() {}

    public static final long UINT8_MAX  = 255l;
    public static final long UINT16_MAX = 65535l;
    public static final long UINT32_MAX = 4294967295l;

    /**
     * Perform a checked cast of a signed integral down to a uint8
     * @param value Integral type with a signed value between 0 and {@link #UINT8_MAX}
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint8
     * @return signed byte containing the value of {@code value}
     */
    public static byte checkedUint8Cast(final long value) {
        return UnsignedBytes.checkedCast(value);
    }

    /**
     * Perform a checked cast of a signed integral down to a uint16
     * @param value Integral type with a signed value between 0 and {@link #UINT16_MAX}
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint16
     * @return signed short containing the value of {@code value}
     */
    public static short checkedUint16Cast(final long value) {
        if (value < 0 || value > UINT16_MAX) {
            throw new IllegalArgumentException("Out of range: " + value);
        }
        return (short) value;
    }

    /**
     * Perform a checked cast of a signed integral down to a uint32
     * @param value Integral type with a signed value between 0 and {@link #UINT32_MAX}
     * @throws IllegalArgumentException if the provided value exceeds the maximum capacity of a uint32
     * @return signed int containing the value of {@code value}
     */
    public static int checkedUint32Cast(final long value) {
        if (value < 0 || value > UINT32_MAX) {
            throw new IllegalArgumentException("Out of range: " + value);
        }
        return (int) value;
    }
}
