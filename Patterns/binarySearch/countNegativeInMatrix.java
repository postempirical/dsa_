class Solution {
    public int countNegatives(int[][] grid) {
        // + + + + + +
        // + + + + - -
        // + + + + - -
        // + + + - - -
        // + - - - - -
        // + - - - - -
        // non increasing so as soon as we see a neg value
        // we know all value below that in the col will also be negative
        int i = 0, j = grid[0].length - 1;
        int count = 0;
        while (i < grid.length && j >= 0) {
            if (grid[i][j] < 0) {
                count += grid.length - i;
                j--;
            }
            else i++;
        }
        return count;
    }
}
