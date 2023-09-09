class Solution {
    public int climbStairs(int n) {
    
        // Create an array to store the number of ways to reach each stair.
        int[] dp = new int[n + 1];

        // Base cases:
        // There is only one way to reach the 0th and 1st stair.
        dp[0] = 1;
        dp[1] = 1;

        // Calculate the number of ways for the remaining stairs using DP.
        for (int i = 2; i <= n; i++) {
            // The number of ways to reach the ith stair is the sum of
            // the ways to reach the (i-1)th stair and the ways to reach
            // the (i-2)th stair.
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // The value at dp[n] represents the number of ways to reach the nth stair.
        return dp[n];

    }
}