class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        backtrack(0, res, s.toCharArray());
        return res;
    }
    
    private void backtrack(int index, List<String> res, char[] str) {
        // if we reach string end, add permutation to result list
        if (index == str.length) res.add(new String(str));

        else {
            // if current index is a letter
            // make a branch for upper and another for lower
            if (Character.isLetter(str[index])) {
                str[index] = Character.toUpperCase(str[index]);
                backtrack(index + 1, res, str);
                
                str[index] = Character.toLowerCase(str[index]);
                backtrack(index + 1, res, str);
            }
            // else if it not a letter, simply move to next index
            else backtrack(index + 1, res, str);
        }
    }
}
