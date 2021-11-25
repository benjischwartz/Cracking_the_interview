class LRUCache {

    int capacity;
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    
    // Linked List node
    public class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;        
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            
            ListNode curr = map.get(key);
            
            // curr is the head of list
            if (curr.prev == null) {
                return curr.value;
            }
            
            // curr is the tail of the list
            else if (curr.next == null) {
                curr.prev.next = null;
                curr.next = this.head;
                this.tail = curr.prev;
                curr.prev = null;
                this.head = curr;
                return curr.value;
            }
            
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            curr.next = this.head;
            curr.prev = null;
            this.head = curr;
            return curr.value;         
            
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        // Simply update the value of the node
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;
            // move to top of LL
            this.get(key);
        }
        
        // List is currently empty
        else if (map.size() == 0) {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            tail = node;
            head = node;
            node.next = null;
            node.prev = null;
        }
        
        // Below capacity, just add to front of LL
        else if (map.size() < capacity) {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            node.next = this.head;
            this.head = node;
        }
        
        // At capacity. Remove LRU key
        else {
            if (capacity == 1) {
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                head = node;
                tail = node;
            }
            else {
                ListNode oldTail = this.tail;
                map.remove(oldTail.key);
                System.out.println("Removing Tail!");
                System.out.println(oldTail.key);
                if (oldTail.prev != null) {
                    this.tail = oldTail.prev;
                    this.tail.next = null;
                }
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                node.next = this.head;
                this.head = node;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
