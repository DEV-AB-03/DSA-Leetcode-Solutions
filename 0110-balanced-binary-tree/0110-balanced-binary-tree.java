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
    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        // Empty tree is always balanced
        if (root == null) {
            return true;
        }
        int depthLeft = depth(root.left);
        int depthRight = depth(root.right);
        return Math.abs(depthLeft - depthRight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}