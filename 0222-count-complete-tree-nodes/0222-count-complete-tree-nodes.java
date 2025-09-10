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
    public int getRightHeight(TreeNode node) {
        int height = 0;
        while (node.right != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    public int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    public int getNumOfNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root);
        int rh = getRightHeight(root);
        if (lh == rh) {
            return (2 << lh) - 1;
        } else {
            return 1 + getNumOfNodes(root.left) + getNumOfNodes(root.right);
        }
    }

    public int countNodes(TreeNode root) {
        return getNumOfNodes(root);
    }
}