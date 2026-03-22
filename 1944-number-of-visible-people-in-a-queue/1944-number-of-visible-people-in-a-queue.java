class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!stack.isEmpty() && heights[i] > stack.peek()) {
                stack.pop();
                count++;
            }
            if (!stack.isEmpty()) {
                count++;
            }
            ans[i] = count;
            stack.push(heights[i]);
        }
        return ans;
    }
}