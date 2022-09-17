class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // strs = ["eat","tea","tan","ate","nat","bat"]
        // map of freq map and arraylist of strings
        // e1a1t1 --> eat / tea / ate
        // t1a1n1 --> tan / nat
        // b1a1t1 --> bat
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        
        for (String s : strs) {
            HashMap<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            
            // if main map does not contains freq then create new list and add s
            // else just add s to already created list
            if (!map.containsKey(freq)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                map.put(freq, list);
            }
            else {
                ArrayList<String> list = map.get(freq);
                list.add(s);
            }
        }
        
        // now just get all list values and insert into new list
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
