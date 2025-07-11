class Solution {
    public boolean isValidPos(char[][] board, int row, int col) {
        int duprow = row;
        int dupcol = col;
        // Check North-West Side
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            row--;
            col--;
        }

        row = duprow;
        col = dupcol;

        //Check West side
        while (col >= 0) {
            if (board[row][col] == 'Q')
                return false;
            col--;
        }

        row = duprow;
        col = dupcol;

        //Check South-West Side
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q')
                return false;
            col--;
            row++;
        }
        return true;
    }

    public List<String> constructString(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public void dfs(int col, char[][] board, List<List<String>> res) {
        // Terminal Conditions
        if (col == board.length) {
            res.add(constructString(board));
            return;
        }

        // We need to keep on placing queens in current col and move on to the next col if valid position is found
        for (int row = 0; row < board.length; row++) {
            if (isValidPos(board, row, col)) {
                // We have found a valid queen position and will backtrack only here
                board[row][col] = 'Q';
                dfs(col + 1, board, res);
                // Remove original queen placed while backtracking
                board[row][col] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0, board, res);
        return res;
    }
}