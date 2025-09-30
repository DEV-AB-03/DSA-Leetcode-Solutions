class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int freq = 0;
        int left = 0;
        int right = 0;
        int len = -1;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.get(nums[right]) > k) {
                map.put(nums[left], map.getOrDefault(nums[left], 0) - 1);
                left++;
            }

            if (map.get(nums[right]) <= k) {
                len = Math.max(len, right - left + 1);
            }
            right++;
        }
        return len;
    }
}