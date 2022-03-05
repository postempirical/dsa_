// https://leetcode.com/problems/letter-case-permutation/
class Solution {
    public List<String> letterCasePermutation(String s) {
        String output = "";
        String input = s;
        List<String> res = new ArrayList<>();
        solve(input, output, res);
        return res;
    }
    
    private void solve (String input, String output, List<String> res) {
        if (input.length() == 0) {
            res.add(output);
            return;
        }
        
        if (Character.isAlphabetic(input.charAt(0))) {
            String output1 = output;
            String output2 = output;
            output1 += Character.toLowerCase(input.charAt(0));
            output2 += Character.toUpperCase(input.charAt(0));
            input = input.substring(1);
            solve(input, output1, res);
            solve(input, output2, res);
        }
        
        else {
            String output1 = output;
            output1 += input.charAt(0);
            input = input.substring(1);
            solve(input, output1, res);
        }
    }
}
