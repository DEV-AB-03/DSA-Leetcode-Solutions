/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || p == root || q == root)        //base case
        return root;
      
      TreeNode right = lowestCommonAncestor(root.right , p , q);
      TreeNode left = lowestCommonAncestor(root.left , p , q); 
      
      if(right == null) return left;                   //results
      if(left == null) return right;
      
      else return root;                                //both left and right are not null, we found our result
    }
}