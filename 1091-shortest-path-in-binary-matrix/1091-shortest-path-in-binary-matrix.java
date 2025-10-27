import java.util.*;

class Pair {
    int row;
    int col;
    int dist;

    public Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {
    public boolean notOutOfBounds(int row, int col, int n) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Edge Case: Start or End blocked
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // 8 Directional movement
        int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
        int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

        boolean[][] vis = new boolean[n][n];
        Queue<Pair> q = new LinkedList<>();

        // Initialize
        q.offer(new Pair(0, 0, 1)); // distance starts at 1
        vis[0][0] = true;

        // BFS traversal
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.row;
            int col = curr.col;
            int dist = curr.dist;

            // If reached the target
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            // Explore all 8 directions
            for (int i = 0; i < 8; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                if (notOutOfBounds(nrow, ncol, n) && grid[nrow][ncol] == 0 && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol, dist + 1));
                }
            }
        }

        // No path found
        return -1;
    }
}
