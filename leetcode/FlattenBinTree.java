class Solution {
    // Pre-order traversal:
    //
    // visit(root)
    // visit(left)
    // visit(right)
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        // temporarily store the nodes
        TreeNode leftTemp = root.left;
        TreeNode rightTemp = root.right;
        
        // set left pointer to null
        root.left = null;
        
        // recurse for left and right subtrees
        flatten(root.left);
        flatten(root.right);
        
        // update right pointer
        root.right = leftTemp;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        } cur.right = rightTemp;      

    }
}
