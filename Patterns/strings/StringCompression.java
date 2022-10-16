class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int idx = 0, n = chars.length;
        int start = 0, end = 0; // initiate together
        
        while (start < n) {
            // bring end to next new letter
            while (end < n && chars[end] == chars[start])
                end++;
            
            int freq = end - start; // end is already on next char so end - start
            chars[idx++] = chars[start]; // insert prev letter to array
            
            // do nothing if freq is 1
            // if > 1, insert freq
            // if f is 12 then we need to insert it as [a, 1 ,2]
            if (freq > 1) {
                // convert freq to char array and keep inserting it into char array
                for (char c : String.valueOf(freq).toCharArray())
                    chars[idx++] = c;
            }
            // now bring start to new letter
            start = end;
        }
        
        return idx;
    }
}
