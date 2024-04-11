class Solution{
    public String removeKdigits(String num, int k) {
        // Edge case: if k is equal to the length of num, then return "0"
        if (k == num.length()) return "0";
        
        Stack<Character> stack = new Stack<>();
        
        // Iterate through each digit in the number
        for (char digit : num.toCharArray()) {
            // While k is greater than 0 and the stack is not empty and the current digit is less than the top of the stack
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                // Remove the top of the stack
                stack.pop();
                // Decrement k since we removed a digit
                k--;
            }
            // Push the current digit onto the stack
            stack.push(digit);
        }
        
        // if not popped  any k digits, and if k is still greater than 0, remove the remaining digits from the end of the stack 
        //as it ccould it a monotonic stack in inc order so remove the last k digits
        while (k > 0) {
            stack.pop();
            k--;
        }
        // Construct the result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        
        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        
        return result.toString();
    }
}