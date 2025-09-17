class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorting Solution
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = 0 - nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                while (low < high) {
                    // We skip Duplicated to allow only unique pairs in the list
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // Now skip over duplicated for further solutions
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }
}