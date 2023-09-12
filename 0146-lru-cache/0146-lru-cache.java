class LRUCache {
    class DlNode {
        int key, value;
        DlNode prev, next;

        DlNode() {
            prev = next = null;
        }

        DlNode(int key, int value) {
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }

    private Map<Integer, DlNode> cache;
    private int capacity;
    private int size;
    private DlNode head, tail;

    private void addNode(DlNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DlNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private DlNode removeTail() {
        DlNode tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev;
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        size = 0;
        head = new DlNode();
        tail = new DlNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DlNode node = cache.get(key);
        if (node == null) return -1;
        removeNode(node);
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        DlNode node = cache.get(key);
        if (node == null) {
            if (size >= capacity) {
                DlNode removed = removeTail();
                cache.remove(removed.key);
                size--;
            }
            node = new DlNode(key, value);
            cache.put(key, node);
            size++;
        } else {
            node.value = value;
            removeNode(node);
        }
        addNode(node);
    }
}
