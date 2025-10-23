import java.util.*;

class Solution {
    public int dfs(int index, int prevIdx, int[] nums, int[][] dp) {
        // Base case
        if (index == nums.length) {
            return 0;
        }

        // Check memoized value
        if (dp[index][prevIdx + 1] != -1) {
            return dp[index][prevIdx + 1];
        }

        // Option 1: Skip the current element
        int skip = dfs(index + 1, prevIdx, nums, dp);

        // Option 2: Take the current element (if valid)
        int take = 0;
        if (prevIdx == -1 || nums[index] > nums[prevIdx]) {
            take = 1 + dfs(index + 1, index, nums, dp);
        }

        // Memoize and return best
        return dp[index][prevIdx + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1]; // +1 to handle prevIdx = -1
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return dfs(0, -1, nums, dp);
    }
}
