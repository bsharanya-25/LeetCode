class Solution {
    public int[] countBits(int n) {
        if(n < 2) return n == 0 ? new int[]{0} : new int[]{0, 1};
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int index = 2, power = 2;
        while (index < dp.length){
            int i = 0;
            for (int j = index; j < Math.min(n + 1, (int) Math.pow(2, power)); j++) {
                dp[j] = 1 + dp[i++];
                index++;
            }
            power++;
        }
        return dp;
    }
}