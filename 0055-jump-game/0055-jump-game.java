class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxPos < i) {
                // Cant reach the current index
                return false;
            }
            maxPos = Math.max(maxPos, i + nums[i]);
            if (maxPos >= nums.length) {
                return true;
            }
        }
        return true;
    }
}