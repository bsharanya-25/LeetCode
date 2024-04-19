class Solution {
    public int jump(int[] nums) {
        int maxReach = 0; // Farthest index that can be reached
        int steps = 0; // Number of jumps taken so far
        int lastJump = 0; // Last index that was jumped from

        // Iterate through the array
        for (int i = 0; i < nums.length - 1; i++) { // Iterate until the second last index
            // Update maxReach to the maximum of current maxReach and the farthest index that can be reached from current position
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // If current index is equal to lastJump, it means we have reached the end of the current jump
            if (i == lastJump) {
                // Update lastJump to maxReach and increment steps
                lastJump = maxReach;
                steps++;
            }
        }

        // Return the number of steps, which represents the minimum number of jumps required
        return steps;
    }
}