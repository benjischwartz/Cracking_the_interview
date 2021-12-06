// You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values 
// of the kth node from the beginning and the kth node from the 
// end (the list is 1-indexed).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class SwapNodesLL {
    public ListNode swapNodes(ListNode head, int k) {
        int length = getLength(head);
        
        ListNode temp1 = head;
        int tempVal;
        for (int i = 0; i < length - k; i++) {
            temp1 = temp1.next;
        }
        tempVal = temp1.val;
        
        ListNode temp2 = head;
        int tempValTwo;
        for (int j = 0; j < k - 1; j++) {
            temp2 = temp2.next;
        }
        tempValTwo = temp2.val;
        
        temp1.val = tempValTwo;
        temp2.val = tempVal;
        
        return head;
    }
    
    public int getLength(ListNode head) {
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
