class Solution {

    Integer[][][] dp;

    public int dfs(int row, int col, int neutRob, int[][] coins) {
        // Base Cases
        if (row >= coins.length || col >= coins[0].length) {
            return Integer.MIN_VALUE;
        }

        // Memo check
        if (dp[row][col][neutRob] != null) {
            return dp[row][col][neutRob];
        }

        int val = coins[row][col];

        // We reached last cell
        if (row == coins.length - 1 && col == coins[0].length - 1) {
            if (val >= 0)
                return dp[row][col][neutRob] = val;
            if (neutRob > 0)
                return dp[row][col][neutRob] = 0;
            return dp[row][col][neutRob] = val;
        }

        // Try out all possible ways
        int gain = Integer.MIN_VALUE;

        if (coins[row][col] >= 0) {
            // I cam simply take this coin
            int right = dfs(row, col + 1, neutRob, coins);
            int down = dfs(row + 1, col, neutRob, coins);

            int next = Math.max(right, down);

            if (next != Integer.MIN_VALUE) {
                gain = Math.max(gain, coins[row][col] + next);
            }

        } else {
            // Skip (i.e., don't neutralize → take loss)
            int right = dfs(row, col + 1, neutRob, coins);
            int down = dfs(row + 1, col, neutRob, coins);

            int next = Math.max(right, down);

            if (next != Integer.MIN_VALUE) {
                gain = Math.max(gain, coins[row][col] + next);
            }

            // Neutralize robber
            if (neutRob > 0) {
                int right1 = dfs(row, col + 1, neutRob - 1, coins);
                int down1 = dfs(row + 1, col, neutRob - 1, coins);

                int next1 = Math.max(right1, down1);

                if (next1 != Integer.MIN_VALUE) {
                    gain = Math.max(gain, next1);
                }
            }
        }

        // Store and return
        return dp[row][col][neutRob] = gain;
    }

    public int maximumAmount(int[][] coins) {
        // Recursion + Memoization Solution
        dp = new Integer[coins.length][coins[0].length][3];
        return dfs(0, 0, 2, coins);
    }
}