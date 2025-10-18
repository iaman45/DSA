class Solution {
    static final long MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2; // number of even positions
        long odd = n / 2;        // number of odd positions

        long evenPower = power(5, even);
        long oddPower = power(4, odd);

        return (int)((evenPower * oddPower) % MOD);
    }

    // Fast modular exponentiation function
    private long power(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1)  // if exponent is odd
                result = (result * base) % MOD;
            base = (base * base) % MOD;  // square the base
            exp >>= 1;                   // divide exponent by 2
        }
        return result;
    }
}
