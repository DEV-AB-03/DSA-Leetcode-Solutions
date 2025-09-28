class Solution {
    public boolean notOutOfBounds(int nrow, int ncol, int n, int m) {
        return nrow >= 0 && nrow < n && ncol >= 0 && ncol < m;
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // BFS on grid
        int n = image.length;
        int m = image[0].length;
        int originalColor = image[sr][sc];
        // If the new color is same as original, no need to do anything
        if (originalColor == color)
            return image;
        Queue<int[]> pq = new LinkedList<>();

        // Vis Array
        boolean[][] vis = new boolean[n][m];

        // Mark starting cell as visited, change color and push it into queue for further bfs search
        vis[sr][sc] = true;
        image[sr][sc] = color;
        pq.offer(new int[] { sr, sc });

        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        // Start BFS Search
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] cell = pq.poll();
                int r = cell[0];
                int c = cell[1];
                for (int j = 0; j < 4; j++) {
                    int ncol = c + dcol[j];
                    int nrow = r + drow[j];
                    if (notOutOfBounds(nrow, ncol, n, m) && !vis[nrow][ncol] && image[nrow][ncol] == originalColor) {
                        // Mark cell as visited, color it and push into queue for further traversal
                        image[nrow][ncol] = color;
                        vis[nrow][ncol] = true;
                        pq.offer(new int[] { nrow, ncol });
                    }
                }
            }
        }
        return image;
    }
}