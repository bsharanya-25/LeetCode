class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0; // If there are no prices or only one price, we can't make any profit.
        }
        int buy1 = Integer.MIN_VALUE;
        int buy2 = Integer.MIN_VALUE;
        int sell1 = 0;
        int sell2 = 0;

        for (int price : prices) {
    
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, buy1 + price);

            // Second buy and sell
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, buy2 + price);
        }

        return sell2;
    }
}