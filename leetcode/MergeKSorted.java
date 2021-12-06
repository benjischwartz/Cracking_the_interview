class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Iterate through array, merge each subsequent array element with the next
        if (lists.length == 0) {
            return null;
        }
        ListNode curr = lists[0];
        for (int arrItr = 1; arrItr < lists.length; arrItr++) {
            curr = mergeTwoLists(curr, lists[arrItr]);            
        }
        return curr;
    }
    
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
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        } else if (l2 != null) {
            tail.next = l2;
        }
        return head;
    }
}
