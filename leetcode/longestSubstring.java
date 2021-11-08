import java.lang.*;

class longestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        int max = 0;
        int left = 0;
        int right = 1;
        
        set.add((int) s.charAt(left));
        while (left < s.length()) {
            while (right < s.length() && !set.contains((int) s.charAt(right))) {
                set.add((int)s.charAt(right));
                if (max < (right - left) + 1) {
                    max = right - left + 1;
                }
                right++;
            }
            set.remove((int) s.charAt(left));
            left++;
        }
        return max;
    }   
}
