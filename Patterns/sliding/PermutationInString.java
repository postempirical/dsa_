class Solution {
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> res = new LinkedList<>();
        
        // character-frequency hashmap of given string
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // total entries in map
        int count = map.size();
        
        int begin = 0, end = 0;
        
        while (end < s2.length()) {
            // get current character
            char c = s2.charAt(end);
            
            // update map and count
            if( map.containsKey(c) ) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            end++;
            
            // if count is 0, pattern matched
            // now re-update map, count before moving begin
            while(count == 0){
                char tempc = s2.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        count++;
                    }
                    if(end - begin == s1.length()) 
                        return true;
                }
                begin++;
            }
        }
        return false;
    }
}
