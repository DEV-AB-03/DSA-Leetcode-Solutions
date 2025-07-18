import java.util.Stack;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;

        int maxArea = 0;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        for (char[] row : matrix) {
            // Update the histogram heights
            for (int i = 0; i < cols; i++) {
                if (row[i] == '1') {
                    heights[i] = heights[i] + 1;
                } else {
                    heights[i] = 0;
                }
            }

            // Compute max area in histogram
            int area = largestRectangleArea(heights);
            if (area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    // Helper function to compute Largest Rectangle in Histogram
    private int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int h;
            if (i == n) {
                h = 0;
            } else {
                h = heights[i];
            }

            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }

            stack.push(i);
        }

        return maxArea;
    }
}
