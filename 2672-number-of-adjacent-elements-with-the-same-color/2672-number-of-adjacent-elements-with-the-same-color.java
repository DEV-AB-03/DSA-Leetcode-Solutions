class Solution {
    public int[] colorTheArray(int n, int[][] queries) {

        int[] ans = new int[queries.length];
        int[] res = new int[n];

        int count = 0;

        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0];
            int col = queries[i][1];

            // Step 1: remove old contribution
            if (res[idx] != 0) {
                if (idx > 0 && res[idx] == res[idx - 1])
                    count--;
                if (idx < n - 1 && res[idx] == res[idx + 1])
                    count--;
            }

            // Step 2: apply new color
            res[idx] = col;

            // Step 3: add new contribution
            if (idx > 0 && res[idx] == res[idx - 1])
                count++;
            if (idx < n - 1 && res[idx] == res[idx + 1])
                count++;

            ans[i] = count;
        }

        return ans;
    }
}