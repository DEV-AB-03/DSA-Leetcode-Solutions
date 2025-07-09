class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public void backtrack(List<List<String>> ans, List<String> temp, String s, int start) {
        // Terminal Condition
        if (start == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // Check for All Partitions possible(looping)
        for (int index = start; index < s.length(); index++) {
            if (isPalindrome(s, start, index)) {
                // Look for further option onli if left part is a valid palindrome
                temp.add(s.substring(start, index + 1));

                backtrack(ans, temp, s, index + 1);

                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        //Back Tracking Solution
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        backtrack(ans, temp, s, 0);
        return ans;
    }
}