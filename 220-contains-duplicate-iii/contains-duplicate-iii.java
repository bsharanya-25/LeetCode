import java.util.HashMap;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff < 0) {
            return false;
        }
        
        long width = (long) valueDiff + 1;
        HashMap<Long, Long> buckets = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long id = num < 0 ? (num + 1) / width - 1 : num / width;
            
            // Check if the same bucket or nearby buckets have elements within the value difference
            if (buckets.containsKey(id)
                || (buckets.containsKey(id - 1) && num - buckets.get(id - 1) <= valueDiff)
                || (buckets.containsKey(id + 1) && buckets.get(id + 1) - num <= valueDiff)) {
                return true;
            }
            
            buckets.put(id, num);
            
            // Remove elements from buckets that fall out of the window
            if (i >= indexDiff) {
                long oldId = nums[i - indexDiff] < 0 ? (nums[i - indexDiff] + 1) / width - 1 : nums[i - indexDiff] / width;
                buckets.remove(oldId);
            }
        }
        
        return false;
    }
}
