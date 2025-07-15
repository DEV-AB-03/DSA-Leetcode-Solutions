class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max_area = Integer.MIN_VALUE;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            max_area = Math.max(max_area, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max_area;
    }
}