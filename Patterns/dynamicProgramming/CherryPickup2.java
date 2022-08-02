// MEMOIZE (TLE)
class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        
        return solve(0, 0, c - 1, r, c, dp, grid);
    }
    
    private int solve(int i, int j1, int j2, int r, int c, int[][][] dp, int[][] grid) {
        // base case
        if (j1 < 0 || j2 < 0 || j1 >= c || j2 >= c) return (int)Math.pow(-10, 9);
        // base when reached last row
        if (i == r - 1) {
            // if both robots on same cell, return any one 
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        if (dp[i][j1][j2] != 0) return dp[i][j1][j2];
        
        // for every value of A there will be three choices from B
        // so total 9 choices
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                if (j1 == j2) 
                    max = Math.max(max, grid[i][j1] + 
                                   solve(i + 1, j1 + dj1, j2 + dj2,  r, c, dp, grid));
                else max = Math.max(max, grid[i][j1] + grid[i][j2] +
                                   solve(i + 1, j1 + dj1, j2 + dj2, r, c, dp, grid));
                dp[i][j1][j2] = max;
            }
        }
        return max;
    }
}


// TABULAR
