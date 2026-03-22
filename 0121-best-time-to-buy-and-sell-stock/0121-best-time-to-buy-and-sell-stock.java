class Solution {
    public int maxProfit(int[] prices) {
        // Greedy Approach
        int minPrice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int diff = prices[i] - minPrice;
            if (profit < diff) {
                profit = diff;
            }
        }
        return profit;
    }
}