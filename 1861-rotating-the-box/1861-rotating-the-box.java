class Solution {

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] result = new char[n][m];

        // Create the transpose of the input grid in `result`
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = box[j][i];
            }
        }

        // Reverse each row in the transpose grid to complete the 90° rotation
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m / 2; j++) {
                char temp = result[i][j];
                result[i][j] = result[i][m - 1 - j];
                result[i][m - 1 - j] = temp;
            }
        }

        // Apply gravity to let stones fall to the lowest possible empty cell in each column
        for (int j = 0; j < m; j++) {
            int lowestRowWithEmptyCell = n - 1;
            // Process each cell in column `j` from bottom to top
            for (int i = n - 1; i >= 0; i--) {
                // Found a stone - let it fall to the lowest empty cell
                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[lowestRowWithEmptyCell][j] = '#';
                    lowestRowWithEmptyCell--;
                }
                // Found an obstacle - reset `lowestRowWithEmptyCell` to the row directly above it
                if (result[i][j] == '*') {
                    lowestRowWithEmptyCell = i - 1;
                }
            }
        }
        return result;
    }
}
