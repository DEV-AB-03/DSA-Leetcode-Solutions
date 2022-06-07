class Solution 
{
    public int countmoves(int i,int j,int[][]dp)
    {
        if(i==0 && j==0)
        {
            return 1;
        }
        //If path goes out of bounds
        if(i<0 || j<0)
        {
            return 0;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        //Now since we are going from last cell to start cell we can go either up or left
        int up=countmoves(i-1,j,dp);
        int left=countmoves(i,j-1,dp);
        
        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) 
    {
       //DP Solution
        int[][]dp=new int[m][n];
        return countmoves(m-1,n-1,dp);
    }
}