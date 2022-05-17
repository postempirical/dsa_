class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        
        // if cell is 0, add to q
        // else mark it as unvisited
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { 
                if (mat[i][j] == 0) q.add(new int[]{i, j});
                else mat[i][j] = -1;
            }
        }
        
        // 4 directions
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] d : dir) {
                int x = cell[0] + d[0];
                int y = cell[1] + d[1];
                
                // if out of range or already visited, skip
                if (x < 0 || x >= m || y < 0 || y >= n || mat[x][y] != -1) continue;
                
                q.add(new int[] {x, y});
                mat[x][y] = mat[cell[0]][cell[1]] + 1;
            }
        }
        return mat;
    }
}
