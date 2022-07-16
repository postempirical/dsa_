class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0;
        int max = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            
            // if map has char, inc its freq else initiate as 1
            if (map.containsKey(c)) 
                map.put(c, map.get(c) + 1);
            else map.put(c, 1);      
            
            int count = map.size();
            
            // if size is x and window size is also x 
            // this implies they are all unique
            if (count == end - begin + 1) 
                max = Math.max(max, end - begin + 1);
         
            // if map size is less then window size
            // it implies there are extra chars in window
            if (count < end - begin + 1) {
                // keep removing from start and dec the freq
                // also if freq gets 0, remove elem to dec size
                while (count < end - begin + 1) {
                    char temp = s.charAt(begin);
                    if (map.containsKey(temp))
                        map.put(temp, map.get(temp) - 1);
                    if (map.get(temp) == 0)
                        map.remove(temp);
                    begin++;
                }
            }
            end++;
        }
        return max;
    }
}
