class DSU {
    int[] rank;
    int[] parent;

    public DSU(int n) {
        rank = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }
        return parent[u];
    }

    public void union(int u, int v) {
        int paru = find(u);
        int parv = find(v);

        if (paru == parv)
            return;

        if (rank[paru] > rank[parv]) {
            parent[parv] = paru;
        } else if (rank[paru] < rank[parv]) {
            parent[paru] = parv;
        } else {
            parent[paru] = parv;
            rank[parv]++;
        }
    }
}

class Solution {

    public boolean left(int type) {
        return type == 1 || type == 3 || type == 5;
    }

    public boolean right(int type) {
        return type == 1 || type == 4 || type == 6;
    }

    public boolean up(int type) {
        return type == 2 || type == 5 || type == 6;
    }

    public boolean down(int type) {
        return type == 2 || type == 3 || type == 4;
    }

    public boolean hasValidPath(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        DSU dsu = new DSU(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int u = i * m + j;
                int type = grid[i][j];

                // Right neighbour
                if (j + 1 < m && right(type) && left(grid[i][j + 1])) {
                    int v = i * m + (j + 1);
                    dsu.union(u, v);
                }

                // Down neighbour
                if (i + 1 < n && down(type) && up(grid[i + 1][j])) {
                    int v = (i + 1) * m + j;
                    dsu.union(u, v);
                }
            }
        }

        return dsu.find(0) == dsu.find(n * m - 1);
    }
}