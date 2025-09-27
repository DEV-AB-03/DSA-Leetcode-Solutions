class Pair {
    int row;
    int col;
    int time;

    public Pair(int _row, int _col, int _time) {
        this.row = _row;
        this.col = _col;
        this.time = _time;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        // BFS Search with Level Order Traversal
        int timeForRot = 0;
        Queue<Pair> pq = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Create a visited matrix to track visited cells
        int[][] vis = new int[n][m];

        int cntFresh = 0;
        //Fill all rotten cells with visited and put time as 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    vis[i][j] = 2;
                    pq.offer(new Pair(i, j, 0));
                } else if (grid[i][j] == 1) {
                    cntFresh++;
                    vis[i][j] = 1;
                } else {
                    vis[i][j] = 0;
                }
            }
        }
        int[] drow = { -1, 0, +1, 0 };
        int[] dcol = { 0, +1, 0, -1 };

        int count = 0;
        // Now start Traversal on Queue
        while (!pq.isEmpty()) {
            // Poll same level one by one
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Pair pair = pq.poll();
                int row = pair.row;
                int col = pair.col;
                int time = pair.time;
                timeForRot = Math.max(timeForRot, time);

                // Check in all 4 adjacent cells and process them
                for (int j = 0; j < 4; j++) {
                    int nrow = row + drow[j];
                    int ncol = col + dcol[j];

                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1
                            && vis[nrow][ncol] != 2) {
                        vis[nrow][ncol] = 2;
                        pq.offer(new Pair(nrow, ncol, time + 1));
                        count++;
                    }
                }
            }
        }
        if (count != cntFresh) {
            return -1;
        }
        return timeForRot;
    }
}