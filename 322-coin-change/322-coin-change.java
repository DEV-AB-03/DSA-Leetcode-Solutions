class Solution 
{
    public int countCoins(int index,int target,int[]a,int[][]dp)
    {
        //Base Case
        if(index==0)
        {
            if(target%a[index]==0)
            {
                return target/a[index];
            }
            else
            {
                return (int)1e9;
            }
        }
        if(dp[index][target]!=-1)
        {
            return dp[index][target];
        }
        //Not take condition
        int nottake=0+countCoins(index-1,target,a,dp);
        //Take Condtition
        int take=Integer.MAX_VALUE;
        if(a[index]<=target)
        {
            take=1+countCoins(index,target-a[index],a,dp);
        }
        
        return dp[index][target]=Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) 
    {
        int n=coins.length;
        int[][]dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int count=countCoins(n-1,amount,coins,dp);
        if(count==(int)1e9)
        {
            return -1;
        }
        return count;
    }
}