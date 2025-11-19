class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        ArrayList<Integer> set = new ArrayList<>();
        for (int i : nums) {
            set.add(i);
        }
        while (set.contains(original)) {
            original = original * 2;
        }
        return original;

    }
}