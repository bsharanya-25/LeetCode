class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

        if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32) {
            // If the current character cancels out the top character of the stack
            stack.pop();
        } else {
            // Otherwise, push the current character onto the stack
            stack.push(c);
        }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : stack) {
        sb.append(c);
    }

    return sb.toString();

    }
}
//TC:O(N)
//SC:O(N)

//if (!stack.isEmpty() && Math.abs(stack.peek() - c) == 32

//The ASCII value of 'a' is 97, and the ASCII value of 'A' is 65. 
//The absolute difference between them is |97 - 65| = 32.

//The ASCII value of 'b' is 98, and the ASCII value of 'B' is 66. 
//The absolute difference between them is |98 - 66| = 32.