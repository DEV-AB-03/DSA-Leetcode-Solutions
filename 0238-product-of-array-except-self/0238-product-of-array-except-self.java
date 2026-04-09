class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Prefix and Suffix
        int[] pre = new int[nums.length];
        int[] suff = new int[nums.length];

        int lp = 1;
        int rp = 1;
        for (int i = 0; i < nums.length; i++) {
            pre[i] = lp;
            lp *= nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suff[i] = rp;
            rp *= nums[i];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;

    }
}