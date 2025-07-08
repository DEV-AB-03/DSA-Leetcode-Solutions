class Solution {
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int limit, int target, int sum, int index) {
        // Terminal Condition
        if (sum > target || temp.size() > limit) {
            return;
        }
        if (index > 9 || temp.size() == limit) {
            if (sum == target && temp.size() == limit) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // Try Out All Scenarios
        // 1. Include the current element
        temp.add(index);

        backtrack(ans, temp, limit, target, sum + index, index + 1);

        // 2. Exclude the current element
        temp.remove(temp.size() - 1);

        backtrack(ans, temp, limit, target, sum, index + 1);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        // BackTracking Solution
        int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(ans, temp, k, n, 0, 1);
        return ans;
    }
}