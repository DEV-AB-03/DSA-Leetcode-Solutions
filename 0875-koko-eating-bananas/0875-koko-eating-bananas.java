class Solution {
    public int maxElement(int[] arr) {
        int maxi = Integer.MIN_VALUE;
        ;
        int n = arr.length;
        //find the maximum:
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        return maxi;
    }

    public int calculateTotalHrs(int[] arr, int k) {
        int totalH = 0;
        int n = arr.length;
        //find total hours:
        for (int i = 0; i < n; i++) {
            totalH += Math.ceil((double) (arr[i]) / (double) (k));
        }
        return totalH;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxElement(piles);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (calculateTotalHrs(piles, mid) <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}