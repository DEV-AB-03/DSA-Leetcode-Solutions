class Solution 
{
    public int jumpCost(int index,int[]cost,int[]dp)
    {
        //Base Case
        if(index>=cost.length)
        {
            return 0;
        }
        if(dp[index]!=0)
        {
            return dp[index];
        }
        //First Jump
        int left=0;
        int right=0;
        //Second Jump
        right=jumpCost(index+2,cost,dp)+cost[index];
        left=jumpCost(index+1,cost,dp)+cost[index];
        return dp[index]=Math.min(left,right);
    }
    public int minCostClimbingStairs(int[] cost) 
    {
        //Recursion Solution
        int n=cost.length;
        int[]dp=new int[n];
        return Math.min(jumpCost(0,cost,dp),jumpCost(1,cost,dp));
    }
}