class Solution {
    public long minimumReplacement(int[] nums) {
        long minOps = 0;
        int n = nums.length;
        int next = Integer.MAX_VALUE;
        for(int i = n-1; i >=0; i--){
            if (next >= nums[i]){
                next = nums[i];
                continue;
            }
            int parts =(nums[i]+next-1)/next;
            minOps+=parts-1;
            next = nums[i]/parts;
        }
        return minOps;
    }
}