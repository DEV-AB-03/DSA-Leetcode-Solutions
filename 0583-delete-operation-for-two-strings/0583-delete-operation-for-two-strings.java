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

    public int minDistance(String word1, String word2) {
        // We can find LCS of word1 and word2 because that should be untouched as it would not make sense to change them
        // so basically we have to reduce both the words to either one another or reduce them to their LCS
        if (word1.equals(word2)) {
            return 0;
        }

        return word1.length() + word2.length() - 2 * lcs(word1, word2);

    }
}