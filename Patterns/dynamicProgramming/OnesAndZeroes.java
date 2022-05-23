class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        dp = new int[m + 1][n + 1][strs.length];
        return helper(strs, m, n, 0);
    }
    
    private int helper(String[] strs, int zeros, int ones, int index) {
        // base condition (if we reach the end, or no 0,1 remaining)
        if (index == strs.length || zeros + ones == 0) return 0;
        
        // meomoization
        if (dp[zeros][ones][index] > 0) return dp[zeros][ones][index];
        
        // count 0,1 of curretn index string
        int count[] = count(strs[index]);
        
        // if we accept the current string
        // add 1 to output and recursively call on remaining 01
        int consider = 0;
        if (zeros >= count[0] && ones >= count[1])
            consider = 1 + helper(strs, zeros - count[0], ones - count[1], index + 1);
        
        // if we skip current string, 01 and output remains same
        int skip = helper(strs, zeros, ones, index + 1);
        
        // store max of consider, skip in dp
        dp[zeros][ones][index] = Math.max(consider, skip);
        
        // return the final stores output
        return dp[zeros][ones][index];
    }
    
    // function to count 0,1 of current index string
    private int[] count(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) count[c - '0']++;
        return count;
    }
}
