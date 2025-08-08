class Solution {
    public int countArrays(int[] nums, int goal) {
        // We will count subarrays with sum<=goal
        if (goal < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            if (sum <= goal) {
                count += right - left + 1;
            }
            right++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return countArrays(nums, goal) - countArrays(nums, goal - 1);

    }
}