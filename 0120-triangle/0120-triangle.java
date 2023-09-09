class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       if(triangle.isEmpty()) {
            return 0;
        }

        int n = triangle.size();
        int[] dp = new int[n];

        // Initialize the DP array with the bottom row of the triangle
        List<Integer> bottomRow = triangle.get(n - 1);
        for (int i = 0; i < n; i++) {
            dp[i] = bottomRow.get(i);
        }

        // Traverse the triangle from second-to-last row to the top
        for (int row = n - 2; row >= 0; row--) {
            List<Integer> currentRow = triangle.get(row);
            for (int i = 0; i < currentRow.size(); i++) {
                // Calculate the minimum path sum for each cell in the current row
                dp[i] = Math.min(dp[i], dp[i + 1]) + currentRow.get(i);
            }
        }

        // The minimum path sum is now stored in dp[0]
        return dp[0];
    }
}