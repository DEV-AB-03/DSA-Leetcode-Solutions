class Solution 
{
    public static int dfs(char[][]grid,int i,int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0')
        {
            return 0;
        }
        //We are inside the grid at valid positions
        //Set the current cell to 0
        grid[i][j]='0';
        
        //Make recursive Calls
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        
        return 1;
    }
    public int numIslands(char[][] grid) 
    {
        //DFS APPROACH
        int m=grid.length;
        int n=grid[0].length;
        if(grid==null || m==0)
        {
            return 0;
        }
        int numIslands=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                char ch=grid[i][j];
                if(ch=='1')
                {
                    numIslands+=dfs(grid,i,j);
                }
            }
        }
        return numIslands;
    }
}