import java.util.*;
import java.lang.*;

public class PermWithoutDups {
    
    // base case:
    // if input.length() == 1 {
    //      return [input]
    // }
    //
    // else {
    //      return permutations(firstLetter, permwithoutdups(stringWithoutFirstLetter));
    // }


    public static List<String> PermWithoutDups(String input) {
        List<String> returnList = new ArrayList<String>();
        
        // base case
        if (input.length() == 1) {
            returnList.add(input);
            return returnList;
        }

        // recursive case
        else {
            // get first letter
            char ch = input.charAt(0);

            // trim string
            char[] updatedArr = new char[input.length() - 1];
            input.getChars(1, input.length(), updatedArr, 0);
            String updatedStr = new String(updatedArr);

            returnList.addAll(charStringPerms(ch, PermWithoutDups(updatedStr)));
        }
        return returnList;
    }
    
    public static List<String> charStringPerms(char ch, List<String> strings) {
        List<String> newStringList = new ArrayList<String>();
        for (int i = 0; i < strings.size(); i++) {
            String curr = strings.get(i);
            for (int j = 0; j < (curr.length() + 1); j++) {
                String newString = addChar(strings.get(i), ch, j);
                newStringList.add(newString);
            }
        }
        return newStringList;
    }

    public static String addChar(String str, char ch, int position) {
        
        int len = str.length();
        char[] updatedArr = new char[len + 1];
        str.getChars(0, position, updatedArr, 0);
        updatedArr[position] = ch;
        str.getChars(position, len, updatedArr, position + 1);
        return new String(updatedArr);
    }

    public static void main (String[] args) {
        
        System.out.println(PermWithoutDups(args[0]));
    }
}




