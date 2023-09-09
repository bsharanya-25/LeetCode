class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Handle the base case of an empty matrix
        if (rows == 0 || cols == 0) {
            return 0;
        }

        // Dynamic programming array to store minimum falling path sum
        int[][] dp = new int[rows][cols];

        // Initialize the first row of dp with values from the first row of matrix
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Calculate the minimum falling path sum for each cell in dp
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i][j] = matrix[i][j] + Math.min(
                    dp[i - 1][j],
                    Math.min(j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE, j < cols - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE)
                );
            }
        }

        // Find the minimum falling path sum in the last row of dp
        int minPathSum = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            minPathSum = Math.min(minPathSum, dp[rows - 1][j]);
        }

        return minPathSum;
    }
}
