import java.lang.Math;

class LongestcommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        
        // longest initialised to first string
        String longest = strs[0];
        if (longest.length() == 0) {
            return longest;
        }
        
        // loop through remaining strings, checking the length of longest prefix
        for (int i = 1; i < strs.length; i++) {
            String curr = strs[i];
            int counter = 0;
            if (curr.length() == 0 || (curr.charAt(0) != longest.charAt(0))) {
                return "";
            }
            for (int j = 0; j < Math.min(curr.length(), longest.length()); j++) {
                if (curr.charAt(j) == longest.charAt(j)) {
                    counter++;
                }
                else {
                    break;   
                }
            }
            longest = longest.substring(0, counter);
        }
        return longest;
    }
}
