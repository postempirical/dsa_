// https://leetcode.com/problems/find-all-anagrams-in-a-string/
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // s is a word, p is the pattern
        List<Integer> res = new ArrayList<>();
        
        // // character hash
        // using this to track if window fits pattern later on
        HashMap<Character, Integer> map = new HashMap<>();
        
        // make a character, its frequency map
        // for (int i = 0; i < p.length(); i++) {
        //     if (map.containsKey(p.charAt(i)))
        //         map.put(p.charAt(i), map.get(p.charAt(i) + 1));
        //     else map.put(p.charAt(i), 1);
        // }
        // why tf is this showing runtime error
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
