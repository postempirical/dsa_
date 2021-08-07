class LRUCache {
    
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    Map<Integer, Node> map = new HashMap();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
       if (map.containsKey(key)) {
           Node node = map.get(key);
           remove(node); // remove from its original pos
           insert(node); // then insert to new pos
           return node.value;
       } 
       else return -1; // key not found
    }
    
    public void put(int key, int value) {
       // if key present remove it from there and then insert it at new pos
       if (map.containsKey(key)) {
           remove(map.get(key));
       } 
       if(map.size() == capacity) {
           remove(tail.prev);
       }
       insert(new Node(key,value));
    }
    
    private void remove (Node node) {
        map.remove(node.key);
        node.prev.next = node.next; // A <-> N <-> C
        node.next.prev = node.prev;
    }
    
    private void insert(Node node) { // <-N->, H <-> B <-> C
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node; 
        node.prev = head;
        head.next = node;
    }
    
    class Node {
        Node prev, next;
        int key, value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
