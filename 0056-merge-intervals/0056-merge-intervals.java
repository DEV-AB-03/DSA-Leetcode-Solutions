class Solution {
    public int[][] merge(int[][] intervals) {
        // Sorting
        // Sort According to start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // List
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.isEmpty() || list.get(list.size() - 1)[1] < interval[0]) {
                // No overlap
                list.add(interval);
            } else {
                // Overlap
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], interval[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}