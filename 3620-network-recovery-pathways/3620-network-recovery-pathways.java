class Solution {

    private long dfs(int node, int n, List<List<int[]>> adj, int mid, long[] memo) {
        if (node == n - 1) {
            return 0;
        }
        if (memo[node] != -1) {
            return memo[node];
        }

        long res = Long.MAX_VALUE / 2; // sentinel: unreachable
        for (int[] neighbour : adj.get(node)) {
            int v = neighbour[0];
            int w = neighbour[1];
            if (w < mid)
                continue; // filter by current edge-cost threshold

            long sub = dfs(v, n, adj, mid, memo);
            if (sub < Long.MAX_VALUE / 2) {
                res = Math.min(res, w + sub);
            }
        }

        return memo[node] = res;
    }

    private List<List<int[]>> buildGraph(int n, int[][] edges, boolean[] online) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            // skip if either endpoint offline (0 and n-1 are guaranteed online, so this
            // correctly only filters actual intermediate offline nodes)
            if (!online[u] || !online[v])
                continue;
            adj.get(u).add(new int[] { v, w });
        }
        return adj;
    }

    private boolean pathExists(int n, List<List<int[]>> adj, int mid, long k) {
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        long minCost = dfs(0, n, adj, mid, memo);
        return minCost <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> adj = buildGraph(n, edges, online);

        // find max possible edge weight to bound the search properly
        int high = 0;
        for (int[] e : edges)
            high = Math.max(high, e[2]);
        int low = 0;
        int ans = -1;

        // must check mid=0 works at all, otherwise no valid path exists whatsoever
        if (!pathExists(n, adj, 0, k)) {
            return -1;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (pathExists(n, adj, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}