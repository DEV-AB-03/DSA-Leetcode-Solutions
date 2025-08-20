class Solution {
    public int candy(int[] ratings) {
        // Slope Based Intuition
        int sum = 1;
        int i = 1;
        while (i < ratings.length) {
            if (ratings[i] == ratings[i - 1]) {
                // Plateau
                sum++;
                i++;
            }
            // Increasing Slope
            int peak = 1;
            while (i < ratings.length && ratings[i] > ratings[i - 1]) {
                peak++;
                sum += peak;
                i++;
            }

            // Decreasing Slope
            int down = 1;
            while (i < ratings.length && ratings[i] < ratings[i - 1]) {
                sum += down;
                down++;
                i++;
            }

            // Change the value of peak
            if (down > peak) {
                sum += (down - peak);
            }
        }
        return sum;
    }
}