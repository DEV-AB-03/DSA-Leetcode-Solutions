class Solution {
    public int dfs(int index, int[] nums, int[] dp) {
        // Base Case
        if (index >= nums.length) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        // Try Out All Ways
        int choose = nums[index] + dfs(index + 2, nums, dp);
        int skip = 0 + dfs(index + 1, nums, dp);

        return dp[index] = Math.max(choose, skip);
    }

    public int rob(int[] nums) {
        // Recursion Solution
        // Memoization Solution
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(0, nums, dp);
    }
}