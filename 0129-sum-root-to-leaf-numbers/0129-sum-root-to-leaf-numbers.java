/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;

    public void dfs(TreeNode node, String path) {
        path += node.val;
        if (node.left == null && node.right == null) {
            // We have reached leaf node
            int num = Integer.parseInt(path);
            sum += num;
            return;
        }
        // Explore Paths
        if (node.left != null) {
            dfs(node.left, path);
        }
        if (node.right != null) {
            dfs(node.right, path);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return sum;
    }
}