class Solution {
    private long MOD = 1_000_000_007;

    // Recursive function to calculate x raised to the power n (x^n)
    public long pow(long x, long n) {
        // Base case: any number raised to the power 0 is 1
        if (n == 0) {
            return 1;
        }
        //Recursive Call
        long temp = pow(x, n / 2);

        if (n % 2 == 0) {
            return (temp * temp) % MOD;
        } else {
            return (x * temp * temp) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = (n / 2);
        long first = pow(5, even) % MOD;
        long second = pow(4, odd) % MOD;
        return (int) ((first * second) % MOD);
    }
}