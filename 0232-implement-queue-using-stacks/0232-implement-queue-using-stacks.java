
class MyQueue {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public MyQueue() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // Add an element to the queue.
    public void push(int x) {
        inputStack.push(x);
    }

    // Remove and return the front element of the queue.
    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        transferInputToOutput();
        return outputStack.pop();
    }

    // Get the front element of the queue without removing it.
    public int peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        transferInputToOutput();
        return outputStack.peek();
    }

    // Check if the queue is empty.
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper method to transfer elements from inputStack to outputStack.
    private void transferInputToOutput() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

}