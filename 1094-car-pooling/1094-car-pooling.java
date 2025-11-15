class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // Sort the trips array
        Arrays.sort(trips, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        // Store Ordered Collection of To and Passenger Count
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int current = 0;

        for (int[] trip : trips) {
            int numPass = trip[0];
            int from = trip[1];
            int to = trip[2];

            // Clear out all previous ended trips
            while (!pq.isEmpty() && pq.peek()[0] <= from) {
                current -= pq.peek()[1];
                pq.poll();
            }

            // Add the current capacity to the car
            current += numPass;

            if (current > capacity) {
                return false;
            }

            // Add active trip to Queue for further comparison
            pq.offer(new int[] { to, numPass });
        }
        return true;
    }
}