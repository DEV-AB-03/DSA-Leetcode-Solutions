class Solution {
    public int dfs(int low, int high, int[] nums, int[][] dp) {
        // Base Case
        if (low == high) {
            // Only 1 element left
            return nums[low];
        }

        if (dp[low][high] != -1) {
            return dp[low][high];
        }
        // Try out all ways
        // At every step, p1 chooses something so effectively the score gains and reduces same, so only track score difference
        int pickLeft = nums[low] - dfs(low + 1, high, nums, dp);
        int pickRight = nums[high] - dfs(low, high - 1, nums, dp);

        // Return Max to parent
        return dp[low][high] = Math.max(pickLeft, pickRight);

    }

    public boolean predictTheWinner(int[] nums) {
        // Recursion
        // If max score achieved of s1 and s2 and s1-s2>=0;then player 1 can win
        // return the max difference between s1 and s2
        // memoization
        int low = 0;
        int high = nums.length - 1;
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(low, high, nums, dp) >= 0;

    }
}