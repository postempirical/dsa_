class Solution {
    public int longestPalindromeSubseq(String s) {
        // like lcs but here move both only when letters match
        // also ind1 will be at start and ind2 will be at end
        int n = s.length();
        Integer[][] dp = new Integer[n][n];
        return solve(s, 0, n - 1, dp);
    }
    
    private int solve(String s, int i, int j, Integer[][] dp) {
        // base
        if (i > j) return 0;
        if (i == j) return 1; // reached middle
        
        if (dp[i][j] != null) return dp[i][j]; 
        
        // if match add 2 because 2 letters will be move now
        if (s.charAt(i) == s.charAt(j))
            dp[i][j] = 2 + solve(s, i + 1, j - 1, dp);
        else dp[i][j] = Math.max(solve(s, i + 1, j, dp), solve(s, i, j - 1, dp));
        
        return dp[i][j];
    }
}
