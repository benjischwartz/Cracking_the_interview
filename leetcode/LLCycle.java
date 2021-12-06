// Given head, the head of a linked list, determine if the linked 
// list has a cycle in it.

// There is a cycle in a linked list if there is some node in the 
// list that can be reached again by continuously following the 
// next pointer. Internally, pos is used to denote the index of 
// the node that tail's next pointer is connected to. Note that 
// pos is not passed as a parameter.

// Return true if there is a cycle in the linked list. 
// Otherwise, return false.



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
public class LLCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode itr1 = head.next;
        int innerPos = 0;
        int outerPos = 1;
        while (itr1 != null) {
            ListNode itr2 = head;
            innerPos = 0;
            while (itr2 != null && innerPos < outerPos) {
                if (itr1.next == itr2) {
                    return true;
                }
                itr2 = itr2.next;
                innerPos++;
            }
            itr1 = itr1.next;
            outerPos++;
        }
        return false;
    }
}
