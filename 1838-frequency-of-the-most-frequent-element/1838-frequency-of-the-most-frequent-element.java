class Solution {
    public int maxFrequency(int[] nums, int k) {
        // 1 2 4 k=5 -> [4, 4, 4]
        // Add +1 to each element
        // Make a given subarray same elements -> window size would be the max frequency possible for an element
        Arrays.sort(nums);
        int left = 0;
        int maxFreq = 1;
        long total = 0;
        for (int right = 0; right < nums.length; right++) {
            total += nums[right];
            long size = right - left + 1;
            while ((nums[right] * size) - total > k) {
                total -= nums[left];
                left++;
                size = right - left + 1;
            }
            maxFreq = Math.max(maxFreq, right - left + 1);
        }
        return maxFreq;
    }
}