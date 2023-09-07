class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // Initialize the leftmost column to 1 because there's only one way to reach any cell in the left column.
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        // Initialize the top row to 1 because there's only one way to reach any cell in the top row.
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill in the DP array using dynamic programming.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The number of unique paths to a cell is the sum of the paths from the cell above and the cell to the left.
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The value in the bottom-right cell represents the number of unique paths.
        return dp[m-1][n-1];
    }
}