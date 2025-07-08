class Solution {
    public void backtrack(Set<String> seen, List<List<Integer>> ans, List<Integer> temp, int[] candidates, int target,
            int index) {
        // Terminal Conditions
        if (target == 0) {
            List<Integer> combination = new ArrayList<>(temp);
            Collections.sort(combination); // to ensure duplicates like [2,3,2] and [3,2,2] become same
            String key = combination.toString();
            if (!seen.contains(key)) {
                seen.add(key);
                ans.add(combination);
            }
            return;
        }
        if (index == candidates.length || target < 0) {
            return;
        }

        // Try Out all Scenarios
        //1. Include current element
        temp.add(candidates[index]);
        backtrack(seen, ans, temp, candidates, target - candidates[index], index + 1);

        temp.remove(temp.size() - 1);
        //2. Skip Current Element
        backtrack(seen, ans, temp, candidates, target, index + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        // Backtracking Solution
        Set<String> seen = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(seen, ans, temp, candidates, target, 0);
        return ans;
    }
}