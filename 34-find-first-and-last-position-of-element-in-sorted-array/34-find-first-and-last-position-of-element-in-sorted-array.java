class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        //SINCE SORTED ARRAY WE CAN GO FOR MODIFIED BINARY SEARCH
        //THE PROBLEM IS I DONT KNOW HOW MANY TIMES THE TARGET OCCURS IN THE ARRAY
        //BUT I KNOW THAT THEY WILL BE ADJACENT
        int k=0;
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]==target)
            {
                if(nums[low]==target && nums[high]==target)
                {
                   return new int[]{low,high}; 
                }
                if(nums[low]<target)
                {
                    low++;
                }
                if(nums[high]>target)
                {
                    high--;
                }
            }
            if(nums[mid]<target)
            {
                low=mid+1;
            }
            if(nums[mid]>target)
            {
                high=mid-1;
            }
        }
       return new int[]{-1,-1};
    }
}