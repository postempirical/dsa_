class Solution {
    public boolean validPalindrome(String s) {
        // if not equal we can either skip start or end
        // and then check if after skipping, any new range is palindrome
        // m x a d a m
        // x a d a
        // x a d || [a d a] 
        // a d a returns true
        int start = 0, end = s.length() - 1;
        while (start < end) {          
            if (s.charAt(start) != s.charAt(end)) {
                return isPalindrome(start + 1, end, s) || isPalindrome(start, end - 1, s);
            }
            // simply move ahead if equal
            start++;
            end--;
        }
        return true;
    }
    
    private boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
