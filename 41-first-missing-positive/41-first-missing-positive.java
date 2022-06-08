class Solution 
{
    public int firstMissingPositive(int[] nums) 
    {
        int n = nums.length;
        for(int i=0; i<n; i++){
            if(nums[i]<1 || nums[i]>n){
                nums[i] = n+1;
            }
        }
        for(int i=0; i<n; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(index<n && nums[index]>0)
            {
                nums[index] = -1*nums[index];
            }
        }
        for(int i=0; i<n; i++)
        {
            if(nums[i]>0)
            {
                return i+1;
            }
        }
        return n+1;
    }
}