class Solution 
{
    public double champagneTower(int poured, int query_row, int query_glass) 
    {
         double dp[][]=new double[query_row+1][query_row+2];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<=i;j++)
            {
                if(i==0 && j==0)
                {
                    dp[i][j]=poured;
                }
                else
                {
                    double top=0.0;
                    double topLeft=0.0;
                    if(i-1>=0 && dp[i-1][j]>1)
                    {
                        top=(dp[i-1][j]-1)/2;
                    }
                    if(i-1>=0 && j-1>=0 && dp[i-1][j-1]>1)
                    {
                        topLeft=(dp[i-1][j-1]-1)/2;
                    }
                   
                    dp[i][j]=top+topLeft;
                }
            }
        }
        if(dp[query_row][query_glass]>1){
            return 1;
        }
        return dp[query_row][query_glass];
    }
}