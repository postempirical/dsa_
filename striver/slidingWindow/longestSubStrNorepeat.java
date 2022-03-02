// https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int mx = 0;
        
        while (j < s.length()) {
            // if map has char, inc its freq else initiate as 1
            if (map.containsKey(s.charAt(j))) 
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            else map.put(s.charAt(j), 1);
            
            // if size is x and window size is also x 
            // this implies they are all unique
            if (map.size() == j - i + 1) {
                mx = Math.max(mx, j - i + 1);
            }
            
            // if size is less then window size
            // it implies there are extra chars in window
            if (map.size() < j - i +1) {
                // keep removing from start and dec the freq
                // also if freq gets 0, remove elem to dec size
                while (map.size() < j - i + 1) {
                    if (map.containsKey(s.charAt(i)))
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return mx;
    }
}
