class Solution {
    public long sumAndMultiply(int n) {
        if (n == 0) {
            return 0;
        }
        long sum = 0;
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int rem = n % 10;
            if (rem != 0) {
                sb.append(Integer.toString(rem));
                sum += rem;
            }
            n = n / 10;
        }
        long newNumber = Integer.parseInt(sb.reverse().toString());
        return newNumber * sum;

    }
}