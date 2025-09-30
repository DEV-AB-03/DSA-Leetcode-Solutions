class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // Sliding Window
        if (k <= 1)
            return 0;
        int left = 0;
        int count = 0;
        int right = 0;
        int prod = 1;
        while (right < nums.length) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            if (prod < k) {
                count += right - left + 1;
            }
            right++;
        }
        return count;
    }
}