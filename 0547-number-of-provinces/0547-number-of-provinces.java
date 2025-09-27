class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        // Mark this node as visited
        vis[node] = true;

        // Depth Search on Its connections
        for (Integer neighbour : adj.get(node)) {
            if (!vis[neighbour]) {
                dfs(neighbour, adj, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // DFS Approach 1
        // Solve with Adjacency List
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = -0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                // We have an edge from i->j
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int provinces = 0;
        int nodes = isConnected.length;
        boolean[] vis = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            if (!vis[i]) {
                provinces++;
                dfs(i, adj, vis);
            }
        }
        return provinces;
    }
}