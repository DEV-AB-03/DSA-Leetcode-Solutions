class Solution {
    public int dfs(int index, int remainder, int[] nums, int[][] dp) {
        if (index == nums.length) {
            // Return Sum
            if (remainder == 0) {
                return 0;
            } else {
                return -1;
            }
        }
        if (dp[index][remainder] != -1) {
            return dp[index][remainder];
        }
        // Explore all possible paths
        // Skip the current element
        int skip = dfs(index + 1, remainder, nums, dp);
        // Take the current element
        int newRem = (remainder + nums[index]) % 3;
        int takeRest = dfs(index + 1, newRem, nums, dp);

        int take = (takeRest == -1) ? -1 : takeRest + nums[index];

        // Return answer to parent
        return dp[index][remainder] = Math.max(take, skip);

    }

    public int maxSumDivThree(int[] nums) {
        // Recursion
        // Memoization
        // If i consider dp state to be index, remainder, then that will reduce my memory occupied way further
        int[][] dp = new int[nums.length][3];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, nums, dp);
    }
}