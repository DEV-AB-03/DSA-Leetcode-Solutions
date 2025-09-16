class Solution {
    public int jump(int step, int n, int[] dp) {
        if (step > n) {
            // No need to recurse further. Come back to previous state
            return 0;
        }
        if (step == n) {
            // We have reached last step
            return 1;
        }

        if (dp[step] != -1) {
            return dp[step];
        }

        // Explore all Paths
        int oneStepJump = jump(step + 1, n, dp);

        int twoStepJump = jump(step + 2, n, dp);

        dp[step] = oneStepJump + twoStepJump;

        return dp[step];
    }

    public int climbStairs(int n) {
        // Solve it by Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return jump(0, n, dp);
    }
}