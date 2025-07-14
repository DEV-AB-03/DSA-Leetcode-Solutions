class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, 0, 0, target);
        return count;
    }

    private void backtrack(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            if (currentSum == target) {
                count++;
            }
            return;
        }

        // Choose '+'
        backtrack(nums, index + 1, currentSum + nums[index], target);
        // Choose '-'
        backtrack(nums, index + 1, currentSum - nums[index], target);
    }
}
