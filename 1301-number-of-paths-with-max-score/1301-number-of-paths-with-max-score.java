class Solution {
    int MOD = 1_000_000_007;
    int[][] dirs = { { -1, 0 }, { 0, -1 }, { -1, -1 } };

    public boolean outOfBounds(int i, int j, int n) {
        return i < 0 || i >= n || j < 0 || j >= n;
    }

    public int countPaths(int i, int j, char[][] grid, int sum, int[][] pathDp, int[][] dp) {
        // Base Case
        if (i == 0 && j == 0 && sum == 0) {
            // Found a valid path
            return 1;
        }
        if (outOfBounds(i, j, grid.length) || grid[i][j] == 'X' || sum < 0 || sum != dp[i][j]) {
            return 0;
        }
        if (pathDp[i][j] != -1) {
            return pathDp[i][j];
        }
        int count = 0;
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            int childResult = countPaths(ni, nj, grid, sum - Integer.parseInt(String.valueOf(grid[i][j])), pathDp, dp);
            count = (count + childResult) % MOD;
        }

        // Return answer to Parent
        return pathDp[i][j] = count;

    }

    public int dfs(int i, int j, char[][] grid, int[][] dp) {
        //Base Case
        if (i == 0 && j == 0) {
            return 0;
        }
        if (outOfBounds(i, j, grid.length) || grid[i][j] == 'X') {
            return Integer.MIN_VALUE;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int res = Integer.MIN_VALUE;
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];

            int childResult = dfs(ni, nj, grid, dp);
            if (childResult == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, Integer.parseInt(String.valueOf(grid[i][j])) + childResult);
        }

        // Return answer to parent
        return dp[i][j] = res;

    }

    private char[][] buildMatrix(List<String> board) {
        int n = board.size();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = board.get(i).toCharArray();
        }
        // Mark S and E as 0
        grid[n - 1][n - 1] = '0';
        grid[0][0] = '0';
        return grid;
    }

    public int[] pathsWithMaxScore(List<String> board) {
        // Recursion
        char[][] grid = buildMatrix(board);
        int n = grid.length;

        // memoization
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int maxSum = dfs(n - 1, n - 1, grid, dp);

        if (maxSum == Integer.MIN_VALUE) {
            return new int[] { 0, 0 };
        }

        // memoization
        int[][] pathDp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(pathDp[i], -1);
        }

        int numPaths = countPaths(n - 1, n - 1, grid, maxSum, pathDp, dp);
        numPaths = numPaths % MOD;

        return new int[] { maxSum, numPaths };
    }
}