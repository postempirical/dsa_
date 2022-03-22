// https://leetcode.com/problems/longest-palindromic-substring/
class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
						// place both at the cureent char
            int left = i, right = i;
            char c = s.charAt(i);
            
						// updation for even char 
            while (left >= 0 && s.charAt(left) == c) left--;
            while (right < s.length() && s.charAt(right) == c) right++;
            
						// check palindrome in range of current l,r
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
            }
					
						// get them in actual range
            left = left + 1;
            right = right - 1;
            
						// update max
            if (end - start < right - left) {
                start = left;
                end = right;
            }
        }
        return s.substring(start, end + 1);
    }
}
