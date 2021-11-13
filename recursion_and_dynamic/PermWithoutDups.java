import java.util.*;
import java.lang.*;

public class PermWithoutDups {
    public static List<String> PermWithoutDups(String input) {
        List<String> newStringList = new ArrayList<String>();
        if (input.isEmpty()) {
           return newStringList;
        }

        String curr = Character.toString(input.charAt(0));
        // for (int i = 0; i < newStringList.size(); i++) {
        //    for (int j = 0; j < newStringList.)
        //    String newString = newStringList.get(i).concat(curr);
        //    newStringList.add(newString);
        // }
        newStringList.add(curr);
        
        // remove character from the String
        String newString = input.substring(1);
        newString.trim();
        newStringList.addAll(PermWithoutDups(newString));
        return newStringList;
    }

    public static List<String> ListCharPerms(String letter, List<String> stringList) {
        List<String> returnList = new List<String>();
        for (int i = 0; i < stringList.size(); i++) {
            String curr = stringList.get(i);
            for (int j = 0; j < curr.length(); j++) {
                returnList.add(addChar(curr, letter.get(0), j));
            }
        }
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
        
        String[] strArray = {"one", "two", "three"};
        System.out.println(ListCharPerms("a", strArray); 
    }
}




