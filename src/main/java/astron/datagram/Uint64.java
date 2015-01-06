package astron.datagram;

import com.google.common.primitives.UnsignedLongs;

import java.math.BigInteger;

/**
 * Wrapper class that essentially represents a uint64.
 *
 * BigInteger logic taken from https://github.com/google/guava/blob/0f5ac11/guava/src/com/google/common/primitives/UnsignedLong.java
 *
 * @author jjkoletar
 */
public class Uint64 {
    private static final long HIGH32_MASK = 0xffffffff00000000l;
    private static final long LOW32_MASK  = 0x00000000ffffffffl;
    private static final long UNSIGN_MASK = 0x7fffffffffffffffl;

    private long _value;

    public Uint64(final long value) {
        _value = value;
    }

    /**
     * Construct a new uint64 wrapper with an initial value of 0
     */
    public Uint64() {
        this(0);
    }

    /**
     * Get the value of this channel as a signed long
     * @return Standard, signed long representing the value of this uint64
     */
    public long getValue() {
        return _value;
    }

    public BigInteger getValueAsBigInteger() {
        // mask out the sign bit and create the bigint
        BigInteger bigint = BigInteger.valueOf(_value & UNSIGN_MASK);
        if (_value < 0) {
            // if, when treating our value as a signed integer, we are negative,
            // we need to add back the sign bit on the bigint
            return bigint.setBit(Long.SIZE - 1);
        }
        return bigint;
    }


    public String getValueAsString() {
        return UnsignedLongs.toString(_value);
    }

    public long getHigh32Bits() {
        return _value >> 32l;
    }

    public int getHigh32BitsAsInt() {
        return (int) getHigh32Bits();
    }

    public void setHigh32Bits(final long high32) {
        // perform a bogus checked cast, since we need the value in a long for the shift to work properly
        UnsignedNumbers.checkedUint32Cast(high32);
        _value = (_value & LOW32_MASK) | (high32 << 32);
    }

    public long getLow32Bits() {
        return _value & LOW32_MASK;
    }

    public int getLow32BitsAsInt() {
        return (int) getLow32Bits();
    }

    public void setLow32Bits(final long low32) {
        // perform a bogus checked cast to enforce the parameter being a uint32
        UnsignedNumbers.checkedUint32Cast(low32);
        _value = (_value & HIGH32_MASK) | low32;
    }

    public String toString() {
        return "Uint64(dec=" + UnsignedLongs.toString(_value) + ", high32=" + getHigh32Bits()
                + ", low32=" + getLow32Bits() + ")";
    }
}
