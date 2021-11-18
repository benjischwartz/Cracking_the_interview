class IsPalindrome {
    public boolean isPalindrome(int x) {
        String y = String.valueOf(x);
        for (int i = 0; i < y.length(); i++) {
            if (y.charAt(i) != y.charAt(y.length() - (i + 1))) return false;
        }
        return true;
    }
}
