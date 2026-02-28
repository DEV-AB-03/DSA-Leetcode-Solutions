class DSU {
    HashMap<Integer, Integer> parent = new HashMap<>();

    public int find(int x) {
        parent.putIfAbsent(x, x);
        // Find Super Parent
        // Path Compression
        if (parent.get(x) != x) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(int x, int y) {
        parent.put(find(x), find(y));
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        // DSU
        // In each and every distinct component, we can not remove 1 stone. So the formula is number of stones - number of components
        // Consider each row and column as a node and if stones are in it then they can be considered part of the same group/component
        DSU dsu = new DSU();
        for (int[] stone : stones) {
            dsu.union(stone[0], stone[1] + 10001);
        }

        // Count Unique Components
        Set<Integer> components = new HashSet<>();
        for (int[] stone : stones) {
            components.add(dsu.find(stone[0]));
        }
        return stones.length - components.size();
    }
}