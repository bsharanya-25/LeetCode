class StockSpanner {
    private Stack<Integer> prices;  // Stack to store stock prices
    private Stack<Integer> spans;   // Stack to store corresponding spans

    public StockSpanner() {
        prices = new Stack<>();
        spans = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;  // Initialize the span to 1 for the current day

        // While the stack is !empty and the current price is greater than or equal to the previous prices
        while (!prices.isEmpty() && price >= prices.peek()) {
            prices.pop();             // Pop previous prices
            span += spans.pop();       // Accumulate spans
        }

        // Push the current price and its corresponding span onto the stacks
        prices.push(price);
        spans.push(span);

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */