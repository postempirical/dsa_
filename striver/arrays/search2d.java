// rows soeted and row start > prev row end
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0, end = rows * cols - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (matrix[mid / cols][mid % cols] == target) 
                return true;
            if (matrix[mid / cols][mid % cols] < target) 
                start = mid + 1;
            else end = mid - 1;
        }
        return false;
    }
}


// row and col sorted
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) return true;
            if (matrix[i][j] > target) j--;
            else i++;
        }
        return false;
    }
}
