class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder lps = new StringBuilder();
        int i = 0, j = n - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                lps.append(s.charAt(i));
                i++;
                j--;
            } else if (dp[i][j - 1] > dp[i + 1][j]) {
                j--;
            } else {
                i++;
            }
        }
        if (i == j) {
            lps.append(s.charAt(i));
        }
        return dp[0][n - 1]; // Length of the longest palindromic subsequence
    
    }
}