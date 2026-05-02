class Solution {
    public int dfs(int pos, String num, boolean tight, boolean hasDiff, Integer[][][] dp) {
        // Base Case
        if (pos == num.length()) {
            return hasDiff ? 1 : 0;
        }

        int t = tight ? 1 : 0;
        int d = hasDiff ? 1 : 0;

        if (dp[pos][t][d] != null)
            return dp[pos][t][d];

        int limit = tight ? num.charAt(pos) - '0' : 9;
        int count = 0;

        // Try all digits
        for (int digit = 0; digit <= limit; digit++) {

            // Skip invalid digits
            if (digit == 3 || digit == 4 || digit == 7)
                continue;

            boolean nextTight = tight && (digit == limit);
            boolean nextHasDiff = hasDiff;

            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                nextHasDiff = true;
            }

            count += dfs(pos + 1, num, nextTight, nextHasDiff, dp);
        }

        return dp[pos][t][d] = count;
    }

    public int rotatedDigits(int n) {
        String num = String.valueOf(n);
        Integer[][][] dp = new Integer[num.length()][2][2];

        return dfs(0, num, true, false, dp); // FIXED
    }
}