package astron.dc;

import java.util.ArrayList;

/**
 * Generate a hash based upon a succession of integers
 * @author jjkoletar
 */
public class HashGenerator {

    /**
     * Generator of prime numbers.
     *
     * Mostly transcribed from https://github.com/Astron/Astron/blob/918242/src/dclass/util/PrimeNumberGenerator.cpp,
     * which was originally Panda3D source.
     */
    public static class PrimeNumberGenerator {
        // Singleton
        public static PrimeNumberGenerator instance = new PrimeNumberGenerator();

        // Class
        private ArrayList<Integer> _primes = new ArrayList<Integer>();
        private PrimeNumberGenerator() {
            _primes.add(2);
        }

        /**
         * Get the nth prime number.
         * @param n index of the prime starting at 0
         * @return the nth prime
         */
        public int get(final int n) {
            assert n >= 0;
            // ensure the arraylist has at least n of capacity
            _primes.ensureCapacity(n);
            int candidate = _primes.get(_primes.size() - 1) + 1;
            while (_primes.size() <= n) {
                boolean maybePrime = true;
                int j = 0;
                while (maybePrime && _primes.get(j) * _primes.get(j) <= candidate) {
                    if ((_primes.get(j) * (candidate / _primes.get(j))) == candidate) {
                        maybePrime = false;
                    }
                    j++;
                }
                if (maybePrime) {
                    _primes.add(candidate);
                }
                candidate++;
            }
            return _primes.get(n);
        }
    }
}
