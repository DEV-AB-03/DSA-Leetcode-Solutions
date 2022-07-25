class Solution 
{
    public int binarysearch(int[]a,int startIndex,int endIndex,int target)
    {
        int low=startIndex;
        int high=endIndex;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(a[mid]==target)
            {
                return mid;
            }
            if(a[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) 
    {
        int n=nums.length;
        //Now we need to find pivot index
        //Modified Binary Search
        int low=0;
        int high=n-1;
        int pivot=0;
        int index=-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(nums[mid]<nums[0])
            {
                pivot=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        if(pivot==0 || (target<=nums[n-1] && target>=nums[pivot]))
        {
            index=binarysearch(nums,pivot,n-1,target);
        }
        else
        {
            index=binarysearch(nums,0,pivot-1,target);
        }
        return index;
    }
}