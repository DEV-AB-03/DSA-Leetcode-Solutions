class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2)
            return;
        int i = nums.length-2;
        
        // find till pattern(all descending) breaks
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        
        // full descending
        if(i<0){
            reverse(nums, i+1, nums.length-1);
        }
        //if there is a break in the pattern
        else {
            int j = nums.length-1;
            while(nums[j]<=nums[i]) // find next greater element
                j--;
            swap(nums, i, j);
            reverse(nums, i+1, nums.length-1);
        }     
    }
    
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }
}