class Solution {
    // 2 ____ a+1 _____a+b_____b+limit_____2*limit
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int cost[] = new int[2 * limit + 2];
        // b+limit+1 --> 2*limit+1

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);

            cost[2] += 2;
            cost[a + 1] -= 2;

            cost[a + 1] += 1;
            cost[a + b] -= 1;

            cost[a + b + 1] += 1;
            cost[b + limit + 1] -= 1;

            cost[b + limit + 1] += 2;

        }

        int ans = n;
        int curr = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            curr += cost[i];
            ans = Math.min(curr, ans);
        }

        return ans;

    }
}