class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int top = 0,  bottom = n - 1;
        int left = 0, right = m - 1;
        int dir = 0;
        
        /*directions
        0 left to right
        1 top to bottom
        2 right to left
        3 bottom to top*/
      
        while (top <= bottom && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) res.add(matrix[top][i]);
                top++;
            }
            else if (dir == 1) {
                for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
                right--;
            }
            else if (dir == 2) {
                for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
                bottom--;
            }
            else {
                for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
                left++;
            }
            dir = (dir + 1) % 4;
        }
        return res;
    }
}
