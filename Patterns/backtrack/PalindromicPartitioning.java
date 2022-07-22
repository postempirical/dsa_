class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backtrack(0, s, list, res);
        return res;
    }
    
    private void backtrack(int index, String str, List<String> list, List<List<String>> res) {
        // add to res if reached the end of string
        if (index == str.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        // check each substring (index - i) for palindrome
        // add if yes, move ahead
        // remove on backtracking
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                list.add(str.substring(index, i + 1));
                backtrack(i + 1, str, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) 
            if (str.charAt(start++) != str.charAt(end--)) return false;
        return true;
    }
}
