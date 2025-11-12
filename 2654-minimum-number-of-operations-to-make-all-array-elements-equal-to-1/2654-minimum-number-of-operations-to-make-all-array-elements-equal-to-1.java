class Solution {
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int minOperations(int[] nums) {
        // If there is a 1 present i can use it to reduce all elements to 1
        int countOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                countOnes++;
            }
        }
        if (countOnes > 0) {
            return nums.length - countOnes;
        }
        // I need to have atleast 1 pair of elements with gcd=1. Otherwise I cannot convert elements to 1.
        // I need to find the length of shortest subarray where the gcd of all subarray elements is 1.

        // gcd(prev, new)=1 --> gcd(gcd)prev1, prev2), new)==1 ==> nested operations
        // I need the shortest gcd pair length
        int left = 0;
        int right = 0;
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int gcd = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                gcd = gcd(gcd, nums[j]);
                if (gcd == 1) {
                    length = Math.min(length, j - i + 1);
                    break;
                }
            }
        }
        if (length == Integer.MAX_VALUE) {
            return -1;
        }

        return (length - 1) + (nums.length - 1);

    }
}