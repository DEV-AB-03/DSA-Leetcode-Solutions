class Solution {
    public void backtrack(Set<String> seen, List<List<Integer>> ans, List<Integer> temp, int[] arr, int index) {
        // Terminal Condiiton
        if (index == arr.length) {
            List<Integer> combination = new ArrayList<>(temp);
            Collections.sort(combination); // to ensure duplicates like [2,3,2] and [3,2,2] become same
            String key = combination.toString();
            if (!seen.contains(key)) {
                seen.add(key);
                ans.add(combination);
            }
            return;
        }
        // Try out all scenarios
        temp.add(arr[index]);
        backtrack(seen, ans, temp, arr, index + 1);

        temp.remove(temp.size() - 1);

        backtrack(seen, ans, temp, arr, index + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<String> seen = new HashSet<>();
        // Back Tracking Solution
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(seen, ans, temp, nums, 0);
        return ans;
    }
}