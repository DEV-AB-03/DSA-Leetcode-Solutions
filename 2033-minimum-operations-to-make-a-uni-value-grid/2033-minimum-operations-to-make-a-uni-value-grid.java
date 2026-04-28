class Solution {
    public int minOperations(int[][] grid, int x) {
        int opr = 0;
        // Sort the numbers and find median
        int m = grid.length;
        int n = grid[0].length;

        // FInd Median
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int median = list.get((m * n) / 2);

        // Iterate over all nums and see if we can reduce it to median
        for (int num : list) {
            if (num % x != median % x) {
                return -1;
            } else {
                opr += Math.abs(median - num) / x;
            }
        }
        return opr;

    }
}