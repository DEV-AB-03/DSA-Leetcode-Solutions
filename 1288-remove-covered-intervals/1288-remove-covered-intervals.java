class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int ans = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart >= start && currEnd <= end) {
                // Overlapping Interval
                ans--;
            } else if (currStart == start && currEnd > end) {
                ans--;
            }
            if (intervals[i][1] > end) {
                end = intervals[i][1];
                start = intervals[i][0];
            }
        }
        return ans;

    }
}