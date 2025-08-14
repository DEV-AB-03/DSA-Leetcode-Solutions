import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1); // -1 means not calculated yet
        return dfs(nums, 0, memo);
    }

    private int dfs(int[] nums, int index, int[] memo) {
        // Base case: if at or beyond the last index
        if (index >= nums.length - 1) {
            return 0;
        }

        // Return cached result if already computed
        if (memo[index] != -1) {
            return memo[index];
        }

        int maxJump = nums[index];
        int minJumps = Integer.MAX_VALUE;

        // Try all possible jumps from this position
        for (int step = 1; step <= maxJump; step++) {
            int nextIndex = index + step;
            if (nextIndex < nums.length) {
                int subResult = dfs(nums, nextIndex, memo);
                if (subResult != Integer.MAX_VALUE) {
                    minJumps = Math.min(minJumps, 1 + subResult);
                }
            }
        }

        memo[index] = minJumps;
        return memo[index];
    }
}
