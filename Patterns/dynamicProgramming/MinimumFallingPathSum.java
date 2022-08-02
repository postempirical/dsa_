// MEMOIZE
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        int min = Integer.MAX_VALUE;
        
        // call on all last rows
        // get min of all answers returned 
        for (int j = 0; j < n; j++) {
            int ans = solve(n - 1, j, dp, matrix);
            min = Math.min(min, ans);
        }
        return min;
    }
    
    private int solve(int i, int j, int[][] dp, int[][] matrix) {
        // base case
        if (j < 0 || j >= matrix.length) return (int)Math.pow(10, 9);
        if (i == 0) return matrix[0][j];
        
        if (dp[i][j] != 0) return dp[i][j];
        
        int up = matrix[i][j] + solve(i - 1, j, dp, matrix);
        int leftUp = matrix[i][j] + solve(i - 1, j - 1, dp, matrix);
        int rightUp = matrix[i][j] + solve(i - 1, j + 1, dp, matrix);
        
        return dp[i][j] = Math.min(up, Math.min(leftUp, rightUp));
        
    }
}


// TABULAR
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
                
        // initialize first row of dp
        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                
                int leftUp = 0, rightUp = 0;
                
                if (j > 0) leftUp = matrix[i][j] + dp[i - 1][j - 1];
                else leftUp = (int)Math.pow(10,9);
                
                if (j < n - 1) rightUp = matrix[i][j] + dp[i - 1][j + 1];
                else rightUp = (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(up, Math.min(leftUp, rightUp));
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) min = Math.min(min, dp[n - 1][j]);

        return min;
    }
}
