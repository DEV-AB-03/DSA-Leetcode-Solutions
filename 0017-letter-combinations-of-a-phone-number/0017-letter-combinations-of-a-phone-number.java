class Solution {
    private static final Map<Character, String> digitToLetters = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0)
            return ans;

        backtrack(ans, new StringBuilder(), digits, 0);
        return ans;
    }

    private void backtrack(List<String> ans, StringBuilder temp, String digits, int index) {
        // Base Case: if we've built a string as long as the digit input
        if (index == digits.length()) {
            ans.add(temp.toString());
            return;
        }

        // Get possible letters for current digit
        String letters = digitToLetters.get(digits.charAt(index));

        for (char c : letters.toCharArray()) {
            temp.append(c); // Choose
            backtrack(ans, temp, digits, index + 1); // Explore
            temp.deleteCharAt(temp.length() - 1); // Unchoose (Backtrack)
        }
    }
}
