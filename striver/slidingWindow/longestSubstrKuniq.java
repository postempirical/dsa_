// https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1/
class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int mx = -1;
        
        while (j < s.length()) {
            // char ch = s.charAt(j);
            // if map has ch inc its freq else put 1 
            if (map.containsKey(s.charAt(j))) 
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            else map.put(s.charAt(j), 1);
            
            // if size achieved ie k uniq strings available
            if (map.size() == k) {
                mx = Math.max(mx, j - i + 1);
            }
            
            // need to remove elem if size gets bigger
            if (map.size() > k) {
                // keep removing from start and dec the freq
                // also if freq gets 0, remove elem to dec size
                while (map.size() > k) {
                    if (map.containsKey(s.charAt(i)))
                        map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    if (map.get(s.charAt(i)) == 0)
                        map.remove(s.charAt(i));
                    i++;
                }
            }
            j++;
        }
        return mx;
    }
}
