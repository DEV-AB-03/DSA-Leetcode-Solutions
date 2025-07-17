class Solution {
    public long subArrayRanges(int[] arr) {
        int n = arr.length;
        int MOD = 1_000_000_007;

        Stack<Integer> stack = new Stack<>();
        int[] prevLess = new int[n];
        int[] nextLess = new int[n];
        int[] prevLarge = new int[n];
        int[] nextLarge = new int[n];

        // Previous Less Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            prevLess[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Previous Large Element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            prevLarge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Next Less Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            nextLess[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        stack.clear();
        // Next Large Element
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            nextLarge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long sumLess = 0;
        long sumLarge = 0;

        for (int i = 0; i < n; i++) {
            long leftLess = i - prevLess[i];
            long rightLess = nextLess[i] - i;
            sumLess = (sumLess + arr[i] * leftLess * rightLess) % MOD;

            long leftLarge = i - prevLarge[i];
            long rightLarge = nextLarge[i] - i;
            sumLarge = (sumLarge + arr[i] * leftLarge * rightLarge) % MOD;
        }

        return (int) sumLarge - sumLess;
    }
}