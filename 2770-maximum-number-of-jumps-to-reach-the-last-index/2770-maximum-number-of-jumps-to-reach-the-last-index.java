class Solution {
    public int dfs(int idx, int[] nums, int target, int dp[]) {
        //Base Case
        if (idx == nums.length - 1) {
            return 0;
        }

        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }

        // Try Out All Ways
        int ans = Integer.MIN_VALUE;

        for (int i = idx + 1; i < nums.length; i++) {
            // Check if i is reachable
            if (Math.abs(nums[idx] - nums[i]) <= target) {
                // Idx is reachable from previous
                ans = Math.max(ans, 1 + dfs(i, nums, target, dp));
            }
        }

        // Return answer to parent
        return dp[idx] = ans;
    }

    public int maximumJumps(int[] nums, int target) {
        // Recursion
        // memoization
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int ans = dfs(0, nums, target, dp);
        if (ans < 0) {
            return -1;
        }
        return ans;
    }
}