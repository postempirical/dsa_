class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1][n2];
        
        int lcs = solve(n1 - 1, n2 - 1, word1, word2,dp);
        
        // d1 + d2 = (n1 - lcs) + (n2 - lcs)
        int res = (n1 - lcs) + (n2 - lcs);
        return res;
    }
    
    private int solve(int i, int j, String word1, String word2, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        
        if (dp[i][j] != 0) return dp[i][j];
        
        if (word1.charAt(i) == word2.charAt(j)) 
            dp[i][j] = 1 + solve(i - 1, j - 1, word1, word2, dp);
        
        else dp[i][j]  = Math.max(solve(i - 1, j, word1, word2, dp), 
                                  solve(i, j - 1, word1, word2, dp));
        
        return dp[i][j];
    }
}
