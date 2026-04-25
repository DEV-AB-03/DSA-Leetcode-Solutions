import java.util.*;

class Solution {

    int side;
    long perimeter;
    long[] pos;
    int n;

    // Convert (x,y) boundary point into perimeter distance
    private long getPos(int x, int y) {
        if (y == 0)
            return x; // bottom
        if (x == side)
            return side + y; // right
        if (y == side)
            return 3L * side - x; // top
        return 4L * side - y; // left
    }

    public boolean isValid(int[][] points, int k, int d) {

        if (k == 1)
            return true;

        long[] arr = new long[2 * n];

        for (int i = 0; i < n; i++) {
            arr[i] = pos[i];
            arr[i + n] = pos[i] + perimeter;
        }

        // next[i] = first point at distance >= d
        int[] next = new int[2 * n];
        int j = 0;

        for (int i = 0; i < 2 * n; i++) {
            j = Math.max(j, i + 1);

            while (j < 2 * n && arr[j] - arr[i] < d) {
                j++;
            }

            next[i] = j;
        }

        // Try every point as starting point
        for (int start = 0; start < n; start++) {

            int cur = start;
            int taken = 1;

            while (taken < k) {
                cur = next[cur];

                if (cur >= start + n)
                    break;

                taken++;
            }

            if (taken < k)
                continue;

            // Check circular distance between last and first
            long clockwise = arr[cur] - arr[start];
            long otherSide = perimeter - clockwise;

            if (otherSide >= d)
                return true;
        }

        return false;
    }

    public int maxDistance(int side, int[][] points, int k) {

        this.side = side;
        this.perimeter = 4L * side;
        this.n = points.length;

        pos = new long[n];

        for (int i = 0; i < n; i++) {
            pos[i] = getPos(points[i][0], points[i][1]);
        }

        Arrays.sort(pos);

        // Binary Search
        int low = 0;
        int high = 2 * side;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (isValid(points, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}