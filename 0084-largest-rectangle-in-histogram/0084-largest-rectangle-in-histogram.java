class Solution {
    public int[] nextsmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] ns = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            while (!st.empty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (st.empty()) {
                ns[i] = a.length;
            } else {
                ns[i] = st.peek();
            }
            st.push(i);
        }
        return ns;
    }

    public int[] prevsmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] ps = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            while (!st.empty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (st.empty()) {
                ps[i] = -1;
            } else {
                ps[i] = st.peek();
            }
            st.push(i);
        }
        return ps;
    }

    public int largestRectangleArea(int[] heights) {
        //Famous Stack Question
        //Nearest smaller to right + Nearest Smaller to left
        int n = heights.length;
        int[] ps = prevsmaller(heights);
        int[] ns = nextsmaller(heights);
        int max_area = 0;
        for (int i = 0; i < n; i++) {
            int area = (ns[i] - ps[i] - 1) * heights[i];
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }
}