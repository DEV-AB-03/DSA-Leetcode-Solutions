class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort According to begin time
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || interval[0] > merged.getLast()[1]) {
                // Simply insert this interval
                merged.add(interval);
            } else {
                // We have a interval that sits between the interval in list
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}