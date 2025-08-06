class Solution {
    public int totalFruit(int[] fruits) {
        // Find the length of the longest subarray wherein there are at most two distinct positive integers
        int maxLen = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < fruits.length) {
            if (map.containsKey(fruits[right])) {
                map.put(fruits[right], map.get(fruits[right]) + 1);
            } else {
                map.put(fruits[right], 1);
            }
            if (map.size() > 2) {
                // We cannot add the current element until our window is valid
                while (map.size() > 2) {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if (map.get(fruits[left]) == 0) {
                        map.remove(fruits[left]);
                    }
                    left++;
                }
            }
            if (map.size() <= 2) {
                // Now our window is valid as map size is reduced below k
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            right++;
        }
        return maxLen;
    }
}