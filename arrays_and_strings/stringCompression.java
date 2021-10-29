import java.util.*;
import java.lang.*;

public class stringCompression {
        public static void compress(String inputStr) {
                int counter = 0;
                String compressed = "";
                for (int i = 0; i < inputStr.length(); i++) {
                        counter++;
                        if ((i+1 >= inputStr.length()) || (inputStr.charAt(i+1) != inputStr.charAt(i))) {
                            compressed += "" + inputStr.charAt(i) + counter;
                            counter = 0;
                        }
                        if (compressed.length() >= inputStr.length()) {
                            System.out.println(inputStr);
                            return;
                        }
                }

                System.out.println(compressed);
        }

        public static void main(String args[]) {
            compress("HHhhhhiiiitheeeeeere");
        }
}








