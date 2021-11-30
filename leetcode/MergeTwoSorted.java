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
class MergeTwoSorted {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode();
        if (l1.val <= l2.val) {
            ListNode temp = l1.next;
            head = l1;
            head.next = temp;
        } else {
            ListNode temp = l2.next;
            head = l2;
            head.next = temp;
        }
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                appendToTail(head, l1);
                l1 = l1.next;
            } else {
                appendToTail(head, l2);
                l2 = l2.next;
            }    
        }
        if (l1 != null) {
            appendToTail(head, l1);
        } else if (l2 != null) {
            appendToTail(head, l2);
        }
        return head;
    }
    
    public void appendToTail(ListNode head, ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
}
