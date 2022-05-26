class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack("", 0, 0, n, res);
        return res;
    }
    
    private void backtrack(String str, int open, int close, int n, List<String> res) {
        // base condition
        if (str.length() == n * 2) {
            res.add(str);
            return;
        }
        
        // if string still has space to add (, add it
        if (open < n) backtrack(str+"(", open + 1, close, n, res);
        
        // only add ) if it is less than ( count
        if (close < open) backtrack(str+")", open, close + 1, n, res);
    }
}
