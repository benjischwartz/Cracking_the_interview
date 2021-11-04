package Cracking_the_interview;

public class listOfDepths {
    // Given a binary tree, design an algorithm which creates a linked list
    // of all the nodes at each depth (eg., if you have a tree with depth D,
    // you'll have D linked lists'). 

    public Node[] listOfDepths(BinTree tree) {
        // perform a BFS
        Queue<Integer> queue = new Queue<Integer>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            if (cur.visited == false) {
                cur.visited = true;
                queue.add(cur.left);
                queue.add(cur.right);
            }
            
        }
    }
}







