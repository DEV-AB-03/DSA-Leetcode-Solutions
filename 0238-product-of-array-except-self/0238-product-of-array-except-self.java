class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Prefix Multiplication Approach
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int leftProd = 1;
        int rightProd = 1;
        for (int i = 0; i < nums.length; i++) {
            left[i] = leftProd;
            leftProd *= nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = rightProd;
            rightProd *= nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}