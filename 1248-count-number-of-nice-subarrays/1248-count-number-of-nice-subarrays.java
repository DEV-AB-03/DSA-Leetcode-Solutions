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

    public int numberOfSubarrays(int[] nums, int k) {
        // Similar to Binary Array Question
        // We can put 0 in place of even numbers and 1 in place of odd numbers and then use code from previous question to solve this
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] % 2;
        }
        return countArrays(nums, k) - countArrays(nums, k - 1);
    }
}