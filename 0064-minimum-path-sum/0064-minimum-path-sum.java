class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Check if the grid is empty
        if (grid == null || m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // Initialize the first column with cumulative sums
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // Initialize the first row with cumulative sums
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Fill in the DP table by summing the paths from below and from the right
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        // The bottom-right cell now contains the minimum path sum
        return dp[m - 1][n - 1];
    }
}
