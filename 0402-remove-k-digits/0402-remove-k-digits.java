public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            // Remove digits from stack while they are larger than current digit
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If k is still greater than 0, remove from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build the final number from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Remove leading zeroes
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}