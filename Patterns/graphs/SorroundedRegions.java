class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        if (board.length < 3 || board[0].length < 3) return;
        int row = board.length;
        int col = board[0].length;
        
        // replace left, right column's O with *
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') fill(board, i, 0);
            if (board[i][col - 1] == 'O') fill(board, i, col - 1);
        }
        // replace top, botton row's O with * (excluding first, last value)
        for (int j = 1; j < col - 1; j++) {
            if (board[0][j] == 'O') fill(board, 0, j);
            if (board[row - 1][j] == 'O') fill(board, row - 1, j);
        }
        
        // now replace all remainig O's with X and all *'s with O
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    private void fill(char[][] board, int r, int c) {
        if (r < 0 || r > board.length - 1 || 
            c < 0 || c > board[0].length - 1 || 
            board[r][c] != 'O') return;
        
        board[r][c] = '*';
        fill(board, r + 1, c);
        fill(board, r - 1, c);
        fill(board, r, c + 1);
        fill(board, r, c - 1);
    }
}
