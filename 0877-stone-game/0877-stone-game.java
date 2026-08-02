class Solution {
    public int dfs(int low, int high, int[] nums, int[][] dp) {
        // Base Case
        if (low == high) {
            return nums[low];
        }

        if (dp[low][high] != -1) {
            return dp[low][high];
        }

        // try out all ways
        int pickLeft = nums[low] - dfs(low + 1, high, nums, dp);
        int pickRight = nums[high] - dfs(low, high - 1, nums, dp);

        // return ans to parent
        return dp[low][high] = Math.max(pickLeft, pickRight);
    }

    public boolean stoneGame(int[] piles) {
        // Track max difference between p1 and p2
        //memoization
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int low = 0;
        int high = piles.length - 1;

        return dfs(low, high, piles, dp) > 0;
    }
}