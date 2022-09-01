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
    int countGoodNodes=0;
    public void dfs(TreeNode root,int maxValueSeenSoFar)
    {
        //Base Case
        if(root==null)
        {
            return;
        }
        
        
        //Calculations
        if(root.val>=maxValueSeenSoFar)
        {
            countGoodNodes++;
            //Update the maxVal
            maxValueSeenSoFar=root.val;
        }
        //Recursion Call
        dfs(root.left,maxValueSeenSoFar);
        dfs(root.right,maxValueSeenSoFar);
        
    }
    public int goodNodes(TreeNode root) 
    {
        if(root==null)
        {
            return 0;
        }
        dfs(root,root.val);
        return countGoodNodes;
        
    }
}