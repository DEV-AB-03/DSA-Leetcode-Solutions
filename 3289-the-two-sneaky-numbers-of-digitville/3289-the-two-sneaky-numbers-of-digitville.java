class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // Hashing Pattern
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                list.add(num);
            } else {
                set.add(num);
            }
        }
        int[] ans = new int[2];
        for (int i = 0; i < 2; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}