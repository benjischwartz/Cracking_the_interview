import java.util.*;

public class removeDups {

    public static Node removeDups(Node n) {
        
        HashSet<Integer> unique = new HashSet<>();
        
        // loop through linked list and add all data to a HashSet 
        while (n != null) {
            unique.add(n.data);
            n = n.next;
        }

        // reconstruct linked list with unique elements
        Iterator<Integer> itr = unique.iterator();
        Node newList = new Node(n.data);
        itr.next(); // move past first element
        while (itr.hasNext()) {
            newList.appendToTail(itr.next());
        }
        return newList;
    }

    public static void printLinkedList(Node n) {
        while (n != null) {
            System.out.print(n.data);
            System.out.print("-->");
            n = n.next;
        }
    //    System.out.println(n.data);
    }
    
    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        nodeOne.appendToTail(2);
        nodeOne.appendToTail(3);
        printLinkedList(nodeOne);
    }
}





