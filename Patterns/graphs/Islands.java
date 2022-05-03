// DFS
class Solution {
    public int numIslands(char[][] grid) {
        // using flood fill approach
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    fill(grid, i, j);
                    count++; // every fill call end means an island has been drowned
                }
            }
        }
        return count;
    }
    
    private void fill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || 
            j < 0 || j >= grid[0].length || 
            grid[i][j] != '1')
            return;
        
        // drown the current cell
        grid[i][j] = '0';
        fill(grid, i + 1, j);
        fill(grid, i - 1, j);
        fill(grid, i, j + 1);
        fill(grid, i, j - 1);
    }
}

// BFS

// UNION FIND
