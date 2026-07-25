class Solution {
    public int maxProduct(int n) {
        int f = 0;
        int s = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem > f) {
                s = f;
                f = rem;
            } else if (rem > s) {
                s = rem;
            }
            n /= 10;
        }
        return f * s;
    }
}