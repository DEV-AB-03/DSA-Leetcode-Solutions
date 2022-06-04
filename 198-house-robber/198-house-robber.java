class Solution 
{
    public int maxrob(int index,int[]nums,int[]dp)
    {
        if(index==0)
        {
            return nums[index];
        }
        if(index<0)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        
        int pick=nums[index]+maxrob(index-2,nums,dp);
        int notpick=0+maxrob(index-1,nums,dp);
        
        return dp[index]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) 
    {
        //Similar to maximum sum of non adjacent elements
        //Pick and Dont pick concept
        int n=nums.length;
        int[]dp=new int[n];
        Arrays.fill(dp,-1);
        return maxrob(n-1,nums,dp);
    }
}