class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        // Store indices of each value
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        // Process each group of same numbers
        for (List<Integer> idxs : map.values()) {
            int m = idxs.size();

            if (m == 1)
                continue; // only one occurrence => answer is 0

            // Prefix sum of indices
            long[] prefix = new long[m];
            prefix[0] = idxs.get(0);

            for (int i = 1; i < m; i++) {
                prefix[i] = prefix[i - 1] + idxs.get(i);
            }

            for (int i = 0; i < m; i++) {
                long left = 0, right = 0;

                // Distance to left side
                if (i > 0) {
                    left = (long) idxs.get(i) * i - prefix[i - 1];
                }

                // Distance to right side
                if (i < m - 1) {
                    right = (prefix[m - 1] - prefix[i]) - (long) idxs.get(i) * (m - i - 1);
                }

                ans[idxs.get(i)] = left + right;
            }
        }

        return ans;
    }
}