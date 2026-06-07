class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> mp = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();

        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];

            mp.putIfAbsent(parent, new TreeNode(parent));
            mp.putIfAbsent(child, new TreeNode(child));

            if (isLeft == 1)
                mp.get(parent).left = mp.get(child);
            else
                mp.get(parent).right = mp.get(child);

            children.add(child);
        }

        for (int val : mp.keySet()) {
            if (!children.contains(val))
                return mp.get(val);
        }

        return null;
    }
}