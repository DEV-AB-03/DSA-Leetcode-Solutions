class Solution {
    public int dfs(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        }
        //Explore All Possible paths
        int addPlusSign = dfs(nums, index + 1, sum + nums[index], target);
        int addMinusSign = dfs(nums, index + 1, sum - nums[index], target);

        return addPlusSign + addMinusSign;
    }

    public int findTargetSumWays(int[] nums, int target) {
        // Recursive Solution
        return dfs(nums, 0, 0, target);
    }
}