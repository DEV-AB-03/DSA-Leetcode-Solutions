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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) 
    {
        int[] count = new int[10];
        backtrack(root,count);
        return ans;
    }
    void backtrack(TreeNode root,int[] count)
    {
        count[root.val]++;
        if(root.left==null && root.right==null)
        {
            if(checkPalindrome(count)) ans++;
        }
        if(root.left!=null) backtrack(root.left,count);
        if(root.right!=null) backtrack(root.right,count);
        count[root.val]--;
    }
    boolean checkPalindrome(int[] count)
    { // A palindomic string can have one odd occurances of a character, not more than that. 
        int maxOdd = 1;
        for(int I:count)
        {
            if((I&1)!= 0)
                maxOdd--;
            if(maxOdd<0)
                return false;
        }
        return true;
    }
}