class Solution {
    public static void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    public static int countReversePairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long)nums[i] > nums[right] * 2L) {
                right++;
            }
            count += right - (mid + 1);
        }
        return count;
    }

    public static int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }
        int mid = (low + high) / 2;
        // Left Recursive Call
        count += mergeSort(nums, low, mid);
        // Right Recursive Call
        count += mergeSort(nums, mid + 1, high);

        // Count Pairs before merging arr
        count += countReversePairs(nums, low, mid, high);

        // Merge Array
        merge(nums, low, mid, high);

        return count;
    }

    public int reversePairs(int[] nums) {
        // Little bit tweaking of Merge Sort - Similar to Count Inversions
        return mergeSort(nums, 0, nums.length - 1);
    }
}