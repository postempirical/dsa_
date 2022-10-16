class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome. length() == 1) return "";
        char[] c = palindrome.toCharArray();
        
        // if we find any non-a value, replace it with a and return
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (c[i] != 'a') {
                c[i] = 'a';
                return new String(c);
            }
        }
        // if no non-a value found, this means string is like aa, aaa...
        // so replace last a with b
        c[palindrome.length() - 1] = 'b';
        return new String(c);
    }
}

// let's think about n = 2 case, e.g. "bb"
// in this case, to acheive the lexicographically smallest one
// we should replace from the left and the best character to use is "a"
// for "bb", we replace the first "b" to "a" to become "ab"
        
// let's think about another n = 2 case, e.g. "aa"
// in this case, to acheive the lexicographically smallest one
// we should replace from the left and the best character to use is "a"
// however, for "aa", we cannot use "a" here and the best character to use is "b" now
// for "aa", we replace the second "a" to "b" to become "ab"
// why not replace the first "a"? because "ba" is not smallest.
