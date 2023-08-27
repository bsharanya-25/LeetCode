class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int t[][] = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
           for(int j=0;j<amount+1;j++){
                if (i == 0) t[0][j] = Integer.MAX_VALUE - 1; // Initialize with a large value
                if (j == 0) t[i][0] = 0;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i - 1][j], 1 + t[i][j - coins[i - 1]]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        
        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
    }
}