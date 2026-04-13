class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        if (nums[start] == target) {
            return 0;
        }
        int left = start - 1;
        int right = start + 1;
        while (left >= 0 && nums[left] != target) {
            left--;
        }
        while (right < nums.length && nums[right] != target) {
            right++;
        }
        int dist = Integer.MAX_VALUE;
        if (left >= 0) {
            dist = Math.min(dist, Math.abs(left - start));
        }
        if (right < nums.length) {
            dist = Math.min(dist, Math.abs(right - start));
        }
        return dist;
    }
}