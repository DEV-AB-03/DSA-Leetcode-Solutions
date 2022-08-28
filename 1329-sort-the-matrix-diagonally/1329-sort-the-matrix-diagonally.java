class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        
        HashMap<Integer, PriorityQueue<Integer> > diagonals = new HashMap<>();
        
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(diagonals.containsKey(i-j))
                {
                    diagonals.get(i-j).add(mat[i][j]);
                }
                else
                {
                    PriorityQueue<Integer> pq = new PriorityQueue<>();
                    pq.add(mat[i][j]);
                    
                    diagonals.put(i-j, pq);
                }   
            }
        }
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                mat[i][j] = diagonals.get(i-j).poll();
            }
        }
        
        return mat;
    }
}