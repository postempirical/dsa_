class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
    
    private boolean check(int i, int j, int index, char[][] board, String word) {
        // return true if we reach word end
        if (index == word.length()) return true;
        
        // check boundry cases and if character is unequal
        if (i > board.length - 1 || i < 0 || 
            j > board[0].length - 1 || j < 0 || 
            board[i][j] != word.charAt(index)) return false;
        
        // flood fill
        board[i][j] = '*';
        
        // traverse all 4 directions
        boolean res = check(i - 1, j, index + 1, board, word) ||
                      check(i, j - 1, index + 1, board, word) ||
                      check(i, j + 1, index + 1, board, word) ||
                      check(i + 1, j, index + 1, board, word);
        
        // after backtracking remove * and insert character again
        board[i][j] = word.charAt(index);
        return res;
    }
}
