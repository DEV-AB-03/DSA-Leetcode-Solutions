class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        // Binary Search
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            //we need to basically find a peak
            // so there are three cases, increasing slope, decreasing slope and peak
            if (nums[low] <= nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, nums[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}