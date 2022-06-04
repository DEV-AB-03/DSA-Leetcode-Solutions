class Solution {
    List<List<String>> res = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        queens(board, 0, n);
        return res;
    }
    
    private void queens(int[][] board, int col, int n) {
        
        if(col >= n) {
            List<String> curr = createConfig(board, n);
            res.add(curr);
            return;
        }
        
        for(int i=0; i<n; i++) {
            if(isValid(i, col, board, n)) {
			    // crucial point for all backtracking problems; place a marker and hope it reaches the end goal
                board[i][col] = 1;
				
				// try with the current configuration of the board
                queens(board, col + 1, n);
				
				// reset the board aka backtrack
                board[i][col] = 0;
            }
        }
    }
    
    private List<String> createConfig(int[][] board, int n) { 
        List<String> curr = new ArrayList<String>();
        
        for(int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++) {
                if(board[i][j] == 1) {
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            
            curr.add(sb.toString());
        }
        
        return curr;
    }
    
    private boolean isValid(int row, int col, int[][] board, int n) {
        // check row
        for(int i=0; i<n; i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }
        // check col
        for(int i=0; i<n; i++) {
            if(board[i][col] == 1) {
                return false;
            }
        }
        // check diagonals
        
        // top left
        int i = row;
        int j = col;
        while(i>=0 && j>=0) {
            if(board[i][j] == 1) {
                return false;
            }
            i--; j--;
        }
        
        
        // top right
        i = row;
        j = col;
        while(i>=0 && j<n) {
            if(board[i][j] == 1) {
                return false;
            }
            i--; j++;
        }
        
        // bottom left
        i = row;
        j = col;
        while(i<n && j>=0) {
            if(board[i][j] == 1) {
                return false;
            }
            i++; j--;
        }
        
        // bottom right
        i = row;
        j = col;
        while(i<0 && j<0) {
            if(board[i][j] == 1) {
                return false;
            }
            i++; j++;
        }
        
        return true;
    }
}