class Solution 
{
    public int minDeletion(int[] nums) 
    {
        int deletions=0;
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            int shiftindex=i-deletions;
            if(nums[i]==nums[i+1] && shiftindex%2==0)
            {
                deletions++;
            }
        }
        if((n-deletions)%2!=0)
        {
            deletions++;
        }
        return deletions;
    }
}