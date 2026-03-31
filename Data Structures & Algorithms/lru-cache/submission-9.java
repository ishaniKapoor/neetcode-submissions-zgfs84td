class ListNode {
    int val;
    int key;
    ListNode prev;
    ListNode next;

    public ListNode(int val, int key){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {

    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode n = map.get(key);
        removeNode(n);
        moveToHead(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            removeNode(map.get(key));
        }

        ListNode node = new ListNode(value, key);
        map.put(key, node);
        moveToHead(node);
        if (map.size() > this.capacity){
            ListNode lru = tail.prev;
            removeNode(lru);
            map.remove(lru.key);
        }
    }

    void removeNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void moveToHead(ListNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
