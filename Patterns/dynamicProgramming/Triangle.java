// MEMOIZE (TLE)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        return solve(0, 0, dp, triangle, n);
    }
    
    private int solve(int i, int j, int[][] dp, List<List<Integer>> triangle, int n) {
        // base case
        if (i == n - 1) return triangle.get(n - 1).get(j);
        
        if (dp[i][j] != 0) return dp[i][j];
        
        int down = triangle.get(i).get(j) + solve(i + 1, j, dp, triangle, n);
        int dig = triangle.get(i).get(j) + solve(i + 1, j + 1, dp, triangle, n);
        
        return dp[i][j] = Math.min(down, dig);
    }
}

// TABULAR
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // BASE -> fill up last row values 
        for (int j = 0; j < n; j++) dp[n - 1][j] = triangle.get(n - 1).get(j);
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // recurrence relation remains the same
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int dig = triangle.get(i).get(j) + dp[i + 1][j + 1];
                dp[i][j] = Math.min(down, dig);
            }
        }
        return dp[0][0];
    }
}
