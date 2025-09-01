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
    public int backtrack(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // Expore all Possible Paths
        int left = backtrack(node.left);
        int right = backtrack(node.right);

        return 1 + Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        return backtrack(root);
    }
}