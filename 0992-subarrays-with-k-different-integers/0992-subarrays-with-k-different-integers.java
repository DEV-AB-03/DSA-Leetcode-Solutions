class Solution {
    public void pushIntoMap(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    public int countArrays(int[] nums, int k) {
        // Similar to Count Nice Sub Arrays Count Problem
        if (k < 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < nums.length) {
            pushIntoMap(map, nums[right]);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            if (map.size() <= k) {
                count += right - left + 1;
            }
            right++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return countArrays(nums, k) - countArrays(nums, k - 1);
    }
}