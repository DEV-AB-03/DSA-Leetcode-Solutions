class Solution {
    public int shipMidCapacity(int[] arr, int d) {
        int day = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if (load + arr[i] > d) {
                day += 1;
                load = arr[i];
            } else {
                load += arr[i];
            }
        }
        return day;
    }

    public int maxElement(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        int n = arr.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public int getSum(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = maxElement(weights);
        int high = getSum(weights);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (shipMidCapacity(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}