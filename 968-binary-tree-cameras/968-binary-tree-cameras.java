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
class Solution 
{
    public int minCameraCover(TreeNode root) {
	var covered = new HashSet<TreeNode>();
	covered.add(null);
	return install(null, root, covered);
}

private int install(TreeNode parent, TreeNode node, Set<TreeNode> covered) {
	if (node == null)
		return 0;

	var count = install(node, node.left, covered) + 
				install(node, node.right, covered);

	if (parent == null && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right)) {
		count++;
		covered.add(node);
		covered.add(parent);
		covered.add(node.left);
		covered.add(node.right);
	}
	return count;
}
}