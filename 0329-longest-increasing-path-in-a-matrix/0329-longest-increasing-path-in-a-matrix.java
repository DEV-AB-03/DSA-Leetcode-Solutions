class Solution {
    int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    int[][] dp; // Memoization table
    int n, m;

    public int dfs(int r, int c, int[][] matrix) {
        // If already computed, return cached value
        if (dp[r][c] != 0)
            return dp[r][c];

        int maxPath = 1; // At least the cell itself

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m && matrix[nr][nc] > matrix[r][c]) {
                int len = 1 + dfs(nr, nc, matrix);
                maxPath = Math.max(maxPath, len);
            }
        }

        dp[r][c] = maxPath; // Memoize result
        return maxPath;
    }

    public int longestIncreasingPath(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];

        int pathLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pathLength = Math.max(pathLength, dfs(i, j, matrix));
            }
        }

        return pathLength;
    }
}
