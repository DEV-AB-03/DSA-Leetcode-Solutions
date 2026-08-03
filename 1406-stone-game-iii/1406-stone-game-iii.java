class Solution {
    private Integer[] memo;

    public int dfs(int i, int[] nums, int n) {
        if (i == n) {
            return 0;
        }
        if (memo[i] != null) {
            return memo[i];
        }

        int pickOne = Integer.MIN_VALUE;
        int pickTwo = Integer.MIN_VALUE;
        int pickThree = Integer.MIN_VALUE;

        if (i < n) {
            pickOne = nums[i] - dfs(i + 1, nums, n);
        }
        if (i + 1 < n) {
            pickTwo = nums[i] + nums[i + 1] - dfs(i + 2, nums, n);
        }
        if (i + 2 < n) {
            pickThree = nums[i] + nums[i + 1] + nums[i + 2] - dfs(i + 3, nums, n);
        }

        memo[i] = Math.max(pickOne, Math.max(pickTwo, pickThree));
        return memo[i];
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new Integer[n]; // dfs never gets called with i == n before the base-case check, so size n is enough
        int result = dfs(0, stoneValue, n);
        if (result > 0)
            return "Alice";
        else if (result < 0)
            return "Bob";
        else
            return "Tie";
    }
}