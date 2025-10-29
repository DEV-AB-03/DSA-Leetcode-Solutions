class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // BFS Approach -> Water Ripple Effect
        // Djikstra Algorithm

        // Create a dist matrix
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) 1e9);

        // Create a Priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // Create adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }

        // Initial Steps
        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        // Start BFS Traversal
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int time = pair.time;

            // Explore all paths
            for (Pair neighb : adj.get(node)) {
                int neighbNode = neighb.node;
                int nextTime = neighb.time;
                if (dist[neighbNode] > time + nextTime) {
                    dist[neighbNode] = time + nextTime;
                    pq.offer(new Pair(neighbNode, time + nextTime));
                }
            }
        }
        int minTimeToReachAll = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) 1e9) {
                return -1;
            } else {
                minTimeToReachAll = Math.max(minTimeToReachAll, dist[i]);
            }
        }
        return minTimeToReachAll;
    }
}