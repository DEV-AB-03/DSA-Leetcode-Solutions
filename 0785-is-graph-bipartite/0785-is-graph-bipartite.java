class Solution {
    public boolean dfs(int node, int color, int[][] graph, int[] col) {
        col[node] = color;

        for (int neighbor : graph[node]) {
            if (col[neighbor] == -1) {
                if (!dfs(neighbor, 1 - color, graph, col))
                    return false;
            } else if (col[neighbor] == color) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);

        for (int i = 0; i < n; i++) {
            if (col[i] == -1) {
                if (!dfs(i, 0, graph, col))
                    return false;
            }
        }
        return true;
    }
}
