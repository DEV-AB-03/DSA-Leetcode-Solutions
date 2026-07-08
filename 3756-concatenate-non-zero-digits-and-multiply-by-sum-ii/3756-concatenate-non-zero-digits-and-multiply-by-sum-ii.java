class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;
        int n = s.length();

        long[] preSum = new long[n + 1];
        long[] preNum = new long[n + 1];
        int[] cnt = new int[n + 1];
        long[] pow10 = new long[n + 1];

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            preSum[i + 1] = preSum[i] + d;
            if (d != 0) {
                preNum[i + 1] = (preNum[i] * 10 + d) % MOD;
                cnt[i + 1] = cnt[i] + 1;
            } else {
                preNum[i + 1] = preNum[i];
                cnt[i + 1] = cnt[i];
            }
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int k = cnt[r + 1] - cnt[l];
            long sum = preSum[r + 1] - preSum[l];

            long x = (preNum[r + 1] - preNum[l] * pow10[k]) % MOD;
            if (x < 0)
                x += MOD;

            ans[i] = (int) ((x * (sum % MOD)) % MOD);
        }

        return ans;
    }
}