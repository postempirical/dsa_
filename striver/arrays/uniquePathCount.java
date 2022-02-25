// Recursive
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1);
    }
    
    public int helper(int row, int col) {
        if (row < 0 || col < 0) return 0;
        if (row == 0 || col == 0) return 1;
        else return helper(row - 1, col) + helper(row, col - 1);
    }
}

// dp memoization
class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m - 1, n - 1, new int[m][n]);
    }
    
    public int helper(int row, int col, int[][] grid) {
        if (row < 0 || col < 0) return 0;
        if (row == 0 || col == 0) return 1;
        else if (grid[row][col] != 0) return grid[row][col];
        else {
            grid[row][col] = helper(row - 1, col, grid) 
                + helper(row, col - 1, grid);
            return grid[row][col];
        }
    }
}
