class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int begin = 0, end = 0;
        int mostFrequent = 0, max = 0;
        
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            mostFrequent = Math.max(mostFrequent, map.get(c));
            
            // no. of other characters = window size - len of most frequent
            // it is the no of chars that we need to replace 
            // to match the most frequent character in the window 
            int others = (end - begin + 1) - mostFrequent;
            
            // current window BABB
            // most frequent = 3 (B)
            // others = windows size - most frequent = 4 - 3 = 1
            // so we need to replace 1 char to make entire window of B
            
            // others cannot be more than k
            // need to slide begin if it happens
            if (others > k) {
                char temp = s.charAt(begin);
                map.put(temp, map.get(temp) - 1);
                begin++;
            }
            
            // calculate max windows size
            max = Math.max(max, end - begin + 1);
            end++;
        }
        return max;
    }
}
