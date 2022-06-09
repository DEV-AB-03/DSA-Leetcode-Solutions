class Solution 
{
    public int minpath(int i,int j,int[][]grid,int[][]dp)
    {
        if(i==0 && j==0)
        {
            return grid[0][0];
        }
        if(i<0 || j<0)
        {
            return 10000;
        }
        if(dp[i][j]!=0)
        {
            return dp[i][j];
        }
        int up=grid[i][j]+minpath(i-1,j,grid,dp);
        int left=grid[i][j]+minpath(i,j-1,grid,dp);
        
        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) 
    {
        //SIMILAR TO DP ON GRIDS+HOUSE ROBBER
        //DP
        int m=grid.length;
        int n=grid[0].length;
        int[][]dp=new int[m][n];
        return minpath(m-1,n-1,grid,dp);
    }
}