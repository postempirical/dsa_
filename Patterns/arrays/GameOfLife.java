class Solution {
    public void gameOfLife(int[][] board) {
        int[][] output = new int[board.length][board[0].length];
        // fill output matrix acc to the rules
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighbours = countNeighbours(i, j, board);
                // rule 1
                if (board[i][j] == 1 && neighbours < 2) 
                    output[i][j] = 0;
                // rule 2
                if (board[i][j] == 1 && ((neighbours == 2) || neighbours == 3))
                    output[i][j] = 1;
                // rule 3
                if (board[i][j] == 1 && neighbours > 3) 
                    output[i][j] = 0;
                // rule 4
                if (board[i][j] == 0 && neighbours == 3) 
                    output[i][j] = 1;
            }
        }
        // copy back into board matrix
        for(int i=0;i<board.length;i++)
        {
            for (int j=0;j<board[i].length;j++)
            {
                board[i][j]=output[i][j];
            }
        }
    }
    
    private int countNeighbours(int i, int j, int[][] board) {
        int count=0;
        // to find value in 8 directions on x-y axis
        // left | top | right | botRight | topRight | botLeft | topLeft | bottom
        int[][] direction = {{0,-1},{0,1},{1,0},{1,-1},{1,1},{-1,-1},{-1,1},{-1,0}};
        for(int[] dir:direction) {   
            // sorrounding [x][y]th cell
            int x=i+dir[0];
            int y=j+dir[1];
            // if x and y are in range ie > 0 and < len
            if(x >= 0 && y >= 0 && x < board.length && y < board[0].length)
                count+=board[x][y];
         }
         return count;
    }
}
