import java.lang.*;

public class palindrome {

    public static bool isPalindrome(Node head) {
        // 1->2->3->4->4->3->2->1
        // If length % 2 == 0: Check that list up to length/2 is reverse of length/2+1 to length
        //
        // 1->2->3->4->3->2->1
        // If length % 2 != 0: Check that list up to length/2 - 1 is reverse of length/2 + 1 to length
        Node copy = head;
        int length = 0;
        while (copy != null) {
            length++;
            copy = copy.getNext();
        }

        Node mid = head;
        while (int i = 0; i < Math.floor(length/2); i++) {
            mid = mid.getNext();
        }

        if (length % 2 == 0) {
                  
        }
        
        else {

        }
    }
}




