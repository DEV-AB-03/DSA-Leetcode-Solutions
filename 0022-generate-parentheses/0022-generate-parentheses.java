class Solution {
    public void dfs(String s, int open, int close, int n, List<String> ans) {
        //Base Condition
        if (s.length() == 2 * n) {
            // check if valid
            if (open == close) {
                ans.add(s);
            }
            return;
        }

        // Try out all ways
        if (open < n) {
            // For starting string with open bracket
            dfs(s + "(", open + 1, close, n, ans);
        }
        if (close < open) {
            // Add closing bracket
            dfs(s + ")", open, close + 1, n, ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        // Recursion
        List<String> ans = new ArrayList<>();
        dfs("", 0, 0, n, ans);
        return ans;
    }
}