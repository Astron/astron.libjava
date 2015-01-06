package astron.datagram;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the Uint64 wrapper class
 *
 * @author jjkoletar
 */
public class Uint64Test {

    @Test
    public void testUint64() {
        Uint64 channel = new Uint64();
        channel.setHigh32Bits(1001);
        assertEquals(4299262263296l, channel.getValue()); // test against `1001 << 32`'s value in python
        assertEquals(1001l, channel.getHigh32Bits());
        assertEquals(1001, channel.getHigh32BitsAsInt());
    }
}
