class Pair {
    int node;
    int time;

    public Pair(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
        // Define modulo value
        int mod = (int) (1e9 + 7);
        int count = 0;
        // Djikstra Variation

        // Dist matrix
        int[] dist = new int[n];

        Arrays.fill(dist, (int) 1e9);

        // Create a Ways Array
        int[] ways = new int[n];
        Arrays.fill(ways, 0);

        // Create Graph
        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        // Create a priority Queue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.time - b.time);

        // Initial Steps
        dist[0] = 0;
        ways[0] = 1;
        pq.offer(new Pair(0, 0));

        // Start BFS Traversal
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int node = pair.node;
            int time = pair.time;

            // Explore all neighbouring nodes
            for (Pair neighb : adj.get(node)) {
                int neighbNode = neighb.node;
                int neighbTime = neighb.time;
                if (time + neighbTime < dist[neighbNode]) {
                    // First time we encounter shortest time to reavh this node
                    dist[neighbNode] = time + neighbTime;
                    pq.offer(new Pair(neighbNode, (int) time + neighbTime));
                    ways[neighbNode] = ways[node];
                } else if (time + neighbTime == dist[neighbNode]) {
                    // Similar shortest distance achieved. Add the value to the existing number of ways count.
                    ways[neighbNode] = (ways[neighbNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1] % mod;
    }
}