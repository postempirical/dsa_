class Solution {
    // create keys map
    String[] mapping = new String[] {"0", "1", "abc", "def", 
                                          "ghi", "jkl", "mno", 
                                          "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        
        if(digits == null || digits.length() == 0) return res;
        backtrack(sb, 0, digits, mapping, res);
        return res;
    }
    
    private void backtrack(StringBuilder sb, int index, 
                            String digits, String[] mapping, 
                            List<String> res) {
        
        // base condition
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        // get the numpad keys
        String options = mapping[digits.charAt(index) - '0'];
        
        // iterate over each character
        // add it to sb
        // now move on to next mapping index
        // on returning remove values
        for (char ch : options.toCharArray()) {
            sb.append(ch);
            backtrack(sb, index + 1, digits, mapping, res);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
