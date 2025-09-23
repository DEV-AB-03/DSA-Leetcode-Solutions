class Solution {
    public boolean dfs(int[] nums, int index, int sum, int target, Boolean[][] dp) {
        if (sum > target) {
            return false;
        }
        if (index == nums.length) {
            return sum == target;
        }
        if (dp[index][sum] != null) {
            return dp[index][sum];
        }
        // Explore all paths
        boolean choose = dfs(nums, index + 1, sum + nums[index], target, dp);

        boolean skip = dfs(nums, index + 1, sum, target, dp);

        dp[index][sum] = choose || skip;
        return dp[index][sum];
    }

    public boolean canPartition(int[] nums) {
        // Recursion Solution
        // Memoized Solution
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        // If sum is not divisble by 2 we can not split it;
        if (totalSum % 2 != 0) {
            return false;
        }
        totalSum /= 2;
        Boolean[][] dp = new Boolean[nums.length + 1][totalSum + 1];
        return dfs(nums, 0, 0, totalSum, dp);
    }
}