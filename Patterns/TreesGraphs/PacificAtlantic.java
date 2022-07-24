class Solution {
    // directions
    int[][] dir = new int[][]{{1, 0},{-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // create a result array
        List<List<Integer>> res = new ArrayList<>();
        
        int rows = heights.length, cols = heights[0].length;
        
        // edge cases
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return res;
        
        // create 2 queues to store successfull cells for each
        Queue<int[]> pacific = new LinkedList<>();
        Queue<int[]> atlantic = new LinkedList<>();
        
        // created visited array for both queues
        boolean[][] visited_P = new boolean[rows][cols];
        boolean[][] visited_A = new boolean[rows][cols];
        
        // add border values to the queues
        
        // vertical (left, right borders)
        for (int i = 0; i < rows; i++) {
            pacific.add(new int[]{i, 0});
            visited_P[i][0] = true;
            
            atlantic.add(new int[]{i, cols - 1});
            visited_A[i][cols - 1] = true;
        }
        
        // horizontal (top, down borders)
        for (int i = 0; i < cols; i++) {
            pacific.add(new int[]{0, i});
            visited_P[0][i] = true;
            
            atlantic.add(new int[]{rows - 1, i});
            visited_A[rows - 1][i] = true;
        }
        
        // apply bfs on both queues
        bfs(heights, pacific, visited_P);
        bfs(heights, atlantic, visited_A);
        
        // traverse the matrix
        // add all cells that are visited for both pacific and atlantic
        for (int i = 0; i < rows; i++) 
            for (int j = 0; j < cols; j++) 
                if (visited_P[i][j] && visited_A[i][j])
                    res.add(Arrays.asList(i,j));
        
        return res;
    }
    
    private void bfs(int[][]heights, Queue<int[]> queue, boolean[][]visited) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dir) {
                int x = curr[0] + d[0];
                int y = curr[1] + d[1];
                
                // edge cases 
                // also if neightbour cell is less height than current
                if (x < 0 || x >= heights.length || 
                    y < 0 || y >= heights[0].length || 
                    visited[x][y] || heights[x][y] < heights[curr[0]][curr[1]])
                    continue;
                    
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
    }
}
