class Solution {
    public int strStr(String haystack, String needle) {
        // helloxx, llo
        // if remainnig len in hay is less than needle, no need to go ahead
        // so only loop till len(hay)-len(needle)
        // break if unequal
        // if j reached needle, we found a complete string
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}
