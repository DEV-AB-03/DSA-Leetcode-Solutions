class Solution {
    public boolean checkPossibility(int[] nums) {
        int n=nums.length,i=0;
        if(n==1)return true;
        while(i<n-1 && nums[i]<=nums[i+1]){
            i++;
        }
        if(i-1>=0 && i+1<n && nums[i]>nums[i+1] && nums[i-1]<=nums[i+1]){
            nums[i]=nums[i+1];
        }
        else if(i-1>=0 && i+1<n && nums[i]>nums[i+1] && nums[i-1]>nums[i+1]){
            nums[i+1]=nums[i]+1;
        } 
        else if((i==0 ||i==n-2) && nums[i]>nums[i+1]){
            nums[i]=nums[i+1];
        }
        while(i<n-1){
            if(nums[i]>nums[i+1]) return false;
            i++;
        }
        return true;
    }
}