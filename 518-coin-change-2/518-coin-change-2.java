class Solution 
{
    public int countWays(int index,int target,int []a,int[][]dp)
    {
        //Base Case
        if(index==0)
        {
            if(target%a[index]==0)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        if(index<0)
        {
            return 0;
        }
        if(dp[index][target]!=-1)
        {
            return dp[index][target];
        }
        //Recursion Calls
        //Not take condition
        int nottake=0+countWays(index-1,target,a,dp);
        
        //Take condition
        int take=0;
        if(a[index]<=target)
        {
            take=countWays(index,target-a[index],a,dp);
        }
        //Return total ways
        return dp[index][target]=take+nottake;
    }
    public int change(int amount, int[] coins)
    {
        //Memoization Solution
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return countWays(n-1,amount,coins,dp);
    }
}