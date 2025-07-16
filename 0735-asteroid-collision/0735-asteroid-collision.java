class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int ast = asteroids[i];
            if (ast > 0) {
                st.push(ast);
            } else {
                // We have a negative element
                // All less than size will be cancelled off
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(ast)) {
                    st.pop();
                }
                // All equal size cancel out
                if (!st.isEmpty() && st.peek() == Math.abs(ast)) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(ast);
                }
            }
        }
        // Return Ans
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop();
        }
        return ans;
    }
}