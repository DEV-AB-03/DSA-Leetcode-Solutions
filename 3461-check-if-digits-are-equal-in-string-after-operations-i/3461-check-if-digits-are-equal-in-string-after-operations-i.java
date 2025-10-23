class Solution {
    public boolean hasSameDigits(String s) {
        // Convert string to array of digits
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }

        // Repeat operation until length is 2
        while (digits.length > 2) {
            int newLen = digits.length - 1;
            int[] newDigits = new int[newLen];
            for (int i = 0; i < newLen; i++) {
                newDigits[i] = (digits[i] + digits[i + 1]) % 10;
            }
            digits = newDigits;
        }

        // Check if final two digits are equal
        return digits[0] == digits[1];
    }
}
