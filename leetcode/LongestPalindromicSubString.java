class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        // For every char in s, calculate the longest palindrome
        // which has that letter in the center. 
        // Keep track of a 'max' variable, and if this is exceeded, 
        // the 'max' palindrome is updated, and so is 'max'.
        
        int maxLength = 0;
        String maxPalindrome = new String();
        
        for (int i = 0; i < s.length(); i++) {
            
            int upper = i;
            int lower = i;
            StringBuilder palindrome = new StringBuilder();
            
            while (upper < s.length() && lower >= 0) {
                if (s.charAt(upper) == s.charAt(lower)) {
                    
                    // initial case (will only happen once)
                    if (upper == lower) {
                        palindrome.append(s.charAt(lower));
                    } 
                    
                    // we can extend the palindrome
                    else {
                        palindrome.insert(0, s.charAt(lower));
                        palindrome.append(s.charAt(upper));
                    }       
                }
                
                // walk out the upper and lower
                upper++;
                lower--;
            }
            
            // If substring all one letter, check corner cases
            
            // Check upper:
            if (upper < s.length()) {
                Boolean same = true;
                for (int j = 1; j < palindrome.length(); j++) {
                    if (palindrome.charAt(j) != palindrome.charAt(j - 1)) {
                        same = false;
                    }
                }
                if (same && palindrome.charAt(upper) == palindrome.charAt(upper - 1)) {
                    palindrome.append(palindrome.charAt(upper));
                }
            }
            
            // Check for a new maximum
            String palString = palindrome.toString();
            if (palString.length() > maxLength) {
                maxPalindrome = palString;
                maxLength = palString.length();
            }
        }
        return maxPalindrome;
    }
}
