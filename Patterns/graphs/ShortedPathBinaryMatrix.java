class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // edge cases
        if (grid == null || grid.length == 0) return -1;
        if (grid[0][0] != 0) return -1;
        
        // 8 directions
        int[][] dir = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        
        // create q and add x = 0, y = 0, count = 0 initially
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0}); // {x, y, path count}
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            // if reached last cell, add final 1 to path count and return 
            if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) return curr[2] + 1;
            
            // check all sorrounding valid cells
            for (int[] d : dir) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                // if cell is in range and is valid
                // add to queue with updated path count
                // mark it visited
                if (x >= 0 && x < grid.length && 
                    y >= 0 && y < grid[0].length && 
                    grid[x][y] == 0) {
                    q.add(new int[]{x, y, curr[2] + 1});
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
}
