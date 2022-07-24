class Solution 
{
   public int equalPairs(int[][] grid) {
    
    int res = 0;
    
    HashMap<String, Integer> x = new HashMap<>();
    for(int i=0; i<grid.length; i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<grid[0].length; j++){
            sb.append(grid[i][j]);
            sb.append(',');
        }
        String curr = sb.toString();
        x.put(curr, x.getOrDefault(curr, 0) +1);
    }
    
    for(int i=0; i<grid.length; i++){
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<grid[0].length; j++){
            sb.append(grid[j][i]);
            sb.append(',');
        }
        String curr = sb.toString();
        if(x.containsKey(curr))
            res += x.get(curr);
    }
    
    return res;
}
}