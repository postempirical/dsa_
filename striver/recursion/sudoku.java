// https://leetcode.com/problems/sudoku-solver/ 
class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // if we find an empty cell
                if (board[i][j] == '.'){
                    // try from 1-9 on that cell
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            // fill that cell
                            board[i][j] = c;
                            // keep calling till one is solved
                            // dont bt if solved, just return
                            if (solve(board)) return true;
                            // if not solved backtrack 
                            else board[i][j] = '.';
                        }
                    }
                    // if unable to place anyone on empty cell
                    return false;
                }
            }
        }
        
        // if we never get into loop
        // it means there were no empty cells
        // so the board was already solved
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c) {
      // if the char c is already present in r,c,grid return false
        for (int i = 0; i < 9; i++) {
            // check rows
            if (board[i][col] != '.' && board[i][col] == c) return false;
            // check colms
            if (board[row][i] != '.' && board[row][i] == c) return false;
            // check 3x3 grid
            if (board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] != '.' && 
                board[3 * (row/3) + (i/3)][3 * (col/3) + (i%3)] == c) 
                return false;
        }
        return true;
    }
}
