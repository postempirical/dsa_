// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        // from every index we expand to both left and right simulataneously
        // we keep going till chars are equal
        // as soon as an expansion ends, we check for max
        // for odd palins -> b a [b] a d
        // for even palin -> a b [b] [b] b d
        String maxstring = "";
        int start, end;
        for (int i = 0; i < s.length(); i++) {
            // odd length palindromes
            start = i; end = i;
            String s1 = expand(start, end, s);
            
            // even length palindromes
            start = i; end = i + 1;
            String s2 = expand(start, end, s);
            
            // if lengths receinved are greater than max, update result
            if (s1.length() > maxstring.length()) maxstring = s1;
            if (s2.length() > maxstring.length()) maxstring = s2;
        }
        return maxstring;
    }
    
    private String expand(int start, int end, String str) {
        while (start >= 0 && end < str.length()) {
            if (str.charAt(start) != str.charAt(end)) break;
            start--; end++;
        }
        return str.substring(start + 1, end);
    }
}
