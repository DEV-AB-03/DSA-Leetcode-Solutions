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
    List<Integer> left;
    int ans = 0;
    public int widthOfBinaryTree(TreeNode root) {
        left = new ArrayList<>();
        find(root, 0, 1);
        return ans;
    }
    
    public void find(TreeNode root, int pos, int height){
        if(root == null)
            return;
        if(left.size() < height)
            left.add(pos);
        ans = Math.max(ans, pos - left.get(height - 1) + 1);
        find(root.left, pos * 2, height + 1);
        find(root.right, pos * 2 + 1, height + 1);
    }
}