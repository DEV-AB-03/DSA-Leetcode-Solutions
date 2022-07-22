class Solution 
{
    public int[][] merge(int[][] intervals) 
    {
        //Sorting Approach
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        ArrayList<int[]>list=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        int i=1;
        int n=intervals.length;
        while(i<n)
        {
            int s=intervals[i][0];
            int e=intervals[i][1];
            if(s<=end)
            {
                end=Math.max(end,e);
            }
            else
            {
                list.add(new int[]{start,end});
                start=s;
                end=e;
            }
            i++;
        }
        //The Last one will remain in this approach
        //So we addd the last to our list
        list.add(new int[]{start,end});
        return list.toArray(new int[0][]);
                                                
    }
}