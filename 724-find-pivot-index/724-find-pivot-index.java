class Solution 
{
    public int pivotIndex(int[] nums)
    {
        int n=nums.length;
        int start_sum=0;
        for(int i=0;i<n;i++)
        {
            int j=n-1;
            int end_sum=0;
            while(j>i)
            {
                end_sum+=nums[j];
                j--;
            }
            if(start_sum==end_sum)
            {
                return i;
            }
           start_sum+=nums[i];
        }
        return -1;
    }
}