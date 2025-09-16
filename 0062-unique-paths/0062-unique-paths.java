class Solution {
    public int dfs(int startIdx, int endIdx, int m, int n) {
        if (startIdx == m && endIdx == n) {
            // We have reached end cell, so we found a valid path and hence return 1.
            return 1;
        }
        if (startIdx < 0 || startIdx > m || endIdx < 0 || endIdx > n) {
            // We have moved outside of grid, please come back to previous state
            return 0;
        }

        // Explore all Paths
        int right = dfs(startIdx, endIdx + 1, m, n);

        int down = dfs(startIdx + 1, endIdx, m, n);

        // Return the paths to parent
        return right + down;
    }

    public int uniquePaths(int m, int n) {
        // Recursive Solution
        return dfs(0, 0, m - 1, n - 1);
    }
}