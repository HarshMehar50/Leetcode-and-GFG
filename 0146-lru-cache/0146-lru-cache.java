class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key , int value){
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(0 , 0);
    Node tail = new Node(0 , 0);
    HashMap<Integer , Node> map = new HashMap<>();
    int size;
    public LRUCache(int capacity) {
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    void insert(Node node){
        map.put(node.key , node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        remove(map.get(key));
        if(map.size() == size)
        remove(tail.prev);
        insert(new Node(key , value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */