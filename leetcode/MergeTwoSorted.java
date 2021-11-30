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
        
        else if (l2 == null) {
            return l1;
        }
        
        ListNode head = new ListNode();
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
       
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            ListNode temp = null;
            if (l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            } else {
                temp = l2;
                l2 = l2.next;
            }
            tail.next = temp;
            tail = temp;
        }
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }
        return head;
    }
}
