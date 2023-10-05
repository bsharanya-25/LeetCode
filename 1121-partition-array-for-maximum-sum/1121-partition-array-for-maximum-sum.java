class Solution {
    public int maxSumAfterPartitioning(int[] arr, int K) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        // Traverse the input array from right to left
        for (int ind = n - 1; ind >= 0; ind--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int maxAns = Integer.MIN_VALUE;
            
            // Iterate through the next 'K' elements or remaining elements if less than 'K'.
            for (int j = ind; j < Math.min(ind + K, n); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = len * maxi + dp[j + 1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[ind] = maxAns;
        }
        return dp[0];
    }
}
