class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] =  Math.max(nums[0], nums[1]);
         
        for(int i =2; i<n-1;i++){
             dp[i]  = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        int max1 = dp[n-2];

        dp = new int[n];

        dp[0] = 0;
        dp[1] = nums[1];

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        int max2= dp[n-1];

        return Math.max(max1,max2);
    }
}