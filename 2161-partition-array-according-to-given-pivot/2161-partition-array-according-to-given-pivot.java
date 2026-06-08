class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int index_less = 0;
        int count_pivot = 0;
        for (int n : nums) {
            if (n < pivot) {
                ans[index_less] = n;
                index_less++;
            }
            if (n == pivot) {
                count_pivot++;
            }
        }
        for (int i = 0; i < count_pivot; i++) {
            ans[index_less] = pivot;
            index_less++;
        }
        for (int n : nums) {
            if (n > pivot) {
                ans[index_less] = n;
                index_less++;
            }
        }
        return ans;
    }
}