class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1; // Return -1 for empty array or null input
        }
        
        int low = 0, high = nums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // If middle element is greater than its right neighbor,
                // then there is at least one peak in the left half
                high = mid;
            } else {
                // Else the peak is in the right half
                low = mid + 1;
            }
        }
        
        // When low equals high, we've found a peak
        return low; 
    }
}
