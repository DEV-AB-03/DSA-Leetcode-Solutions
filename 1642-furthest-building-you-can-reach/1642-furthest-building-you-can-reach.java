class Solution 
{
     public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int len = heights.length;

        PriorityQueue<Integer> gaps = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            int deltaHeight = heights[i + 1] - heights[i];
            if (deltaHeight > 0) {
                gaps.offer(deltaHeight);
                if (gaps.size() > ladders) {
                    sum += gaps.poll();
                }

                if (sum > bricks) {
                    return i;
                }
            }
        }

        return len - 1;
    }
}