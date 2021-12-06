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
            l1 = head.next;
        } else {
            head = l2;
            l2 = head.next;
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
        return head;aster -> master
❯ clear
 22 /**
 22  * Definition for singly-linked list.
 22  * public class ListNode {
 22  *     int val;
 22  *     ListNode next;
 22  *     ListNode() {}
 22  *     ListNode(int val) { this.val = val; }
 23  * }
 23  */
 23 class MergeTwoSorted {
 23     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
 23
 23         if (l1 == null) {
 23             return l2;
 23         }
 23
 23         else if (l2 == null) {
 23             return l1;
 23         }
 23
 23         ListNode head = new ListNode();
 23         if (l1.val <= l2.val) {
 23             head = l1;
 23             l1 = l1.next;
 23         } else {
 23             head = l2;
 23             return l2;
 23         }
 23
 23         else if (l2 == null) {
 23             return l1;
 23         }
 23
 23         ListNode head = new ListNode();
 23         if (l1.val <= l2.val) {
 23             head = l1;
 23             l1 = head.next;
 23         } else {
 23             head = l2;
 21             l2 = head.next;
 20         }
 19
 18         ListNode tail = head;
 17         while (l1 != null && l2 != null) {
 16             ListNode temp = null;
 15             if (l1.val <= l2.val) {
 14                 temp = l1;
 13                 l1 = l1.next;
 12             } else {
 11                 temp = l2;
 10                 l2 = l2.next;
  9             }
  8             tail.next = temp;
  7             tail = temp;
  6         }
  5         if (l1 != null) {
  4             tail.next = l1;
  3         } else if (l2 != null) {
  2             tail.next = l2;
  1         }
  0         return head;
  1     }
    }
}
