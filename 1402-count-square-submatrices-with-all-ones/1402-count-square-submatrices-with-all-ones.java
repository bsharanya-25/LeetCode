class Solution{
public int countSquares(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    
    // Create a 2D DP array to store the count of square submatrices
    // dp[i][j] will represent the count of square submatrices with all ones
    // that end at position (i, j) in the input matrix
    int[][] dp = new int[rows][cols];
    
    // Initialize the first row and first column of the DP array
    for (int i = 0; i < rows; i++) {
        dp[i][0] = matrix[i][0];
    }
    for (int j = 0; j < cols; j++) {
        dp[0][j] = matrix[0][j];
    }
    
    // Loop through the matrix starting from the second row and second column
    // Calculate the count of square submatrices with all ones for each position
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            // If the current cell in the matrix is 1, calculate the count of
            // square submatrices that end at this cell
            if (matrix[i][j] == 1) {
                // The count at dp[i][j] will be the minimum of the counts at
                // dp[i-1][j], dp[i][j-1], and dp[i-1][j-1], plus 1.
                dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
            }
        }
    }
    
    // Calculate the total count of square submatrices with all ones
    int totalCount = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            totalCount += dp[i][j];
        }
    }
    
    return totalCount;
    }
}
