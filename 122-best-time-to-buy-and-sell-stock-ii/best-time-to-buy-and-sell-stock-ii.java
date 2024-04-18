// DP Approach
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[] = new int[n];

        for(int i = 1;i < n; i++){
            if(prices[i]>prices[i-1]){
                dp[i] = dp[i-1] +(prices[i] - prices[i-1]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
//TC:o(n) and sc:O(n)


// Greedy approach
// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit = 0;
//         for (int i = 1; i < prices.length; i++) {
//             if (prices[i-1] < prices[i]) {
//                 maxProfit += prices[i] - prices[i - 1];
//             }
//         }
//         return maxProfit;
//     }
// }
//TC:o(n) and sc:O(1)
