class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        char head, tail;
        while (start < end) {
            head = s.charAt(start);
            tail = s.charAt(end);
            // skip if not a letter or digit
            if (!Character.isLetterOrDigit(head)) start++;
            else if (!Character.isLetterOrDigit(tail)) end--;
            // if valid then check for ineqality 
            // if equal continue to next character else return false
            else 
            {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) 
                    return false;
                start++;
                end--;
            }
        }
        return true;
    }
}
