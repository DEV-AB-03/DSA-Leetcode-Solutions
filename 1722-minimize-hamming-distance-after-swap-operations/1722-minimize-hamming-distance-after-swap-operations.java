import java.util.*;

class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb)
            return;

        if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        // Step 1: Build connected components
        for (int[] swap : allowedSwaps) {
            dsu.union(swap[0], swap[1]);
        }

        // Step 2: Count source values in each component
        Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);

            groups.putIfAbsent(root, new HashMap<>());
            Map<Integer, Integer> freq = groups.get(root);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        // Step 3: Try matching target values
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            Map<Integer, Integer> freq = groups.get(root);

            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.put(target[i], freq.get(target[i]) - 1);
            } else {
                ans++;
            }
        }

        return ans;
    }
}