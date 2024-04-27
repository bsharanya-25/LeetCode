class Solution {
    public int countPartition(int[] nums, int maxSum){
    int partition = 1;
    long subarraySum = 0;
    for(int i =0;i<nums.length;i++){
        if(subarraySum + nums[i]<=maxSum){
            subarraySum += nums[i];
        }else{
            partition++;
            subarraySum = nums[i];
        }
    }
    return partition;
    }
    public int splitArray(int[] nums, int k) {
        int low = nums[0];
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while(low <= high){
            int mid = low+(high-low)/2;
            int partition = countPartition(nums, mid);
            if(partition > k){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
    return low;
    }
}