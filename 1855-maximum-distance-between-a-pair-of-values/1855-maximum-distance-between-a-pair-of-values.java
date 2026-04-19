class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int ans = 0;
        while (i < nums1.length && j < nums2.length) {
            if (j < i) {
                j++;
            } else if (nums1[i] <= nums2[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}