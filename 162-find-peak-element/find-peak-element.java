class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0; // Only one element, it's the peak
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        
        return nums.length - 1; // If the last element is the peak
    }
}
