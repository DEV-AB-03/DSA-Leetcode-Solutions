class Solution {
    public int dfs(int[][] grid, int startIdx, int endIdx, int[][] dp) {
        if (startIdx < 0 || startIdx >= grid.length || endIdx < 0 || endIdx >= grid[0].length) {
            // We have moved out of the grid. Please come back to previous state
            return (int) Math.pow(10, 9);
        }
        if (startIdx == grid.length - 1 && endIdx == grid[0].length - 1) {
            // We have reached the last cell successfully.
            return grid[startIdx][endIdx];
        }
        if (dp[startIdx][endIdx] != -1) {
            return dp[startIdx][endIdx];
        }
        // Explore all possible paths
        int right = grid[startIdx][endIdx] + dfs(grid, startIdx, endIdx + 1, dp);

        int down = grid[startIdx][endIdx] + dfs(grid, startIdx + 1, endIdx, dp);

        // Return the answer to parent
        dp[startIdx][endIdx] = Math.min(right, down);
        return dp[startIdx][endIdx];
    }

    public int minPathSum(int[][] grid) {
        // Recursive Solution
        // Memoized Solution
        int[][] dp = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 0; i <= grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(grid, 0, 0, dp);
    }
}