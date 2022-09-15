class Solution 
{
    public int[] findOriginalArray(int[] changed) 
    {
        //Count Sort Approach
        int n=changed.length;
        if(n%2!=0)
        {
            return new int[]{};
        }
        int[]count=new int[100001];
        for(int i:changed)
        {
            count[i]++;
        }
        
        int[]answer=new int[n/2];
        int idx=0;
        //Now iterate over the array
        for(int i=0;i<100001;i++)
        {
            while(count[i]>0 && i*2<count.length && count[i*2]>0)
            {
                count[i]--;
                count[i*2]--;
                answer[idx]=i;
                idx++;
            }
        }
        for(int i=0;i<100001;i++)
        {
            if(count[i]!=0)
            {
                return new int[]{};
            }
        }
        return answer;
        
    }
}