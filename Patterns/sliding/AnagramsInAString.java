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
        }
        return res;
    }
}


// av approach
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // s is a word, p is the pattern
        List<Integer> res = new ArrayList<>();
        
        // // character hash
        // using this to track if window fits pattern later on
        HashMap<Character, Integer> map = new HashMap<>();
        
        // make a character, its frequency map
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        // map size will give total no of unique chars
        int count = map.size();
        int i = 0, j = 0;
        
        while (j < s.length()) {
            // if same char, dec its freq
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                // decrease count if freq gets 0
                if (map.get(s.charAt(j)) == 0) count--;   
            }
            
            if (j - i + 1 == p.length()) {
                // adding start index if anagram found
                if (count == 0) res.add(i);
                    
                // now update for next window
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) == 1) count++;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
