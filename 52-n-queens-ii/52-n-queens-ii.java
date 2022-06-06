public class Solution {
    int count = 0;
    
    public int totalNQueens(int n) {
        dfs(0, n, 0, 0, 0);
        return count;
    }
    
    private void dfs(int row, int n, int column, int diag, int antiDiag) {
        if (row == n) {
            ++count;
            return;
        }
        for (int i = 0; i < n; ++i) {
            boolean isColSafe = ((1 << i) & column) == 0;
            boolean isDiagSafe = ((1 << (n - 1 + row - i)) & diag) == 0;
            boolean isAntiDiagSafe = ((1 << (row + i)) & antiDiag) == 0;
            if (isColSafe && isDiagSafe && isAntiDiagSafe) {
                dfs(row + 1, n, (1 << i) | column, (1 << (n - 1 + row - i)) | diag, (1 << (row + i)) | antiDiag);
            }
        }
    }
}