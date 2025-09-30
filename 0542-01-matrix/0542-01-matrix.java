class Pair {
    int row;
    int col;
    int steps;

    public Pair(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    public boolean notOutOfBounds(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public int[][] updateMatrix(int[][] mat) {
        // BFS Search - Multi Source Solution
        int n = mat.length;
        int m = mat[0].length;

        // Create a vis matrix
        boolean[][] vis = new boolean[n][m];

        // Queue for BFS Approach
        Queue<Pair> pq = new LinkedList<>();

        // Create dist matrix
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = true;
                    dist[i][j] = 0;
                    pq.offer(new Pair(i, j, 0));
                }
            }
        }

        // Declare directional arrays
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        // Start BFS Search
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair pair = pq.poll();
                int row = pair.row;
                int col = pair.col;
                int steps = pair.steps;
                dist[row][col] = steps;

                for (int j = 0; j < 4; j++) {
                    int nrow = row + drow[j];
                    int ncol = col + dcol[j];

                    if (notOutOfBounds(nrow, ncol, n, m) && !vis[nrow][ncol]) {
                        vis[nrow][ncol] = true;
                        pq.offer(new Pair(nrow, ncol, steps + 1));
                    }
                }
            }
        }
        return dist;
    }
}