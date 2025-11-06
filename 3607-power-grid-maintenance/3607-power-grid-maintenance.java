import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) adj.add(new ArrayList<>());

        for (int[] edge : connections) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Step 2: Find connected components
        int[] component = new int[c + 1];
        int compId = 0;
        boolean[] vis = new boolean[c + 1];
        for (int i = 1; i <= c; i++) {
            if (!vis[i]) {
                compId++;
                dfs(i, adj, vis, component, compId);
            }
        }

        // Step 3: Create a map from componentId -> priority queue of online nodes
        Map<Integer, PriorityQueue<Integer>> compHeap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            compHeap.putIfAbsent(component[i], new PriorityQueue<>());
            compHeap.get(component[i]).offer(i);
        }

        // Step 4: Track online/offline status
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        // Step 5: Process queries
        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int node = q[1];
            int comp = component[node];

            if (type == 1) {
                PriorityQueue<Integer> pq = compHeap.get(comp);
                
                // Clean offline nodes from heap top
                while (!pq.isEmpty() && !online[pq.peek()]) pq.poll();

                if (online[node]) {
                    result.add(node);  // node itself is online
                } else if (!pq.isEmpty()) {
                    result.add(pq.peek()); // smallest online in the component
                } else {
                    result.add(-1); // all offline
                }

            } else {
                // Mark node as offline
                online[node] = false;
            }
        }

        // Step 6: Convert to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = result.get(i);
        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis, int[] component, int compId) {
        vis[node] = true;
        component[node] = compId;
        for (int nei : adj.get(node)) {
            if (!vis[nei]) dfs(nei, adj, vis, component, compId);
        }
    }
}
