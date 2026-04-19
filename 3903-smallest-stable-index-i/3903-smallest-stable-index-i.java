class Solution {
    public int firstStableIndex(int[] nums, int k) {
        // Brute Force since constraints are small enough
        for (int i = 0; i < nums.length; i++) {
            // Find max from left hand side
            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                max = Math.max(max, nums[j]);
            }
            // Find min from right hand side
            int min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
            }
            if (max - min <= k) {
                return i;
            }
        }
        return -1;
    }
}