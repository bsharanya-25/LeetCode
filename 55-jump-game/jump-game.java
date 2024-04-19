class Solution {
    public boolean canJump(int[] nums) {
        int far = 0;
        for(int i =0; i< nums.length;i++){
            if(i>far){
                return false;
            }
            far = Math.max(far, i+nums[i]);
        }
        return true;
    }
}
// tc: O(n)  sc: O(1)-> Greedy approach


// public boolean canJump(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n];
//         dp[n - 1] = true; // We can always reach the last index
        
//         for (int i = n - 2; i >= 0; i--) {
//             int maxJump = Math.min(i + nums[i], n - 1); // Calculate the maximum reachable index from position i
//             for (int j = i + 1; j <= maxJump; j++) {
//                 if (dp[j]) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
        
//         return dp[0]; // Return whether we can reach the first index
//     }
// Tc: O(n)  sc:O(n) -> DP
