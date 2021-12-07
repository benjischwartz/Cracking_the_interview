class LevelOrderTraversal {
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        int height = getHeight(root);
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        for (int i = 1; i <= height; i++) {
            levelOrderList.add(getLevel(root, i));
        }
        return levelOrderList;
    }
    
    public List<Integer> getLevel(TreeNode root, int height) {

        
        List<Integer> levelNodes = new ArrayList<Integer>();
        if (root == null) {
            return levelNodes;
        }
        else if (height == 1) {
            levelNodes.add(root.val);
        } else {
            levelNodes.addAll(getLevel(root.left, height - 1));
            levelNodes.addAll(getLevel(root.right, height - 1));
        }
        return levelNodes;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    
}
