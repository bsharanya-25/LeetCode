class Solution {
    public int findGCD(int[] nums) {
     Arrays.sort(nums);
     int GCD = Integer.min(nums[0], nums[nums.length-1]);
     while(GCD>0){
         if(nums[0] % GCD == 0 && nums[nums.length -1] % GCD==0){
             break;
         }
         GCD--;
     }  
    return GCD; 
    }
}