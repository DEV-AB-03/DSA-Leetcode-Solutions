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
    public boolean checkIfSymmetric(TreeNode nodeleft,TreeNode noderight)
    {
        if(nodeleft==null && noderight==null)
        {
            return true;
        }
        if(nodeleft==null || noderight==null)
        {
            return false;
        }
        if(nodeleft.val!=noderight.val)
        {
            return false;
        }
        //Retun combined boolean value on traversal
        return checkIfSymmetric(nodeleft.right,noderight.left) && checkIfSymmetric(nodeleft.left,noderight.right);
    }
    public boolean isSymmetric(TreeNode root) 
    {
        if(root==null)
        {
            return false;
        }
        return checkIfSymmetric(root.left,root.right);
    }
}