// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?
import java.util.*;

public class isUnique {
        public static void inputTest(){
                System.out.println("Hello");
        }

        // Naive approach
        public static void isUnique(String input) {
                char[] charArray = input.toCharArray();
                for (int i = 0; i < input.length(); i++) {
                        for (int j = 0; j < input.length(); j++) {
                                if ((i != j) && (charArray[i] == charArray[j])) {
                                        System.out.println("Not unique");
                                        return;
                                }
                        }
                }
                System.out.println("Unique");
        }
        public static void isUnique2 (String input) {
            char[] charArray = input.toCharArray();
            boolean[] charSet = new boolean[256];
            for (int i = 0; i < 256; i++) {
                charSet[i] = false;
            }

            for (int i = 0; i < input.length(); i++) {
                int charToInt = charArray[i];
                if (charSet[charToInt]) {
                        System.out.println("Not unique");
                        return;
                }
                charSet[charToInt] = true;
            }
            System.out.println("Unique");
        }

        public static void main(String[] args) {
                isUnique("Hello");
                isUnique("abcdefghjiklmnopqrstuvwxyz");
                isUnique("Unique");
                isUnique("aabbccdd");
                isUnique2("Hello");
                isUnique2("abcdefghjiklmnopqrstuvwxyz");
                isUnique2("Unique");
                isUnique2("aabbccdd");
        }
}
