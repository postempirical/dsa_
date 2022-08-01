// MEMOIZE
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        return solve(m - 1, n - 1, dp, grid);
    }
    
    private int solve(int i, int j, int[][] dp, int[][] grid) {
        // base case
        if (i == 0 && j == 0) return grid[0][0];
        // if out of boundry return some very large value to discard the path
        if (i < 0 || j < 0) return (int)Math.pow(10,9); 
        
        if (dp[i][j] != 0) return dp[i][j];
        
        int up = grid[i][j] + solve(i - 1, j, dp, grid);
        int left = grid[i][j] + solve(i, j - 1, dp, grid);
        
        return dp[i][j] = Math.min(up, left);
    }
}


// TABULAR
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else {
                    int up = grid[i][j], left = grid[i][j];
                    
                    if (i > 0) up += dp[i - 1][j];
                    else up +=(int)Math.pow(10,9); // some very large value to discard this path
                    
                    if (j > 0) left += dp[i][j - 1];
                    else left += (int)Math.pow(10,9);
                    
                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
