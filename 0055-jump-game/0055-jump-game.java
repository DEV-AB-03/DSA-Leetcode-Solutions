class Solution {
    public boolean canJump(int[] nums) {
        // First Observation: If All integers in the array are greater than zero then we can definitely reach end no matter what, so we will check this case first
        boolean allNumsGreatThanZero = true;
        for (int num : nums) {
            if (num == 0) {
                allNumsGreatThanZero = false;
                break;
            }
        }
        if (allNumsGreatThanZero) {
            return true;
        }

        // Second Observation: At each index we will try to maintain a variable which will denote the maximum Index i can jump to from that position. If at certain case, we find that maxIdx>=arr.length-1, then we can reach end and stop there only.
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            maxIdx = Math.max(maxIdx, i + nums[i]);
            if (maxIdx >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}