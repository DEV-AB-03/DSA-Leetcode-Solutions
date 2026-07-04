class Solution {
    int score = Integer.MAX_VALUE;

    public void dfs(int node, List<List<int[]>> adj, boolean[] vis) {
        //Mark Current Node
        vis[node] = true;

        for (int[] nodes : adj.get(node)) {
            int neighbnode = nodes[0];
            int weight = nodes[1];

            score = Math.min(score, weight);

            if (!vis[neighbnode]) {
                dfs(neighbnode, adj, vis);
            }
        }
    }

    public int minScore(int n, int[][] roads) {
        // DFS
        // Both 1 and n belong to the same component as atleast one path is present
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());
        for (int[] r : roads) {
            adj.get(r[0]).add(new int[] { r[1], r[2] });
            adj.get(r[1]).add(new int[] { r[0], r[2] });
        }

        boolean[] vis = new boolean[n + 1];
        dfs(1, adj, vis);

        return score;

    }
}