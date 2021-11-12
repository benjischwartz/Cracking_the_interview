// Given the head of a singly linked list where elements are sorted 
// in ascending order, convert it to a height balanced BST.

// For this problem, a height-balanced binary tree is defined as a 
// binary tree in which the depth of the two subtrees of every node 
// never differ by more than 1.


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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class ListToBST {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        // build a list from linked list
        List<ListNode> NodeList = new ArrayList<ListNode>();
        while (head != null) {
            NodeList.add(head);
            head = head.next;
        }

        return buildBST(NodeList, 0, NodeList.size() - 1);

    }

    public TreeNode buildBST(List<ListNode> NodeList, int lo, int hi) {

        // base case
        if (lo > hi) {
            return null;
        }

        int mid = (lo + hi)/2;
        TreeNode root = new TreeNode(NodeList.get(mid).val);
        root.left = buildBST(NodeList, lo, mid - 1);
        root.right = buildBST(NodeList, mid + 1, hi);

        return root;
    }
}
