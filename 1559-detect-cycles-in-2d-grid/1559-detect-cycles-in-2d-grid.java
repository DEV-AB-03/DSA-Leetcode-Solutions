class Solution {
    public boolean outOfBounds(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    public boolean dfs(char[][] grid, int row, int col, int prow, int pcol, boolean[][] vis) {

        // Mark current cell as visited
        vis[row][col] = true;

        // 4 Directions: Up, Right, Down, Left
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            if (outOfBounds(nrow, ncol, grid) &&
                    grid[nrow][ncol] == grid[row][col] &&
                    !(nrow == prow && ncol == pcol)) {

                if (vis[nrow][ncol]) {
                    return true;
                }

                if (dfs(grid, nrow, ncol, row, col, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!vis[i][j]) {
                    if (dfs(grid, i, j, -1, -1, vis)) {
                        return true;
                    }
                }

            }
        }

        return false;
    }
}