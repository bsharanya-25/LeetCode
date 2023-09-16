class BrowserHistory {

    private LinkedList<String> history;
    private int currentIndex;

    public BrowserHistory(String homepage) {
        history = new LinkedList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
        // If we visit a new URL, remove forward history and add the new URL
        while (history.size() > currentIndex + 1) {
            history.removeLast();
        }
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        int newIndex = Math.max(0, currentIndex - steps);
        currentIndex = newIndex;
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        int newIndex = Math.min(history.size() - 1, currentIndex + steps);
        currentIndex = newIndex;
        return history.get(currentIndex);
    }
}
