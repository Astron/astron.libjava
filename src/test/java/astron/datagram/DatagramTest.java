package astron.datagram;

import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedLongs;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Test the Datagram class.
 *
 * Testing procedure is to generate test Datagrams using a reference implementation of Datagram logic (such as Panda3D),
 * encode the resulting message as base64, and then decode it in this test.
 * @author jjkoletar
 */
public class DatagramTest {

    /**
     * Assert that the contents of the Datagram are equivalent to the contents of the base 64 encoded reference string
     * @param dg datagram to test
     * @param b64reference base64 encoded string
     */
    public static void compareDatagram(final Datagram dg, final String b64reference) {
        assertArrayEquals(Base64.decodeBase64(b64reference), dg.getBytes());
    }

    @Test
    public void testDatagramConstruction() {
        String data;
        Datagram dg;

        /*
         * string "107.9 KQQL"
         * float32 107.9
         */
        data = "CgAxMDcuOSBLUVFMzczXQg==";
        dg = new Datagram();
        dg.addString("107.9 KQQL");
        dg.addFloat32(107.9f);
        compareDatagram(dg, data);

        /*
         * uint8 255
         * uint16 65535
         * uint32 4294967295
         * uint64 (1001 << 32) | 1234
         */
        data = "/////////9IEAADpAwAA";
        dg = new Datagram();
        dg.addUint8(255);
        dg.addUint16(65535);
        dg.addUint32(4294967295l);
        dg.addUint64((1001l << 32) | 1234l);
        compareDatagram(dg, data);
    }
}
