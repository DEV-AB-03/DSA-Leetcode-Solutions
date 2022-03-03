class Solution 
{
    public int numberOfArithmeticSlices(int[] nums) 
    {
        //SIMULATION
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(n-i>=3)
            {
                int j=i+1;
                int diff=nums[j]-nums[i];
                j++;
                while(j<n && nums[j]-nums[j-1]==diff)
                {
                    count++;
                    j++;
                }
            }
        }
        return count;
    }
}