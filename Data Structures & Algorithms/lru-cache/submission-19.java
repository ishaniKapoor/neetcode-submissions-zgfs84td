class ListNode {
    int key;
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {

    int capacity;
    HashMap<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

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
        else {
            ListNode node = map.get(key);
            removeNode(node);
            moveToHead(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            removeNode(node);
            moveToHead(node);
            return;
        }

        ListNode node = new ListNode(key, value);
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
