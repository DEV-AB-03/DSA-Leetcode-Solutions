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
    public void dfs(TreeNode node, List<String> paths, String path) {
        // Add current node in path
        path += node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        // Explore paths
        if (node.left != null) {
            dfs(node.left, paths, path + "->");
        }
        if (node.right != null) {
            dfs(node.right, paths, path + "->");
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }
}