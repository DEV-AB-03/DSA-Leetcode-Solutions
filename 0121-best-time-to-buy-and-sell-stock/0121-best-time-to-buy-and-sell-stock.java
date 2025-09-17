class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int leastPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i<n;i++)
        {
            // Check for Min Price
            if(leastPrice>prices[i])
            {
                leastPrice=prices[i];
            }
            // If we already have a min price set so far, then check for profit
            else if(prices[i]-leastPrice > maxProfit)
            {
                maxProfit=prices[i]-leastPrice;
            }
        }
        return maxProfit;
    }
}