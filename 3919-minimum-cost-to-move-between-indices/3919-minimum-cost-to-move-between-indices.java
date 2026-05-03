class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] closest = new int[n];
        closest[0] = 1;
        closest[n - 1] = n - 2;

        for (int i = 1; i < n - 1; i++) {
            int left = nums[i] - nums[i - 1];
            int right = nums[i + 1] - nums[i];
            if (left <= right)
                closest[i] = i - 1;
            else
                closest[i] = i + 1;
        }

        int[] forward = new int[n];
        for (int i = 1; i < n; i++) {
            forward[i] = forward[i - 1];
            if (closest[i - 1] == i)
                forward[i]++;
            else
                forward[i] += nums[i] - nums[i - 1];
        }

        int[] backward = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            backward[i] = backward[i + 1];
            if (closest[i + 1] == i)
                backward[i]++;
            else
                backward[i] += nums[i + 1] - nums[i];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            if (l < r)
                ans[i] = forward[r] - forward[l];
            else
                ans[i] = backward[r] - backward[l];
        }

        return ans;
    }
}