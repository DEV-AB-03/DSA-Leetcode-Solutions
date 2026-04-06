class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Fill Map
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Arrays.sort(nums);

        for (int num : nums) {
            if (map.get(num) == 0) {
                continue;
            }
            // Try to form Groups
            for (int i = 0; i < k; i++) {
                int curr = num + i;
                if (map.getOrDefault(curr, 0) == 0) {
                    return false;
                }
                map.put(curr, map.get(curr) - 1);
            }
        }
        return true;
    }
}