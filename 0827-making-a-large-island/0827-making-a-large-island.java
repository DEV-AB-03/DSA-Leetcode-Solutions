class DSU {
    int[] size;
    int[] parent;

    public DSU(int n) {
        size = new int[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void union(int u, int v) {
        int paru = find(u);
        int parv = find(v);
        if (paru == parv) {
            return;
        }
        if (size[paru] > size[parv]) {
            parent[parv] = paru;
            size[paru] += size[parv];
        } else {
            parent[paru] = parv;
            size[parv] += size[paru];
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
    // DelRow and delCol for neighbors
    private int[] delRow = { -1, 0, 1, 0 };
    private int[] delCol = { 0, 1, 0, -1 };

    /* Helper function to check 
    if a pixel is within boundaries */
    private boolean isValid(int i, int j, int n) {
        // Return false if pixel is invalid
        if (i < 0 || i >= n)
            return false;
        if (j < 0 || j >= n)
            return false;

        // Return true if pixel is valid
        return true;
    }

    public int largestIsland(int[][] grid) {
        int maxSize = 0;
        // DSU
        // First make components of all 1s in the matrix, then go over all zeroes and see max size of island formed
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        // Add Initial Islands
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                // Traverse on all neighbours and mark components
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];
                    if (isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                        // Get the number for node
                        int nodeNo = row * n + col;
                        // Get the number for neighbor
                        int adjNodeNo = nrow * n + ncol;

                        /* Take union of both nodes as they
                        are part of the same island */
                        dsu.union(nodeNo, adjNodeNo);
                    }
                }
            }
        }

        // Now Traverse on all 0's
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                // Traverse on all neighbours
                for (int i = 0; i < 4; i++) {
                    int nrow = row + delRow[i];
                    int ncol = col + delCol[i];
                    if (isValid(nrow, ncol, n) && grid[nrow][ncol] == 1) {
                        // Get the number for neighbor
                        int adjNodeNo = nrow * n + ncol;
                        set.add(dsu.find(adjNodeNo));
                    }
                }
                // Now traverse on all unique parents and add sizes
                int size = 0;
                for (Integer it : set) {
                    size += dsu.size[it];
                }
                // Update maxSize
                maxSize = Math.max(maxSize, size + 1);
            }
        }
        // Edge case
        for (int cellNo = 0; cellNo < n * n; cellNo++) {
            // Keep the answer updated
            maxSize = Math.max(maxSize, dsu.size[dsu.find(cellNo)]);
        }
        return maxSize;
    }
}