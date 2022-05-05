class Solution {
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        
        // set all boundry 1's t0 0
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) 
                    fill(grid, i, j);
            }
        }
        
        // now count all the other 1 cells
        // all these will be locked
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    
    private void fill(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || 
            j < 0 || j >= grid[0].length || 
            grid[i][j] == 0) return;
        
        grid[i][j] = 0;
        fill(grid, i + 1, j);
        fill(grid, i - 1, j);
        fill(grid, i, j + 1);
        fill(grid, i, j - 1);
    }
}
