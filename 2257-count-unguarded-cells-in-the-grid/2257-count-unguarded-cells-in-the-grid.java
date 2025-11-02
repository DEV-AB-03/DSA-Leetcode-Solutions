class Solution {
    public boolean notOutOfBounds(int row, int col, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    public void dfs(int row, int col, String direction, boolean[][] vis, int[][] grid, int m, int n) {
        // Mark this cell as visited
        vis[row][col] = true;

        // Explore Further
        if (direction.equals("R")) {
            int nrow = row;
            int ncol = col + 1;
            if (notOutOfBounds(nrow, ncol, m, n) && grid[nrow][ncol] != 1) {
                dfs(nrow, ncol, "R", vis, grid, m, n);
            }
        }
        if (direction.equals("L")) {
            int nrow = row;
            int ncol = col - 1;
            if (notOutOfBounds(nrow, ncol, m, n) && grid[nrow][ncol] != 1) {
                dfs(nrow, ncol, "L", vis, grid, m, n);
            }
        }
        if (direction.equals("U")) {
            int nrow = row - 1;
            int ncol = col;
            if (notOutOfBounds(nrow, ncol, m, n) && grid[nrow][ncol] != 1) {
                dfs(nrow, ncol, "U", vis, grid, m, n);
            }
        }
        if (direction.equals("D")) {
            int nrow = row + 1;
            int ncol = col;
            if (notOutOfBounds(nrow, ncol, m, n) && grid[nrow][ncol] != 1) {
                dfs(nrow, ncol, "D", vis, grid, m, n);
            }
        }
    }

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // DFS Approach

        // Matrix Create
        int[][] grid = new int[m][n];

        // Mark gaurds and walls with 1
        // Create a visited matrix
        boolean[][] vis = new boolean[m][n];

        // Mark Initial Gaurds
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }

        // Mark Initial Walls
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;
        }

        // Now start DFS Traversal
        // We start with gaurds
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            // Now we put a DFS recursive call to mark visible cells
            dfs(row, col, "R", vis, grid, m, n);
            dfs(row, col, "L", vis, grid, m, n);
            dfs(row, col, "U", vis, grid, m, n);
            dfs(row, col, "D", vis, grid, m, n);
        }

        int freeCells = 0;
        // Now we count the free cells -> Those which havent been visited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 0) {
                    freeCells++;
                }
            }
        }
        return freeCells;
    }
}