class Solution {

    Integer[][][] dp;

    public int minimumDistance(String word) {

        int n = word.length();

        // dp[index][finger1][finger2]
        // +1 because we use -1 as "not used yet"
        dp = new Integer[n][27][27];

        return solve(word, 0, -1, -1);
    }

    private int solve(String word, int i, int f1, int f2) {

        if (i == word.length())
            return 0;

        int f1Idx = f1 + 1;
        int f2Idx = f2 + 1;

        if (dp[i][f1Idx][f2Idx] != null) {
            return dp[i][f1Idx][f2Idx];
        }

        int curr = word.charAt(i) - 'A';

        // Option 1: use finger1
        int cost1 = dist(f1, curr) + solve(word, i + 1, curr, f2);

        // Option 2: use finger2
        int cost2 = dist(f2, curr) + solve(word, i + 1, f1, curr);

        return dp[i][f1Idx][f2Idx] = Math.min(cost1, cost2);
    }

    private int dist(int a, int b) {
        if (a == -1)
            return 0;

        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}