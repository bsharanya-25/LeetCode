class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Create a map to store the next greater elements for elements in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Create a stack to keep track of elements in nums2
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {    // Iterate through nums2
        // While the stack is not empty and the top element of the stack is less than the current num
            while (!stack.isEmpty() && stack.peek() < num) {
            // Pop the top element from the stack and set it as the next greater ele for the popped ele
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);   // Push the current num onto the stack
        }
        // Create an array to store the results for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++)    // Iterate through nums1
            // Retrieve the next greater element from the map, or -1 if not found
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        return result;  // Return the result array containing the next greater elements for nums1
    }
}
