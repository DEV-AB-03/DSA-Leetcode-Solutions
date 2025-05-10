class Solution {
    public int findPeakElement(int[] nums) {
        // Array has only 1 element
        if (nums.length == 1 || nums.length == 0) {
            return 0;
        }
        // Check for First Element
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        // Now Perform Binary Search
        int low = 1;
        int high = nums.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                // Mid is on an increasing curve. So peak lies to right of mid
                low = mid + 1;
            } else {
                // Mid is on an decreasing curve. So peak lies to left of mid
                high = mid - 1;
            }
        }
        return -1;
    }
}