class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Sliding Window
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < s.length()) {
            if (seen.containsKey(s.charAt(right))) {
                // If I am at a current index, and i have already seen it, i need to trim my window
                left = Math.max(seen.get(s.charAt(right)) + 1, left);
            }
            // I can calculate window length and update
            seen.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}