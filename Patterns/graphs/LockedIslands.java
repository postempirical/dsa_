class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = 0; 
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (fill(grid, i, j, m, n)) total++;
                }
            }
        }
        return total;
    }
    
    private boolean fill(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        
        if(grid[i][j] == 1) return true;
        
        // drown cell
        grid[i][j] = 1;
        
        // call on all directions
        boolean top = fill(grid, i + 1,j, m, n);
        boolean bottom = fill(grid, i - 1, j, m, n);
        boolean right = fill(grid ,i, j + 1, m, n);
        boolean left = fill(grid ,i, j - 1, m, n);
        
        // if all directions return true we have a locked land
        return top && bottom && right && left;
    }
}
