class Solution {
    public int maxRotateFunction(int[] nums) {
        // Prefix Sum
        // F(k)=F(k−1)+numSum−n×nums[n−k]
        int sum = Arrays.stream(nums).sum();
        int f0 = 0;
        for (int i = 0; i < nums.length; i++) {
            f0 += i * nums[i];
        }
        int max = f0;
        for (int i = nums.length - 1; i >= 0; i--) {
            f0 += sum - nums.length * nums[i];
            max = Math.max(max, f0);
        }

        return max;

    }
}