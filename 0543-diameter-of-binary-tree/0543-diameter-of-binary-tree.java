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
    int diameter = 0;

    public void calculateMaxPathLength(TreeNode node) {
        int maxLength = Integer.MIN_VALUE;
        // Brute Force - Using depth DFS Function
        if (node == null) {
            return;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);

        calculateMaxPathLength(node.left);
        calculateMaxPathLength(node.right);
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getDepth(node.left), getDepth(node.right));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        calculateMaxPathLength(root);
        return diameter;
    }
}