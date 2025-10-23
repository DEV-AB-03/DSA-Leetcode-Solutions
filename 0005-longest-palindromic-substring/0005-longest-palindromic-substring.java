class Solution {
    public String dfs(String s, int low, int high) {
        // Base case
        if (low > high) {
            return "";
        }
        if (low == high) {
            return s.substring(low, low + 1);
        }
        if (s.charAt(low) == s.charAt(high)) {
            String inner = dfs(s, low + 1, high - 1);

            // We check if the whole string including the matching characters is a palindrome or not
            if (inner.length() == high - low - 1) {
                return s.substring(low, high + 1);
            }
        }
        String left = dfs(s, low + 1, high);
        String right = dfs(s, low, high - 1);

        // Return the longer palindrome
        return left.length() > right.length() ? left : right;

    }

    public String longestPalindrome(String s) {
        // Recursion Approach
        // We will initialize two pointer low and high
        // At every steo we have two choices either skip low and try to find a palndrom on the right or skip high and try to find a palindrome on left
        // if two chars are same they will definitely be a part of a pal so we reduce search space

        // if we find a palinfro with given search space of low and high, we wont go further recursion call as like it will be the longest in that given search space.
        int low = 0;
        int high = s.length() - 1;
        return dfs(s, low, high);
    }
}