class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        
        int count = map.size();
        
        int begin = 0, end = 0;
        int head = 0; // pointer for start of substring
        int len = Integer.MAX_VALUE; // head + len = result
        
        while (end < s.length()) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }
            end++;
            
            while (count == 0) {
                char temp = s.charAt(begin);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) > 0) count++;
                }
                
                // MAIN CONDITION
                if (end - begin < len) {
                    len = end - begin;
                    head = begin;
                }
                begin++;
            }
        }
        if (len == Integer.MAX_VALUE) return "";
        return s.substring(head, head + len);
    }
}
