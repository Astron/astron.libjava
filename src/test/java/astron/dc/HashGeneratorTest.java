package astron.dc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the {@link astron.dc.HashGenerator}
 *
 * @author jjkoletar
 */
public class HashGeneratorTest {

    @Test
    public void testPrimeNumberGenerator() {
        // from http://primes.utm.edu/lists/small/10000.txt
        final int[] SOME_PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173};
        // Iterate in descending order so that the PNG doesn't have to do multiple generation runs
        for (int i = SOME_PRIMES.length - 1; i >= 0; i--) {
            assertEquals(SOME_PRIMES[i], HashGenerator.PrimeNumberGenerator.instance.get(i));
        }
    }
}
