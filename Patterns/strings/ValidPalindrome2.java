class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            // if values are inequal
            if (s.charAt(i) != s.charAt(j)) {
                // check if other ranges ahead are palindrome or not
                // recursive keep going on both ends
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            // if chars are equals simply move to next values
            i++;
            j--;
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
