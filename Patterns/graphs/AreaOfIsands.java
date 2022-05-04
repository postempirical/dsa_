class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxarea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) 
                    maxarea = Math.max(maxarea, getArea(grid, i, j));
            }
        }
        return maxarea;
    }
    
    private int getArea(int[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length || 
                j < 0 || j >= grid[0].length || 
                grid[i][j] == 0) return 0;
            
            grid[i][j] = 0;
            return 1 + 
                getArea(grid, i + 1, j) +
                getArea(grid, i - 1, j) +
                getArea(grid, i, j + 1) +
                getArea(grid, i, j - 1);
        }
}
