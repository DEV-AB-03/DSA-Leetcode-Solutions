class Solution {
    public boolean notOutOfBounds(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public void dfs(int row, int col, int[][] grid, boolean[][] vis, int[] drow, int[] dcol) {
        // Mark cell as visited
        vis[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (notOutOfBounds(nrow, ncol, grid.length, grid[0].length) && !vis[nrow][ncol]
                    && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, grid, vis, drow, dcol);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        // DFS Approach
        int landCells = 0;

        int n = grid.length;
        int m = grid[0].length;

        // Create a vis matrix
        boolean[][] vis = new boolean[n][m];

        // Declare directional arrays
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        // Traverse First and Last Rows, Columns
        for (int i = 0; i < m; i++) {
            // First Row
            if (!vis[0][i] && grid[0][i] == 1) {
                dfs(0, i, grid, vis, drow, dcol);
            }

            // Last Row
            if (!vis[n - 1][i] && grid[n - 1][i] == 1) {
                dfs(n - 1, i, grid, vis, drow, dcol);
            }
        }

        for (int i = 0; i < n; i++) {
            // First Column
            if (!vis[i][0] && grid[i][0] == 1) {
                dfs(i, 0, grid, vis, drow, dcol);
            }

            // Last Column
            if (!vis[i][m - 1] && grid[i][m - 1] == 1) {
                dfs(i, m - 1, grid, vis, drow, dcol);
            }
        }

        // Now calculate all valid land cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    landCells++;
                }
            }
        }
        return landCells;

    }
}