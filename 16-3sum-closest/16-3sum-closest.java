class Solution 
{
    public int threeSumClosest(int[] nums, int target) 
    {
        //3 SUM SORTING APPROACH
        int n=nums.length;
        int diff=Integer.MAX_VALUE;
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            int key=nums[i];
            int s=target-nums[i];
            int low=i+1;
            int high=n-1;
            while(low<high)
            {
                int temp_diff=Math.abs(target-(nums[i]+nums[low]+nums[high]));
                if(nums[i]+nums[low]+nums[high]==target)
                {
                    return target;
                }
                else if(Math.abs(nums[i]+nums[low]+nums[high]-target)<diff)
                {
                    diff=Math.abs(nums[i]+nums[low]+nums[high]-target);
                    sum=nums[i]+nums[low]+nums[high];
                }
                else
                {
                    if(nums[low]+nums[high]>s)
                    {
                        high--;
                    }
                    else
                    {
                        low++;
                    }
                }
            }
        }
        return sum;
    }
}