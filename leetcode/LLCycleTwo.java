/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LLCycleTwo {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode itr1 = head.next;
        int innerPos = 0;
        int outerPos = 1;
        while (itr1 != null) {
            ListNode itr2 = head;
            innerPos = 0;
            while (itr2 != null && innerPos < outerPos) {
                if (itr1.next == itr2) {
                    return getNode(head, innerPos);
                }
                itr2 = itr2.next;
                innerPos++;
            }
            itr1 = itr1.next;
            outerPos++;
        }
        return null;
    }
    
    public ListNode getNode(ListNode head, int pos) {
        int counter = 0;
        while (head != null) {
            if (counter == pos) {
                return head;
            }
            counter++;
            head = head.next;
        }
        return null;
    }
}
