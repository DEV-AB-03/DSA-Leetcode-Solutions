class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        // Greedy
        int left = 0;
        int right = height.length - 1;

        while (left <= right) {
            max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}