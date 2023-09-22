class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        
        for (int i = 1; i < n; i++) {
            if (prices[i] > prices[i - 1]) {
                dp[i] = dp[i - 1] + prices[i] - prices[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        
        return dp[n - 1];
    }
}