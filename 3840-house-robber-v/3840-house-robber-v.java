import java.util.*;

class Solution {

    long[] dp;

    public long dfs(int index, int[] nums, int[] colors) {
        // Base Case
        if (index >= nums.length) {
            return 0;
        }

        // Memo check
        if (dp[index] != -1) {
            return dp[index];
        }

        // Explore all Possible Paths
        long skip = dfs(index + 1, nums, colors);

        long choose;
        if (index + 1 < nums.length && colors[index] == colors[index + 1]) {
            // same color -> cannot rob adjacent
            choose = nums[index] + dfs(index + 2, nums, colors);
        } else {
            // different color -> adjacent allowed
            choose = nums[index] + dfs(index + 1, nums, colors);
        }

        // Store + Return answer
        return dp[index] = Math.max(skip, choose);
    }

    public long rob(int[] nums, int[] colors) {
        dp = new long[nums.length];
        Arrays.fill(dp, -1);

        // Recursion Solution
        return dfs(0, nums, colors);
    }
}
