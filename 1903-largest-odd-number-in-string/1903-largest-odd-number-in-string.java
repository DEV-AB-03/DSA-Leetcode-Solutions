class Solution {
    public boolean isOdd(char ch) {
        int numericValue = ch - '0';
        return numericValue % 2 != 0;
    }

    public String largestOddNumber(String num) {
        int index = -1;
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            if (isOdd(num.charAt(i))) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = 0; i <= index; i++) {
                sb.append(num.charAt(i));
            }
            return sb.toString();
        } else {
            return "";
        }
    }
}