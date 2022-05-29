class Solution {
    public int maxProduct(String[] words) {
        // maintain a letter inventory to see if two strings have common characters.
        Map<String, int[]> map = new HashMap<>(); 
        for (String word : words) map.put(word, getCount(word));
        
        int max = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) 
                if (isCompatible(words[i], words[j], map))
                    max = Math.max(words[i].length() * words[j].length(), max);
        return max;
    }
    
    private boolean isCompatible(String w1, String w2, Map<String, int[]> map) {
        int[] inv1 = map.get(w1), inv2 = map.get(w2);
        for (int i = 0; i < inv1.length; i++) {
            if (inv1[i] != 0 && inv2[i] != 0) return false;
        }
        return true;
    }
    
    private int[] getCount(String word) {
        int[] inventory = new int[26];
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            inventory[c - 'a']++;
        }
        return inventory;
    }
}
