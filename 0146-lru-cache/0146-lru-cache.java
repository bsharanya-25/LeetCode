class LRUCache {
    class DlNode{
        int key, value;
        DlNode prev=null, next=null;
        DlNode(){}
        DlNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer,DlNode> cache;
    private int cap;
    private int count;
    private DlNode head, tail;

    private void addNode(DlNode newNode) {
        DlNode nxt = head.next;

        newNode.prev = head;
        newNode.next = nxt;
        head.next = newNode;
        nxt.prev = newNode;
    }

    private void removeNode(DlNode node) {
       DlNode pre = node.prev;
        DlNode nxt = node.next;
        pre.next = nxt;
        nxt.prev = pre; 
    }
    private DlNode delFromTail() {
        DlNode preTail = tail.prev;
        
        tail.prev = preTail.prev;
        preTail.prev.next = tail;
        
        return preTail;
    }

    private void moveToFront(DlNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.cap = capacity;
        this.count = 0;
        head = new DlNode();
        tail = new DlNode();

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       DlNode res = this.cache.get(key);
       if(res == null) return -1;

       this.moveToFront(res);
       return res.value;
    }
    
    public void put(int key, int value) {
        DlNode res = this.cache.get(key);

        if(res == null) {
            DlNode newNode = new DlNode(key, value);
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;

            if(count > cap) {
                DlNode del = this.delFromTail();
                this.cache.remove(del.key);
                --count;
            }

        } else {
            res.value = value;
            this.moveToFront(res);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */