class Solution {
    public int gcd(int a, int b) {
        // if b=0, a is the GCD
        if (b == 0) {
            return a;
        }

        // call the gcd() method recursively by
        // replacing a with b and b with
        // modulus(a,b) as long as b != 0
        else {
            return gcd(b, a % b);
        }
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int low = nums[0];
        int high = nums[nums.length - 1];

        return gcd(low, high);
    }
}