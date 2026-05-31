class Solution {
    Integer[][][] dp;
    int[] facCount;

    public int solve(int[][] items, int k, int i, int isPrev) {
        if (k < 0)
            return Integer.MIN_VALUE; // over budget
        if (i >= items.length)
            return 0;

        if (dp[i][k][isPrev] != null)
            return dp[i][k][isPrev];

        int free = 0;
        if (isPrev == 0) {
            free = facCount[i]; // free copies
        }

        int take = 1 + free + solve(items, k - items[i][1], i, 1); //  (current copy + free copies + others)
        int skip = solve(items, k, i + 1, 0);

        int res = Math.max(take, skip);

        return dp[i][k][isPrev] = res;
    }

    public int maximumSaleItems(int[][] items, int budget) {

        // pre-compute factors count for every element i
        facCount = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items.length; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    facCount[i]++;
                }
            }
        }

        dp = new Integer[items.length][budget + 1][2];
        return solve(items, budget, 0, 0);
    }
}