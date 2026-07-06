class Solution {
    public int dfs(int idx, int[] nums, int[] dp) {
        // Base Case
        if (idx >= nums.length - 1) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int res = Integer.MAX_VALUE;
        int maxJumps = nums[idx];

        // Try Out all Ways
        for (int step = 1; step <= maxJumps; step++) {
            int nextIdx = idx + step;
            // Check within Bounds
            if (nextIdx < nums.length) {
                // Jump
                int childResult = dfs(nextIdx, nums, dp);
                if (childResult != Integer.MAX_VALUE) {
                    res = Math.min(res, 1 + childResult);
                }
            }
        }

        return dp[idx] = res;

    }

    public int jump(int[] nums) {
        // Recursion
        // memoization
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(0, nums, dp);
    }
}