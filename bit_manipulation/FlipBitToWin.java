// You have an integer and you can flip exactly one bit from a 0 to a 1. 
// Write code to find the length of the longest sequence of 1s you 
// could create.

import java.lang.*;
public class FlipBitToWin {

    public static int GreatestLength(int input) {
        // Find the greatest length of consecutive bits with exactly ONE zero
        // and the rest of the bits are ones. 
        //
        // Approach: Double iteration approach.
        // 
        // max = 0;
        // zeroCount = 0;
        // left = right = input[0] 
        // While left < input.length():
        //      While (zeroCount < 2):
        //           left++;
        //           max = max(max, left - right);
        //      if (input[right] == 0) {
        //           zeroCount--;
        //      }
        //      right++;
    
        int max = 0;
        int zeroCount = 0;
        int left = 0;
        int right = 0;
        int length = getLength(input);
        
        if ((input & 1) == 0) {
            zeroCount++;
        }
        while (left < length) {
           while (zeroCount < 2) {
               left++;
               if (((1 << left) & input) == 0) {
                       zeroCount++;
               }
               max = Math.max(left - right, max);
           }
           if (((1 << right) & input) == 0) {
               zeroCount--;
           }
           right++;
        }
        return max;
    }

    public static int getLength(int input) {
        int length = 0;
        while (input != 0) {
            length++;
            input = input >> 1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(GreatestLength(1775));

        System.out.print("Length: ");
        System.out.println(getLength(1775));
        System.out.println(GreatestLength(0)); 
    }
}
