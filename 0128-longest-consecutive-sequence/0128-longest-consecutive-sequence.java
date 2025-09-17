class Solution {
    public int longestConsecutive(int[] nums) {
        // HashSet Approach
        // Assume current num as the starting point in the chain and find ahead
        Set<Integer> set = new HashSet<>();
        int maxLength = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}