class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        // Find LCS of both words as they need to be added in the answer string. Then add characters as they appear in the strings in front and or after lcs.

        // So need to track start and end idx of LCS In both Strings
        // Print LCS by following tabulation method
        // Get the lengths of both strings
        int n = str1.length();
        int m = str2.length();

        // Create a 2D DP array to store lengths of LCS
        int[][] dp = new int[n + 1][m + 1];

        // Fill the DP array using bottom-up tabulation
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                // If characters match, add 1 to diagonal value
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }

                // Otherwise, take the max from left or top cell
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Initialize StringBuilder to build the result
        StringBuilder ans = new StringBuilder();

        // Start from bottom-right corner of the table
        int i = n, j = m;

        // Traverse the table in reverse to build supersequence
        while (i > 0 && j > 0) {

            // If characters match, add to answer and move diagonally
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                ans.append(str1.charAt(i - 1));
                i--;
                j--;
            }

            // Move in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(str1.charAt(i - 1));
                i--;
            } else {
                ans.append(str2.charAt(j - 1));
                j--;
            }
        }

        // Append remaining characters from s1
        while (i > 0) {
            ans.append(str1.charAt(i - 1));
            i--;
        }

        // Append remaining characters from s2
        while (j > 0) {
            ans.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result since it was built backwards
        return ans.reverse().toString();
    }
}