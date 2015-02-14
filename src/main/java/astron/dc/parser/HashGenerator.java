package astron.dc.parser;

import java.util.ArrayList;

/**
 * Generate a hash based upon a succession of integers
 * @author jjkoletar
 */
public class HashGenerator {

    //TODO: Review how to deal with the fact that a true DC hash is a uint32 and write a unit test for it
    private int _hash;
    private int _index;

    /**
     * Constant taken from https://github.com/Astron/Astron/blob/918242/src/dclass/util/HashGenerator.cpp#L23
     */
    private static final int MAX_PRIME_NUMBERS = 10000;

    public HashGenerator() {
        _hash = 0;
        _index = 0;
    }

    /**
     * Add another integer to the hash so far
     * @param num value to mix into the hash
     */
    public void addInt(final int num) {
        _hash += PrimeNumberGenerator.instance.get(_index) * num;
        _index = (_index + 1) % MAX_PRIME_NUMBERS;
    }

    /**
     * Add a string to the hash.
     *
     * Internally, the HashGenerator will first add the string's length to the hash,
     * followed by the character value of each character
     * @param str String to mix into the hash
     */
    public void addString(final String str) {
        addInt(str.length());
        for (int i = 0; i < str.length(); i++) {
            addInt(str.charAt(i));
        }
    }

    /**
     * Get the current value of the hash
     * @return the current value of the hash
     */
    public int getHash() {
        return _hash;
    }

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
            if (n < 0) {
                throw new IllegalArgumentException("Invalid prime number index: " + n);
            }
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
