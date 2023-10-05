class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        
        // Calculate isPalindrome array
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                }
            }
        }
        
        return minCutHelper(s, 0, n - 1, isPalindrome, memo);
    }
    
    private int minCutHelper(String s, int start, int end, boolean[][] isPalindrome, int[] memo) {
        if (start == end || isPalindrome[start][end]) {
            return 0; // No cuts needed if it's a palindrome.
        }
        
        if (memo[start] != -1) {
            return memo[start];
        }
        
        int minCuts = Integer.MAX_VALUE;
        
        for (int i = start; i < end; i++) {
            if (isPalindrome[start][i]) {
                minCuts = Math.min(minCuts, 1 + minCutHelper(s, i + 1, end, isPalindrome, memo));
            }
        }
        
        memo[start] = minCuts;
        return minCuts;
    }
}
