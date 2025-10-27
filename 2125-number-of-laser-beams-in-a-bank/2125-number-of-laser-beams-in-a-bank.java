class Solution {
    private int countDevices(String row) {
        int count = 0;
        for (char c : row.toCharArray()) {
            if (c == '1')
                count++;
        }
        return count;
    }

    public int numberOfBeams(String[] bank) {
        // 2 Pointer approach
        int prevRowCount = 0;
        int n = bank.length;
        int numOfBeams = 0;
        for (int i = 0; i < n; i++) {
            int currRowCount = countDevices(bank[i]);
            if (currRowCount > 0) {
                numOfBeams += prevRowCount * currRowCount;
                prevRowCount = currRowCount;
            }
        }
        return numOfBeams;
    }
}