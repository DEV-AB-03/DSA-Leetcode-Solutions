class Solution {
    public int dfs(int startIdx, int endIdx, int[][] grid, int[][] dp) {
        if (startIdx == grid.length - 1 && endIdx == grid[0].length - 1) {
            // We have sucessfully reached the last cell, so we return 1 valid path.
            return 1;
        }
        if (startIdx < 0 || startIdx >= grid.length || endIdx < 0 || endIdx >= grid[0].length
                || grid[startIdx][endIdx] == 1) {
            // Please come back as we have either moved outside the grid or we reached a blocked cell(obstacle).
            return 0;
        }
        if (dp[startIdx][endIdx] != -1) {
            return dp[startIdx][endIdx];
        }
        // Explore all Paths
        int right = dfs(startIdx, endIdx + 1, grid, dp);

        int down = dfs(startIdx + 1, endIdx, grid, dp);

        // Return the result to the parent
        dp[startIdx][endIdx] = right + down;
        return dp[startIdx][endIdx];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Edge Cases Check
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
            return 0;
        }
        // Recursive Solution
        // Memoized Solution
        int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length];
        for (int i = 0; i <= obstacleGrid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, obstacleGrid, dp);
    }
}