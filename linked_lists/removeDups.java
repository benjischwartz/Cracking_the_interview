import java.util.*;

public class removeDups {

    public static Node removeDups(Node n) {
        
        HashSet<Integer> unique = new HashSet<>();
        
        // loop through linked list and add all data to a HashSet 
        Node nItr = n.getNext();
        while (nItr != null) {
            unique.add(nItr.getData());
            nItr = nItr.getNext();
        }

        // reconstruct linked list with unique elements
        Iterator<Integer> itr = unique.iterator();
        Node newList = new Node(n.getData());
        itr.next(); // move past first element
        while (itr.hasNext()) {
            newList.appendToTail(itr.next());
        }
        return newList;
    }

    public static void printLinkedList(Node n) {
        while (n.getNext() != null) {
            System.out.print(n.getData());
            System.out.print("-->");
            n = n.getNext();
        }
        System.out.println(n.getData());
    }
    
    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            nodeOne.appendToTail(rand.nextInt(100));
        }
        printLinkedList(nodeOne);
        System.out.println("-------------------------------------");
        nodeOne = removeDups(nodeOne);
        printLinkedList(nodeOne);
    }

    
}





