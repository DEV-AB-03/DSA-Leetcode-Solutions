class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        // I need to choose the minimum element
        Arrays.sort(nums);

        int count = 0;
        int minSoFar = Integer.MIN_VALUE;
        for (int num : nums) {
            int min = num - k;
            int max = num + k;
            int pick = Math.max(minSoFar + 1, min);
            if (pick <= max) {
                count++;
                minSoFar = pick;
            }
        }
        return count;
    }
}