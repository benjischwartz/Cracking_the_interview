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
class BinTreeMaxDepth {
    public int maxDepth(TreeNode root) {
        int max = 0;
        if (root == null) {
            return max;
        }
        else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}
