class Solution {
    public int smallestNumber(int n) {
        // Step 1: if all bits are already 1, return n
        if ((n & (n + 1)) == 0) {
            return n;
        }

        // Step 2: find bit length
        int bits = Integer.toBinaryString(n).length();

        // Step 3: add 1s until the number >= n
        int x = (1 << bits) - 1;
        if (x < n) {
            // need one more bit if not sufficient
            x = (1 << (bits + 1)) - 1;
        }

        return x;
    }
}
