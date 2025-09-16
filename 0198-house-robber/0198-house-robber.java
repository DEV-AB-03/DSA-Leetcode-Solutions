class Solution {
    public int dfs(int[] nums, int houseNumber, int[] dp) {
        if (houseNumber >= nums.length) {
            return 0;
        }
        if (dp[houseNumber] != -1) {
            return dp[houseNumber];
        }
        // Explore all possible Solutions
        int chooseHouse = nums[houseNumber] + dfs(nums, houseNumber + 2, dp);
        int notChooseHouse = 0 + dfs(nums, houseNumber + 1, dp);

        // Return Answer to Parent
        dp[houseNumber] = Math.max(chooseHouse, notChooseHouse);
        return dp[houseNumber];
    }

    public int rob(int[] nums) {
        // Recursive Solution
        // Memoize Solution
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }
}