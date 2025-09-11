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
    TreeNode prev = null;

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.right);
        dfs(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }

    public void flatten(TreeNode root) {
        // DFS Solution
        dfs(root);
    }
}