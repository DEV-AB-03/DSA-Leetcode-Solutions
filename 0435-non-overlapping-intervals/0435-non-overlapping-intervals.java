class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort By End Time
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int numOfMeetings = 1;
        int lastFreeTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastFreeTime) {
                numOfMeetings++;
                lastFreeTime = intervals[i][1];
            }
        }
        return intervals.length - numOfMeetings;
    }
}