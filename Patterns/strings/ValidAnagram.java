class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> map = new HashMap<>();
        
        // increase freq by 1 for string s and decrease by 1 for string t
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        
        // in the end freq of each key must be 0, otherwise not an anagram
        for(char c : map.keySet())
            if(map.get(c) != 0) return false;
        
        return true;
    }
}
