class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        while (n > 0) {
            int rem = n % 10;
            freq[rem]++;
            n = n / 10;
        }
        int score = 0;
        for (int i = 0; i < 10; i++) {
            score += freq[i] * i;
        }
        return score;
    }
}