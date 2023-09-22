class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1 || k <= 0) {
            return 0; // If there are no prices, only one price, or no transactions allowed, return 0.
        }

        if (k >= n / 2) {
            // If k is greater than or equal to half the number of days,
            // it's equivalent to the "Best Time to Buy and Sell Stock II" problem.
            // We can make as many transactions as we want.
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        int[] buy = new int[k];
        int[] sell = new int[k];

        for (int i = 0; i < k; i++) {
            buy[i] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int i = 0; i < k; i++) {
                buy[i] = Math.max(buy[i], (i == 0 ? 0 : sell[i - 1]) - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }

        return sell[k - 1];
    }
}
