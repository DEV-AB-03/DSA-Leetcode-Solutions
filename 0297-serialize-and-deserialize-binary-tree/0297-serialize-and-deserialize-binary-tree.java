/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = pq.poll();
                if (node == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(node.val).append(",");
                pq.offer(node.left);
                pq.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        // Get Individual Node Values
        String[] values = data.split(",");
        if (values[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> pq = new LinkedList<>();
        pq.offer(root);
        int i = 1;
        while (!pq.isEmpty() && i < values.length) {
            TreeNode parent = pq.poll();
            if (!values[i].equals("#")) {
                //Non Null Nodes
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                pq.offer(left);
            }
            i++;
            if (i < values.length && !values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                pq.offer(right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));