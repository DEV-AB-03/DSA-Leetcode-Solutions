class Solution {
    public int characterReplacement(String s, int k) {
        // Sliding Window + 2 pointer
        // Core logic is to minimize operations by identifying which characters to replace by the formula len(substring) - maxFreq
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        int[] hash = new int[26];
        while (right < s.length()) {
            hash[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                hash[s.charAt(left) - 'A']--;
                // Re calculate maxFreq
                for (int freq : hash) {
                    maxFreq = Math.max(maxFreq, freq);
                }
                left++;
            }
            if ((right - left + 1) - maxFreq <= k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
            right++;
        }
        return maxLen;
    }
}