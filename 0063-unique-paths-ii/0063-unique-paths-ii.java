class Solution {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // Create a 1D array to store the number of unique paths for each column.
        int[] dp = new int[n];

        // Initialize the first cell if it's not an obstacle.
        dp[0] = (obstacleGrid[0][0] == 0) ? 1 : 0;

        // Fill in the DP array for the first row based on the left cell and check for obstacles.
        for (int j = 1; j < n; j++) {
            dp[j] = (obstacleGrid[0][j] == 0) ? dp[j - 1] : 0;
        }

        // Fill in the DP array for the rest of the grid.
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (j > 0) {
                        dp[j] += dp[j - 1];
                    }
                } else {
                    dp[j] = 0; // Set to 0 if there's an obstacle.
                }
            }
        }

        // The last element in the DP array represents the total unique paths.
        return dp[n - 1];
    }
}
