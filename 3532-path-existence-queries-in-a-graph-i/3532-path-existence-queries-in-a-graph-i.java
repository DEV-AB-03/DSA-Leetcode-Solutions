class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // If two indices are connected to each other then we can reach them
        // sine the array is sorted in increasing order, we can trace consecutive gaps
        int[] parent = new int[n];
        parent[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                // Carry over same parent
                parent[i] = parent[i - 1];
            } else {
                parent[i] = i;
            }
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (parent[queries[i][0]] == parent[queries[i][1]]);
        }
        return ans;
    }
}