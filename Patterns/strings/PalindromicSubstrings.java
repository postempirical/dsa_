class Solution {
    int count = 1;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            checkPalin(s, i, i); // for odd lengths
            checkPalin(s, i, i + 1); // for even lengths
        }
        return count;
    }
    
    private void checkPalin(String s, int left, int right) {
        // should be within range and letters must be same
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
