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

// Thinking:
// Start at root node.
// Recursive function --
// While(left.total > right.total): 
//      BFS in right child until we find a coin
//      Bubble coin up to root node
// Distribute root.val evenly into left and right child, leaving one at root node
// recurse with left and right node respectively
class DistributeCoins {
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftTotal = 0;
        int rightTotal = 0;
        int minMoves = 0;
        int bubbleAmount = 0;
        
        if (root.left != null) {
            leftTotal = getTotal(root.left);
            System.out.println("here");
        }
        if (root.right != null) {
            rightTotal = getTotal(root.right);
            System.out.println("here");
        }
        
        while (rightTotal > leftTotal) {
            System.out.println("Bubbling");
            bubbleAmount = bubble(root.right);
            minMoves += bubbleAmount;
            root.val += bubbleAmount;
        }
        while (leftTotal > rightTotal) {
            bubbleAmount = bubble(root.left);
            minMoves += bubbleAmount;
            root.val += bubbleAmount;
        }
        
        // At this point, left and right subtrees have equal total value. 
        // Distribute the root.val - 1 evenly between left and right subtrees.
        // First, calculate how much we move
        int moveAmount = (root.val - 1)/2;
        if (moveAmount != 0) {
            root.right.val += moveAmount;
            root.left.val += moveAmount;
            root.val -= 2*moveAmount;
            minMoves += 2;
        }
        
        return (minMoves + distributeCoins(root.left) + distributeCoins(root.right));        
    }
    
    public int bubble(TreeNode root) {
        // we want to bubble from the closest level possible
        // so we use BFS to find the first node with a non-zero val
        // need to store what level this node is on
        return bubbleUtil(root, 0);     
        
    }
    
    // Helper util function for bubble
    public int bubbleUtil(TreeNode root, int level) {
        if (root == null) {
            return 0;
        }       
        
        // Found first non-zero node
        if (root.val != 0) {
            root.val -= 1;
            return level;
        }        
        int downLevel = bubbleUtil(root.left, level + 1);
        if (downLevel != 0) {
            return downLevel;
        }        
        downLevel = bubbleUtil(root.right, level + 1);
        return downLevel;
    }
    
    public int getTotal(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return (root.val + getTotal(root.left) + getTotal(root.right));
    }
    
    // Function to find the number of nodes in the binary tree
    public int getSize(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return (getSize(root.left) + 1 + getSize(root.right));
        }
    }
}
