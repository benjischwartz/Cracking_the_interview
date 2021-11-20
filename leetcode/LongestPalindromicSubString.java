class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        // For every char in s, calculate the longest palindrome
        // which has that letter in the center.
        // OR has center in between two letters
        // Keep track of a 'max' variable, and if this is exceeded, 
        // the 'max' palindrome is updated, and so is 'max'.
        if (s == null || s.length() < 1) return "";        
        int start = 0, end = 0;        
        for (int i = 0; i < s.length(); i++) {            
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }        
        return s.substring(start, end + 1);
    }
    
    int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
