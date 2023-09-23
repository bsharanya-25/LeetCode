class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0; // If there are no prices or only one price, we can't make any profit.
        }

        int buy = -prices[0];
        int sell = 0;

        for (int i = 1; i < n; i++) {
            int prevBuy = buy;
            int prevSell = sell;

            // Calculate the maximum profit if we buy the stock today or do nothing (based on yesterday's values).
            buy = Math.max(prevBuy, prevSell - prices[i]);

            // Calculate the maximum profit if we sell the stock today or do nothing (based on yesterday's values).
            sell = Math.max(prevSell, prevBuy + prices[i] - fee);
        }
     return sell; 
    }
}