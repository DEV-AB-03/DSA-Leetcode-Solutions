class Solution {
    public boolean possible(int[] arr, int m, int k, int d) {
        int count = 0;
        int noOfB = 0;
        for (int i = 0; i < arr.length; i++) {
            if (d >= arr[i]) {
                count++;
            } else {
                noOfB += count / k;
                count = 0;
            }
        }
        noOfB += count / k;
        return noOfB >= m;
    }

    public int getMin(int[] arr) {
        // Find the minimum element using a lambda expression
        int min = Arrays.stream(arr).min().getAsInt();
        return min;
    }

    public int getMax(int[] arr) {
        // Find the maximum element using a lambda expression
        int max = Arrays.stream(arr).max().getAsInt();
        return max;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        if ((long)m * (long)k > (long)bloomDay.length) {
            return -1;
        }
        int low = getMin(bloomDay);
        int high = getMax(bloomDay);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, m, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}