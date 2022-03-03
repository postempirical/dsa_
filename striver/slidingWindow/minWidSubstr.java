// https://leetcode.com/problems/minimum-window-substring/
class Solution {
    public String minWindow(String s, String t) {
        // corner cases
        if(s == null || t == null 
           || s.length() == 0 
           || t.length() == 0 || s.length() < t.length()) 
            return "";
        
        int min = s.length();
        String ans = "";
        int i = 0, j = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        int count = t.length(); // the number of characters that I need to match
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        while(j < s.length()){
            char c = s.charAt(j);
            
            // if map has key, dec the freq
            // if freq gets 0 dec count
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) >= 0) count--; 
            }
            
            // we will have a possible ans
            // when count get 0
            while(count == 0 && i <= j){
                if(count == 0 && j - i + 1 <= min) {
					ans = s.substring(i,j + 1);
					min =  j -i + 1 ;
					}
                
                // shrink left pointer 
                // keep shrinkin as long as count stays 0
                char ch = s.charAt(i);
                if(map.containsKey(ch)){
                    map.put(ch, map.get(ch) + 1);
                    if(map.get(ch) >= 1) count++;
                }
                i++;
            } 
            j++;
        }
        return ans;
    }
}
