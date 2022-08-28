class Solution {
     public void merge(int[] nums, int l , int m, int r){
//         length of left array 
        int n1 = (m-l+1);
//         length of right array
        int n2 = (r-m);
        
        int[] left_arr = new int[n1];
        
        int[] right_arr = new int[n2];
        
//         copy elements in left array from main array
        for(int k = 0; k<n1; k++){
            left_arr[k] = nums[l+k];
        }
        
//         copy elements from right array from main array
        for(int k = 0; k<n2; k++){
            right_arr[k]  = nums[m+k+1];
        }
        
        int i = 0, j= 0, o = l;
        
//         merge function
        while(i<n1 && j<n2){
            if(left_arr[i]<right_arr[j]){
                nums[o] = left_arr[i];
                i++;
            }else{
                nums[o] = right_arr[j];
                j++;
            }
            o++;
        }
        
//         copy the rest of the left elements as they were already sorted
        while(i<n1){
            nums[o] = left_arr[i];
            i++;
            o++;
        }
        
        while(j<n2){
            nums[o] = right_arr[j];
            j++;
            o++;
        }
        
    }
    public void mergeSort(int[] nums, int l , int r){
        if(l==r) return;
            int m = l+(r-l)/2;
            
//             left array partition
            mergeSort(nums, l, m);
            
//             right array partition 
            mergeSort(nums, m+1, r);
            
//             merge the two sorted arrays
            merge(nums, l, m, r);
        
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}