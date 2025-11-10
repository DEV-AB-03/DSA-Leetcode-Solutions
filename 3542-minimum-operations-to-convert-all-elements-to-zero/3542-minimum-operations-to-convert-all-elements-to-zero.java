class Solution {
    public int minOperations(int[] nums) {
        // Create a stack array to simulate the stack behavior.
        // The size is nums.length + 1 to handle the initial dummy value at stack[0].
        int stack[] = new int[nums.length + 1];

        // This variable will store the total number of "pop" operations needed.
        int result = 0;

        // 'top' points to the current top of the stack.
        int top = 0;

        // Iterate through each number in the input array.
        for (int i = 0; i < nums.length; i++) {
            // While the top of the stack is greater than the current number,
            // pop elements from the stack and increment the result counter.
            while (stack[top] > nums[i]) {
                result++;
                top--;
            }
            // If the current number is not equal to the top of the stack,
            // push it onto the stack.
            if (stack[top] != nums[i]) {
                stack[++top] = nums[i];
            }
        }
        // The answer is the total number of pops plus the number of elements left in the stack (excluding the dummy).
        return result + top;
    }
}