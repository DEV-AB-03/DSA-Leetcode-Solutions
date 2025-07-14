class Solution {
    public boolean isValid(String s) {
        // Odd Length Strings can never be balanced
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                } else if (ch == ')') {
                    if (st.peek() != '(') {
                        return false;
                    }
                    st.pop();
                } else if (ch == '}') {
                    if (st.peek() != '{') {
                        return false;
                    }
                    st.pop();
                } else if (ch == ']') {
                    if (st.peek() != '[') {
                        return false;
                    }
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
}