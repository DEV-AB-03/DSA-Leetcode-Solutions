class Solution 
{
    public int numberOfWeakCharacters(int[][] properties) 
    {
        //Stack Approach
        //We have to Maintain the max value so far so we do stack
        Arrays.sort(properties,new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0]!=b[0]) return a[0]-b[0];
                else return b[1]-a[1];
            }
        });
        int n=properties.length;
        int max=properties[n-1][1]; //So far this is the max value after sorting
        int weak=0;
        for(int i=n-2;i>=0;i--)
        {
            if(properties[i][1]<max)
            {
                weak++;
            }
            max=Math.max(max,properties[i][1]);
        }
        return weak;
        
        
    }
}