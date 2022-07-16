class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        if (p.length() > s.length()) return res;
        
        // character-frequency hashmap of given string
        Map<Character, Integer> map = new HashMap<>();
        for(char c : p.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        // total entries in map
        int count = map.size();
        
        int begin = 0, end = 0;
        
        while (end < s.length()) {
            // get current character
            char c = s.charAt(end);
            
            // update map and count
            if( map.containsKey(c) ) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) count--;
            }
            end++;
            
            // if count is 0, pattern matched
            // now re-update map, count before moving begin
            while(count == 0){
                char tempc = s.charAt(begin);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);
                    if(map.get(tempc) > 0){
                        count++;
                    }
                }
                
                if(end - begin == p.length()) 
                    res.add(begin);
                
                begin++;
            }
            // if (end - begin == p.length()) {
            //     if (count == 0) res.add(begin);
            //     char temp = s.charAt(begin);
            //     if (map.containsKey(temp)) {
            //         map.put(temp, map.get(temp) + 1);
            //         if (map.get(temp) > 0) count++;
            //     }
            //     begin++;
            // }
        }
        return res;
    }
}
