// MEMOIZE
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // as max size of i,j will be m-1, n-1
        return solve(m - 1, n - 1, dp);
    }
    
    private int solve(int i, int j, int[][] dp) {
        // base case
        if (i == 0 && j == 0) return 1; // reached source => path found
        if (i < 0 || j < 0) return 0; // exceeded boundry => no path found
        
        if (dp[i][j] != 0) return dp[i][j];
        
        int up = solve(i - 1, j, dp);
        int left = solve(i, j - 1, dp);
        
        return dp[i][j] = up + left;
    }
}

// TABULAR
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                else {
                    int up = 0, left = 0;
                    if (i > 0) up = dp[i -1][j];
                    if (j > 0) left = dp[i][j - 1];
                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

// UNIQUE PATHS 2

// just add another base case at the start
if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) return 0;
