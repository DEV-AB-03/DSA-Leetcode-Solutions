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
    public void findPath(TreeNode root,int targetSum,List<List<Integer>>paths,ArrayList<Integer>path)
    {
        //Base Case
        if(root==null)
        {
            return;
        }
        //If we are at some other node we add it to the list
        path.add(root.val);
        
        //We found a leaf node and check conditions     
        if(root.left==null && root.right==null)
        {
            if(targetSum-root.val==0)
            {
                paths.add(new ArrayList<>(path));
                return;
            }
        }
        
        //Else we will further do recursion calls
        if(root.left!=null)
        {
            findPath(root.left,targetSum-root.val,paths,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null)
        {
            findPath(root.right,targetSum-root.val,paths,path);
            path.remove(path.size()-1);
        }
        
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) 
    {
        //BackTracking Question
        List<List<Integer>>paths=new ArrayList<>();
        ArrayList<Integer>path=new ArrayList<>();
        findPath(root,targetSum,paths,path);
        
        
        
        
        
        
        return paths;
    }
}