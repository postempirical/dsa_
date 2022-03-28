class Solution {
    public void setZeroes(int[][] matrix) {
        boolean colzero = false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            // flip colzero if 0th col has a 0
            if (matrix[i][0] == 0) colzero = true;
            for (int j = 1; j < col; j++) {
                // update starting row,col
                if (matrix[i][j] == 0) 
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }
        
        // traverse backwards to eliminate col0 issue
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                // if start r,c has 0, insert 0 in cell
                if (matrix[i][0] == 0 || matrix[0][j] == 0) 
                    matrix[i][j] = 0;
            }
            // insert 0 in col[0] if true
            if (colzero == true) matrix[i][0] = 0;
        }
    }
}
