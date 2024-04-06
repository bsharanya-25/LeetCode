class Solution {
    public String minRemoveToMakeValid(String s) {
       Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        // Create a boolean array to mark characters for removal
        boolean[] remove = new boolean[s.length()];

        // Iterate through the string to mark invalid closing parentheses
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i); // Push index of opening parentheses onto stack
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Pop matching opening parentheses
                } else {
                    remove[i] = true; // Mark invalid closing parentheses for removal
                }
            }
        }

        // Mark remaining unmatched opening parentheses for removal
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }

        // Build result string excluding marked characters
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();

    }
}