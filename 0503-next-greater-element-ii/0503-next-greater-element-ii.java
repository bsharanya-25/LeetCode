class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize the result with -1
        Stack<Integer> stack = new Stack<>();
        
        // Iterate through the circular array twice
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n]; // Get the current element in the circular fashion
            
            // While the stack is not empty and the current element is greater than the element at the top of the stack
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                result[stack.pop()] = num; // Update the result for the element at the top of the stack
            }
            
            // Push the index of the current element onto the stack
            if (i < n) {
                stack.push(i);
            }
        }
        
        return result;
    }
}
