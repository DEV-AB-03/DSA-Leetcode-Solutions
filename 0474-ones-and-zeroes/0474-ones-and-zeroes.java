class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return dfs(0, m, n, strs);
    }

    public int dfs(int index, int m, int n, String[] strs) {
        // Base Case: reached the end of the array
        if (index == strs.length) {
            return 0;
        }

        // Count zeros and ones in the current string
        int[] count = countZerosOnes(strs[index]);
        int zeros = count[0];
        int ones = count[1];

        // Option 1: skip current string
        int skip = dfs(index + 1, m, n, strs);

        // Option 2: include current string (if possible)
        int include = 0;
        if (m >= zeros && n >= ones) {
            include = 1 + dfs(index + 1, m - zeros, n - ones, strs);
        }

        // Return the maximum subset size from both choices
        return Math.max(include, skip);
    }

    // Helper function to count 0's and 1's
    private int[] countZerosOnes(String s) {
        int zeros = 0, ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
            else ones++;
        }
        return new int[]{zeros, ones};
    }
}
