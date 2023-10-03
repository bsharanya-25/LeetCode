class Solution {
    public int minCost(int n, int[] cuts) {
        // Sort the cut positions in ascending order
        Arrays.sort(cuts);
        
        // Get the number of cut positions
        int m = cuts.length;
        
        // Create a 2D DP array to store the minimum cost of cutting
        int[][] dp = new int[m + 2][m + 2];
        
        // Loop for different segment lengths
        for (int l = 2; l <= m + 1; l++) {
            for (int i = 0; i + l <= m + 1; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                
                // Find the optimal cut position within the segment
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
                
                // Calculate the cost of cutting the segment
                int left = (i == 0) ? 0 : cuts[i - 1];
                int right = (j == m + 1) ? n : cuts[j - 1];
                dp[i][j] += right - left;
            }
        }

        // The result is stored in dp[0][m + 1], which represents the minimum cost
        return dp[0][m + 1];
    }
}
