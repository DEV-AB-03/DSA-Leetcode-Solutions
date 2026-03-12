class DSU {
    int[] rank;
    int[] parent;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            rank[i] = 0;
            parent[i] = i;
        }
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

    public int find(int u) {
        // Path Compression
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }
}

class Solution {
    public int swimInWater(int[][] grid) {
        // DSU with Kruskal's Algorithm
        // We move from cell to cell and add edges in a list and then sort it according to weight
        // Add edges in sorted way according to weights
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int node = i * n + j;

                // Check for in bounds for right and down
                if (i + 1 < n) {
                    // Down
                    int down = (i + 1) * n + j;
                    int weight = Math.max(grid[i + 1][j], grid[i][j]);
                    edges.add(new int[] { node, down, weight });
                }
                if (j + 1 < n) {
                    // Right
                    int right = i * n + (j + 1);
                    int weight = Math.max(grid[i][j + 1], grid[i][j]);
                    edges.add(new int[] { node, right, weight });
                }
            }
        }

        // Sort Edges
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int start = 0;
        int end = n * n - 1;
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            dsu.union(u, v);

            if (dsu.find(start) == dsu.find(end)) {
                return w;
            }
        }

        return 0;

    }
}