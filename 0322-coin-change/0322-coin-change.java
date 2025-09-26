class Solution {
    public int dfs(int[] coins, int index, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }
        if (target < 0 || index < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        // Explore all Possible Solutions

        int choose = dfs(coins, index, target - coins[index], dp);
        if (choose != Integer.MAX_VALUE)
            choose += 1; // Add the coin we took
        int skip = 0 + dfs(coins, index - 1, target, dp);

        dp[index][target] = Math.min(choose, skip);
        return dp[index][target];
    }

    public int coinChange(int[] coins, int amount) {
        // Fewer Coins means we need to pick coins of larger denomination more
        // Memoized Solution
        int[][] dp = new int[coins.length + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int numCoins = dfs(coins, coins.length - 1, amount, dp);
        if (numCoins == Integer.MAX_VALUE) {
            return -1;
        }
        return numCoins;

    }
}