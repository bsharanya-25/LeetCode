
class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        // Rotate the elements to maintain the order like a stack
        for (int i = 0; i < size; i++) 
            queue.offer(queue.poll());
        
    }

    public int pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.poll();
    }

    public int top() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
