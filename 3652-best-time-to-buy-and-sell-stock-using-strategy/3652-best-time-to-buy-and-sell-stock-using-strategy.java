class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        long[] prefixProfit = new long[n + 1];
        long[] prefixPrice = new long[n + 1];

        long baseProfit = 0;

        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
            prefixProfit[i + 1] = prefixProfit[i] + (long) strategy[i] * prices[i];
            prefixPrice[i + 1] = prefixPrice[i] + prices[i];
        }

        long ans = baseProfit;
        int half = k / 2;

        // sliding window [i-k, i)
        for (int i = k; i <= n; i++) {
            int l = i - k;
            int mid = l + half;

            // remove original profit from window
            long modifiedProfit = baseProfit
                    - (prefixProfit[i] - prefixProfit[l]);

            // add sell profit from second half
            modifiedProfit += (prefixPrice[i] - prefixPrice[mid]);

            ans = Math.max(ans, modifiedProfit);
        }

        return ans;
    }
}
