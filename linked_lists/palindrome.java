import java.lang.*;

public class palindrome {

    public static boolean isPalindrome(Node head) {
        // 1->2->3->4->4->3->2->1
        // If length % 2 == 0: Check that list up to length/2 is reverse of length/2+1 to length
        //
        // 1->2->3->4->3->2->1
        // If length % 2 != 0: Check that list up to length/2 - 1 is reverse of length/2 + 1 to length
        //
        // Initialise two arrays of size Math.floor(length/2)
        
        Node copy = head;
        int length = 0;
        while (copy != null) {
            length++;
            copy = copy.getNext();
        }

        int mid = (int) Math.floor(length/2);
        int []firstHalf = new int[mid];
        int []secondHalf = new int[mid];

        copy = head;
        if (length % 2 == 0) {
            for (int i = 0; i < mid; i++) {
                firstHalf[i] = copy.getData();
                copy = copy.getNext();
            }

            for (int i = 0; i < mid; i++) {
                secondHalf[i] = copy.getData();
                copy = copy.getNext();
            }
        }
        
        else {
            for (int i = 0; i < mid; i++) {
                firstHalf[i] = copy.getData();
                copy = copy.getNext();
            }
            // Skip over middle value
            copy = copy.getNext();
            for (int i = 0; i < mid; i++) {
                secondHalf[i] = copy.getData();
                copy = copy.getNext();
            }
        }

        // Compare the two arrays
        for (int i = 0; i < mid; i++) {
            if (firstHalf[i] != secondHalf[mid - (i + 1)]) {
                return false;
            }
        }
        return true;
    }

    public static void printLinkedList(Node n) {
        while (n.getNext() != null) {
            System.out.print(n.getData());
            System.out.print("-->");
            n = n.getNext();
        }
        System.out.println(n.getData());
    }
 
    public static void main(String args[]) {
        Node head = new Node(1);
        head.appendToTail(2);
        head.appendToTail(3);
        head.appendToTail(4);
        head.appendToTail(3);
        head.appendToTail(2);
        head.appendToTail(1);
        printLinkedList(head);
        System.out.println(isPalindrome(head));
    }
}




