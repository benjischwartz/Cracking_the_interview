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
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        
        if (head == null || head.next == null) {
            return head;
        }
        
        // Keep track of two linked lists
        // 1) Contains elements < x
        // 2) Contains elements >= x
        
        // Figure out the first ListNode for each list
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode temp = head;
        while (temp != null && (l1 == null || l2 == null)) {
            if (temp.val < x && l1 == null) {
                l1 = temp;
            } else if (temp.val >= x && l2 == null) {
                l2 = temp;
            }
            temp = temp.next;
        }
        // If l1 or l2 is null, then return the other
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        // Set the head of the result
        ListNode head1 = l1;
        l1 = l1.next;
        ListNode head2 = l2;
        l2 = l2.next;
        
        ListNode tail1 = l1;
        ListNode tail2 = l2;
        ListNode itr = head.next;
        while (itr != null) {
            ListNode temp1 = null;
            if (itr.val < x && itr != head1) {
                temp1 = itr;
                tail1.next = temp1;
                tail1 = temp1;
            } else if (itr.val >= x && itr != head2) {
                temp1 = itr;
                tail2.next = temp1;
                tail2 = temp1;
            }
            itr = itr.next;
        }
        tail1.next = head2;
        return head1;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(5, node1);
    }
}
