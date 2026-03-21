import java.util.*;

class Solution {

    public void bfs(int row, int col, char[][] grid, boolean[][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { row, col });
        vis[row][col] = true;

        int[][] directions = {
                { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == '1' &&
                        !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    q.offer(new int[] { newRow, newCol });
                }
            }
        }
    }

    public int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int islands = 0;

        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    bfs(i, j, grid, vis);
                }
            }
        }

        return islands;
    }
}