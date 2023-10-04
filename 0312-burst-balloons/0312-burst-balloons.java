class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] balloons = new int[n + 2];
        balloons[0] = balloons[n + 1] = 1; // Add imaginary balloons at both ends.
        
        for (int i = 1; i <= n; i++) {
            balloons[i] = nums[i - 1];
        }
        
        int[][] dp = new int[n + 2][n + 2];
        
        for (int len = 2; len <= n + 1; len++) {
            for (int left = 0; left <= n + 1 - len; left++) {
                int right = left + len;
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                            balloons[left] * balloons[k] * balloons[right] + dp[left][k] + dp[k][right]);
                }
            }
        }
        
        return dp[0][n + 1];
    }
}