class Solution {
    public int dfs(String s, int index, char prevColor, int prevColIndex, int[] neededTime, int[][] dp) {
        // Base Case
        if (index >= s.length()) {
            return 0;
        }
        if (dp[index][prevColIndex + 1] != -1) {
            return dp[index][prevColIndex + 1];
        }
        int ans;
        // Explore all Possible Paths
        if (s.charAt(index) != prevColor) {
            // These balloons are not same color. So we simply skip.
            ans = dp[index][prevColIndex] = dfs(s, index + 1, s.charAt(index), index, neededTime, dp);
        } else {
            // Colors are same. So we can either remove previous or remove this
            int removeFirst = neededTime[prevColIndex] + dfs(s, index + 1, s.charAt(index), index, neededTime, dp);
            int removeCurrent = neededTime[index] + dfs(s, index + 1, prevColor, prevColIndex, neededTime, dp);

            ans = Math.min(removeFirst, removeCurrent);
        }
        return dp[index][prevColIndex + 1] = ans;
    }

    public int minCost(String colors, int[] neededTime) {
        // Recursion Solution
        // Memoized Solution
        if (colors.length() == 0)
            return 0;
        int[][] dp = new int[colors.length()][colors.length() + 1];
        for (int i = 0; i < colors.length(); i++) {
            Arrays.fill(dp[i], -1);
        }
        // Start recursion from index 1, with first balloon as previous
        return dfs(colors, 1, colors.charAt(0), 0, neededTime, dp);

    }
}