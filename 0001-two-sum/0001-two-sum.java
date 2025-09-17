class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hashing Approach
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[] { i, map.get(key) };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }
}