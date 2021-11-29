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
class SortList {

    public ListNode sortList(ListNode head) {
        return head;
    }
    
    public static ListNode merge(ListNode head1, ListNode head2) {
        
        // Find the minimum node of the two heads
        ListNode returnHead;
        if (head1.val < head2.val) {
            returnHead = head1;
            head1 = head1.next;
        } else {
            returnHead = head2;
            head2 = head2.next;
        }
        
        // Merge the two sorted LL's
        while (head1 != null && head2 != null) {
            
            System.out.println("here!");
            if (head1.val < head2.val) {
                appendToTail(returnHead, head1);
                head1 = head1.next;
            } else {
                appendToTail(returnHead, head2);
                head2 = head2.next;
            }
        }

        return returnHead;
    }

    public static void appendToTail(ListNode head, ListNode node) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        System.out.println("Appending!");
        temp.next = node;
    }
    
    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(4, node1);
        ListNode node3 = new ListNode(1, node2);
        
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(3, node4);
        ListNode node6 = new ListNode(2, node5);
        
        ListNode returnNode = merge(node3, node6);
        while (returnNode != null) {
            System.out.print(returnNode.val);
            System.out.print("--> ");
            returnNode = returnNode.next;
        } 
    }
}
