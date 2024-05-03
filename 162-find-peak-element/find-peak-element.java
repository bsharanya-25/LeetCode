class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int low = 0, high = nums.length-1;

        // edge cases
       if (nums.length > 1) {
            if (nums[low] > nums[low + 1]) return low;
            if (nums[high] > nums[high - 1]) return high;
        }
        low = low+1; // start from the second element
        high = high-1;


        // binary search
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            else if(nums[mid] > nums[mid-1]) low = mid+1;
            else high = mid-1;
        }

        return nums[0];
    }
}