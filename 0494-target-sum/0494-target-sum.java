class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       int n = nums.length;
        int[][] dp = new int[n + 1][2001];  // Using 2001 to handle possible sums from -1000 to 1000

        // Base case: There's one way to achieve sum 0, i.e., by not selecting any element
        dp[0][1000] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2001; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2000) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }

        return dp[n][target + 1000];  // Adjust for the offset of -1000 to 1000 range
    }
}