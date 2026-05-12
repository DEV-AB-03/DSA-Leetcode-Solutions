import java.util.*;

class Solution {

    public int minimumEffort(int[][] tasks) {

        // Sort by (minimum - actual) descending
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int low = 0;
        int high = 0;

        int maxMin = 0;

        for (int[] task : tasks) {
            high += task[0];
            maxMin = Math.max(maxMin, task[1]);
        }

        high += maxMin;

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(tasks, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean canFinish(int[][] tasks, int energy) {

        int curr = energy;

        for (int[] task : tasks) {

            int actual = task[0];
            int minimum = task[1];

            if (curr < minimum) {
                return false;
            }

            curr -= actual;
        }

        return true;
    }
}