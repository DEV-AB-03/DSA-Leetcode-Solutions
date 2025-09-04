class Solution {
    public int findClosest(int x, int y, int z) {
        int dist1 = Math.abs(z - x);
        int dist2 = Math.abs(z - y);
        if (dist1 < dist2) {
            return 1;
        } else if (dist1 > dist2) {
            return 2;
        } else {
            return 0;
        }
    }
}