class Solution {
    String smallest = "";

    public String addAtoS(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int val = ((arr[i] - '0') + a) % 10;
            arr[i] = (char) ('0' + val);
        }
        return new String(arr);
    }

    public String rotateByB(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }

    public void dfs(String s, int a, int b, Set<String> vis) {
        if (vis.contains(s)) {
            return;
        }
        vis.add(s);
        // Check if current modified string is lexicographically smallest
        // Update smallest string
        if (smallest.isEmpty() || s.compareTo(smallest) < 0) {
            smallest = s;
        }
        // Try out all Possible Cases
        dfs(addAtoS(s, a), a, b, vis);

        dfs(rotateByB(s, b), a, b, vis);

    }

    public String findLexSmallestString(String s, int a, int b) {
        // DFS Approach
        // This is essentially a graphs problem where each node is a string
        Set<String> vis = new HashSet<>();
        smallest = s;
        dfs(s, a, b, vis);
        return smallest;
    }
}