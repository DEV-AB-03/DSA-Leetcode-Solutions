class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        // Path Compression
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    public void union(int u, int v) {
        int paru = find(u);
        int parv = find(v);

        if (paru == parv) {
            return;
        } else if (rank[paru] > rank[parv]) {
            parent[parv] = paru;
        } else if (rank[paru] < rank[parv]) {
            parent[paru] = parv;
        } else {
            parent[paru] = parv;
            rank[paru]++;
        }
    }
}

class Solution {
    public int minScore(int n, int[][] roads) {
        // DSU
        // Make a single connected component of 1 and find min among all edges in that component
        DSU dsu = new DSU(n + 1);
        for (int[] road : roads) {
            dsu.union(road[0], road[1]);
        }

        int score = Integer.MAX_VALUE;
        int root = dsu.find(1);
        for (int[] road : roads) {
            if (dsu.find(road[0]) == root) {
                score = Math.min(score, road[2]);
            }
        }
        return score;
    }
}