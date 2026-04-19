class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, ans = 0;
        while (i < nums1.length && j < nums2.length) {
            while (j < nums2.length && nums1[i] <= nums2[j]) {
                j++;
            }
            ans = Math.max(ans, j - 1 - i);
            i++;
            if (j < i)
                j = i;
        }
        return ans;
    }
}