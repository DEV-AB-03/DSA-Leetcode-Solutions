class Solution {
    public void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target, int index,
            int sum) {
        // Terminal Conditions
        if (sum > target) {
            // Only add this terminal condition when the array contains only positoive integers
            return;
        }
        // If index reaches end or target goes negative, stop
        if (index == candidates.length) {
            if (sum == target) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        // Include the current element
        if (sum + candidates[index] <= target) {
            temp.add(candidates[index]);
            backtrack(ans, temp, candidates, target, index, sum + candidates[index]); // same index: unlimited use
            temp.remove(temp.size() - 1); // backtrack
        }

        // Exclude the current element and move to next
        backtrack(ans, temp, candidates, target, index + 1, sum);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Back Tracking Solution
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(ans, temp, candidates, target, 0, 0);
        return ans;
    }
}