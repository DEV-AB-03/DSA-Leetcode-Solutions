class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zer = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                zer++;
            }
            while (zer > k) {
                if (nums[left] == 0) {
                    zer--;
                }
                left++;
            }
            if (zer <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
    }
}