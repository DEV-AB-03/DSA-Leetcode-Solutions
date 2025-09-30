class Solution {
    public boolean notOutOfBounds(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public void dfs(int row, int col, char[][] board, boolean[][] vis, int[] drow, int[] dcol) {
        // Mark cell as visited
        vis[row][col] = true;

        // Now go towards adjacent cells to mark further O's
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];

            if (notOutOfBounds(nrow, ncol, board.length, board[0].length) && !vis[nrow][ncol]
                    && board[nrow][ncol] == 'O') {
                dfs(nrow, ncol, board, vis, drow, dcol);
            }
        }

    }

    public void solve(char[][] board) {
        // DFS Approach
        int n = board.length;
        int m = board[0].length;

        // Create a vis matrix
        boolean[][] vis = new boolean[n][m];

        // Declare directional arrays
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        // Traverse over the Boundary Zeroes as they wont be eligible for conversion
        for (int j = 0; j < m; j++) {
            // First Row
            if (!vis[0][j] && board[0][j] == 'O') {
                // Look for further connected 0's
                dfs(0, j, board, vis, drow, dcol);
            }

            // Last Row
            if (!vis[n - 1][j] && board[n - 1][j] == 'O') {
                // Look for further connected 0's
                dfs(n - 1, j, board, vis, drow, dcol);
            }
        }

        for (int i = 0; i < n; i++) {
            // First Column
            if (!vis[i][0] && board[i][0] == 'O') {
                // Look for further connected 0's
                dfs(i, 0, board, vis, drow, dcol);
            }

            // Last Column
            if (!vis[i][m - 1] && board[i][m - 1] == 'O') {
                // Look for further connected 0's
                dfs(i, m - 1, board, vis, drow, dcol);
            }
        }

        // Now convert all valid O's to X
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}