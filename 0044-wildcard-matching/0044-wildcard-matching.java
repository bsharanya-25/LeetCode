class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean [][]dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for(int i=0;i<=n;i++){
            for(int j =1; j <=m; j++){
                if (p.charAt(j - 1) == '*') {
                    // Match 0 or more characters
                    dp[i][j] = dp[i][j - 1] || (i > 0 && dp[i - 1][j]);
                } else if (i > 0 && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')) {
                    // Match a single character or '?'
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
    return dp[n][m];
    }
}