class Solution {
    public int uniquePaths(int m, int n) {
         int[][] dp = new int[m][n];

        // Initialize the bottom row and rightmost column to 1,
        // as there's only one way to reach any cell in those rows/columns.
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }

        // Fill in the DP table by summing the paths from below and from the right.
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
            }
        }

        // The value in dp[0][0] represents the total unique paths.
        return dp[0][0];
    }
}