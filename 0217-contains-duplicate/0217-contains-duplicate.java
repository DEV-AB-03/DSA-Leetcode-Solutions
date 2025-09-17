class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Sorting Approach
        Arrays.sort(nums); // O(NLogN)
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}