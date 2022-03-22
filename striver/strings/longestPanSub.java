// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i, right = i;
            char c = s.charAt(i);
            
            while (left >= 0 && s.charAt(left) == c) left--;
            while (right < s.length() && s.charAt(right) == c) right++;
            
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
            }
            left = left + 1;
            right = right - 1;
            
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);
    }
}
