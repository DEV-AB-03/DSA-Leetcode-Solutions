class Solution {
    public void dfs(int index, int n, String s, List<String> str) {
        // Base Case
        if (index == n) {
            str.add(s);
            return;
        }

        // Try out all possibilities
        if (s.isEmpty() || s.charAt(s.length() - 1) != 'a') {
            // Add a
            dfs(index + 1, n, s + 'a', str);

        }
        if (s.isEmpty() || s.charAt(s.length() - 1) != 'b') {
            // Add b
            dfs(index + 1, n, s + 'b', str);

        }
        if (s.isEmpty() || s.charAt(s.length() - 1) != 'c') {
            // Add c
            dfs(index + 1, n, s + 'c', str);
        }
    }

    public String getHappyString(int n, int k) {
        // Backtracking
        List<String> str = new ArrayList<>();
        dfs(0, n, "", str);

        // Sort the list
        if (str.size() < k) {
            return "";
        }

        // Sort the list and return kth string
        Collections.sort(str);
        return str.get(k - 1);
    }
}