class Solution {
    public boolean canBreak(int start, String s, List<String> wordDict, Map<Integer, Boolean> memo) {
        // Terminal Condition
        if (start == s.length()) {
            return true;
        }

        // If result is already computed
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        // Try all possible prefixes
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordDict.contains(prefix)) {
                if (canBreak(end, s, wordDict, memo)) {
                    memo.put(start, true);
                    return true;
                }
            }
        }

        // Store result in memo before returning
        memo.put(start, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // You can also use a HashSet for faster lookup
        Set<String> dictSet = new HashSet<>(wordDict);
        Map<Integer, Boolean> memo = new HashMap<>();
        return canBreak(0, s, wordDict, memo);
    }
}