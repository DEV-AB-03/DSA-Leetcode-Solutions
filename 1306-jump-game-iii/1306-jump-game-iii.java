class Solution {
    public boolean dfs(int idx, int[] arr, boolean[] vis) {
        // Base Case
        if (arr[idx] == 0) {
            return true;
        }

        // Mark as visited
        vis[idx] = true;

        // Try out all Ways
        if (idx + arr[idx] < arr.length && !vis[idx + arr[idx]]) {
            // I can jump
            if (dfs(idx + arr[idx], arr, vis)) {
                return true;
            }
        }
        if (idx - arr[idx] >= 0 && !vis[idx - arr[idx]]) {
            // I can jump
            if (dfs(idx - arr[idx], arr, vis)) {
                return true;
            }
        }

        return false;

    }

    public boolean canReach(int[] arr, int start) {
        // DFS
        boolean[] vis = new boolean[arr.length];
        return dfs(start, arr, vis);
    }
}