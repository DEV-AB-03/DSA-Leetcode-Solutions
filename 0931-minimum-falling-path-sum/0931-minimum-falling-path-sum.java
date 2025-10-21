import java.util.Arrays;

class Solution {
    private boolean outOfBounds(int r, int c, int n) {
        return r < 0 || r >= n || c < 0 || c >= n;
    }

    private int dfs(int r, int c, int[][] mat, int n, int[][] dp) {
        if (outOfBounds(r, c, n))
            return (int) 1e9;
        if (r == n - 1)
            return mat[r][c];
        if (dp[r][c] != Integer.MAX_VALUE)
            return dp[r][c];

        int down = mat[r][c] + dfs(r + 1, c, mat, n, dp);
        int left = mat[r][c] + dfs(r + 1, c - 1, mat, n, dp);
        int right = mat[r][c] + dfs(r + 1, c + 1, mat, n, dp);

        dp[r][c] = Math.min(down, Math.min(left, right));
        return dp[r][c];
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);

        int ans = Integer.MAX_VALUE;
        for (int c = 0; c < n; c++) {
            ans = Math.min(ans, dfs(0, c, matrix, n, dp));
        }
        return ans;
    }
}
