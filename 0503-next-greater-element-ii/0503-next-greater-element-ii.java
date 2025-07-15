class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums[i % nums.length]) {
                st.pop();
            }
            if (i < nums.length) {
                // Now start alloting
                if (!st.isEmpty()) {
                    nge[i] = st.peek();
                } else {
                    nge[i] = -1;
                }
            }
            st.push(nums[i % nums.length]);
        }
        return nge;
    }
}