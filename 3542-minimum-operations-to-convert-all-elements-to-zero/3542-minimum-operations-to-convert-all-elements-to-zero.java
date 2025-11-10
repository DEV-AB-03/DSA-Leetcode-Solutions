class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>(); //Monotonic Stack
        int ans = 0;
        int i = 0;

        while (i < n) { // iterating
            while (!st.isEmpty() && st.peek() > nums[i]) {
                st.pop();
            } // removing larger elements

            if (st.isEmpty() || nums[i] > st.peek()) {
                if (nums[i] != 0) // edge case
                    ans++; // counting operations

                st.push(nums[i]); // pushing in stack
            }

            i++;
        }

        return ans;

    }
}