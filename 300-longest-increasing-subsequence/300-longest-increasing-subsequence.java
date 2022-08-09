class Solution 
{
    public int maxLength(int index,int[]a,int prev_index,int[][]dp)
    {
        //Base Case
        if(index>=a.length)
        {
            return 0;
        }
        if(dp[index][prev_index+1]!=-1)
        {
            return dp[index][prev_index+1];
        }
        //Recursion Calls
        int nottake=0+maxLength(index+1,a,prev_index,dp);
        
        int take=0;
        if(prev_index==-1 || a[index]>a[prev_index])
        {
            take=1+maxLength(index+1,a,index,dp);
        }
        int len=Math.max(take,nottake);
        return dp[index][prev_index+1]=len;
    }

    public int lengthOfLIS(int[] nums) 
    {
        int[][]dp=new int[nums.length][nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return maxLength(0,nums,-1,dp);
    }
}