import java.lang.*;
import java.util.*;


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
                this.tail.next = null;
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
            node.prev = null;
            this.head.prev = node;
            node.next = this.head;
            this.head = node;
        }
        
        // At capacity. Remove LRU key
        else {
            if (capacity == 1) {
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                map.remove(head.key);
                head = node;
                tail = node;
            }
            else {
                if (tail.prev != null) {
                    tail.prev.next = null;
                    map.remove(tail.key);
                    this.tail = tail.prev;
                    System.out.println("Removing tail!");
                }
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                node.next = this.head;
                this.head = node;
            }
        }
    }
    public void printCache() {
        System.out.println("Printing Cache:");
        ListNode curr = this.head;
        while (curr != null) {
            System.out.print("Node Key: ");
            System.out.print(curr.key);
            System.out.print(" Node Value: ");
            System.out.println(curr.value);
            curr = curr.next;
        }
        System.out.print(" Tail Key: ");
        System.out.println(tail.key);
        System.out.print(" Map Size: ");
        System.out.println(map.size());
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(2);
        cache.printCache();
        cache.put(3, 3);
        cache.printCache();
        cache.put(4, 4);
        cache.printCache();
        cache.get(1);
        cache.printCache();
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
