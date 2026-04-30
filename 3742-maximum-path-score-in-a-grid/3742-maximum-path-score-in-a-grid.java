class Solution {
    public int dfs(int i, int j, int m, int n, int[][] grid, int k, int[][][] dp) {
        // Base Case
        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }
        int cost = (grid[i][j] == 0) ? 0 : 1;
        if (k < cost) {
            return Integer.MIN_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            // We have reached last cell
            return grid[i][j];
        }

        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }

        // Try out all Ways
        int remK = k - cost;

        int right = dfs(i, j + 1, m, n, grid, remK, dp);

        int down = dfs(i + 1, j, m, n, grid, remK, dp);

        // Return answer to parent
        int best = Math.max(right, down);

        if (best == Integer.MIN_VALUE) {
            return dp[i][j][k] = Integer.MIN_VALUE;
        } else {
            return dp[i][j][k] = grid[i][j] + best;
        }

    }

    public int maxPathScore(int[][] grid, int k) {
        // Recursion Solution
        // Memoization
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        // Fill with -1 meaning "uncomputed"

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = dfs(0, 0, m, n, grid, k, dp);
        if (ans < 0) {
            return -1;
        }
        return ans;
    }
}