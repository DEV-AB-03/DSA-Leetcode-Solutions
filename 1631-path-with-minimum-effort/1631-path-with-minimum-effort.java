class Pair {
    int row;
    int col;
    int effort;

    public Pair(int row, int col, int effort) {
        this.row = row;
        this.col = col;
        this.effort = effort;
    }
}

class Solution {
    public boolean notOutOfBounds(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public int minimumEffortPath(int[][] heights) {
        // BFS Appoach
        // Motivation from Djikstra's Algorithm

        // Initialize a Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.effort - y.effort);

        // Initialize a dist matrix
        int[][] dist = new int[heights.length][heights[0].length];

        // Fill it with large values
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Initial Steps
        dist[0][0] = 0;
        pq.offer(new Pair(0, 0, 0));

        // 4-directional movement: up, down, left, right
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        // Start The BFS Traversal
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int effort = pair.effort;
            if (row == heights.length - 1 && col == heights[0].length - 1) {
                return effort;
            }

            // Explore all Paths
            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];
                if (notOutOfBounds(nrow, ncol, heights.length, heights[0].length)) {
                    int newEffort = Math.max(effort, Math.abs(heights[nrow][ncol] - heights[row][col]));
                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.offer(new Pair(nrow, ncol, newEffort));
                    }
                }
            }
        }
        return 0;
    }
}