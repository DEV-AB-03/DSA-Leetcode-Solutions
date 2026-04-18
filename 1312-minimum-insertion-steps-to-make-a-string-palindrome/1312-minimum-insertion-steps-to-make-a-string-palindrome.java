class Solution {
    public int dfs(int idx1, int idx2, String s1, String s2, int[][] dp) {
        if (idx1 == s1.length() || idx2 == s2.length()) {
            return 0;
        }
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }
        // Try Out all Ways
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return 1 + dfs(idx1 + 1, idx2 + 1, s1, s2, dp);
        }
        int skipFirst = dfs(idx1 + 1, idx2, s1, s2, dp);
        int skipSecond = dfs(idx1, idx2 + 1, s1, s2, dp);

        return dp[idx1][idx2] = Math.max(skipFirst, skipSecond);
    }

    public int lcs(String s1, String s2) {
        // memoization
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, s1, s2, dp);
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();

    }

    public int minInsertions(String s) {
        // Find LCS of S and Reverse of S and answer will be s.length() - LCS(s, rev(s))
        return s.length() - lcs(s, reverse(s));
    }
}