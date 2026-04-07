class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int g = 0;
        int c = 0;

        for (int i = 0; i < gas.length; i++) {
            g += gas[i];
            c += cost[i];
        }
        if (g < c) {
            return -1;
        }

        int currg = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            currg += gas[i] - cost[i];
            if (currg < 0) {
                start = i + 1;
                currg = 0;
            }
        }
        return start;
    }
}