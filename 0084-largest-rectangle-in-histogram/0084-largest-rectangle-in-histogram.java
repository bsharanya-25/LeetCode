class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();  // empty stack
        int maxArea = 0;                    // storing max area
        int i =0;
        int n = heights.length;

        //Process elements in the heights array
        while(i<n){
            // If the stack is empty 
            // or the current height is greater or equal to the height at the top of the stack
            if(st.isEmpty()|| heights[i]>=heights[st.peek()]){
                st.push(i);                   // Push the current index onto the stack
                i++;                          // Move to the next element
            }else{
                // If the current height is smaller, calculate the width and update maxArea
                int top =  st.pop();
                int width =  st.isEmpty() ? i : i - st.peek() - 1;
                maxArea = Math.max(maxArea, heights[top] * width);
            }
        }
        //Process the remaining elements in the stack
        while(!st.isEmpty()){
            int top = st.pop();
            int width = st.isEmpty() ? heights.length : heights.length - st.peek() - 1;
            maxArea = Math.max(maxArea, heights[top] * width);
        }

        return maxArea;

    }
}