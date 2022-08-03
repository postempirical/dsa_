// MEMOIZE
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        int res = solve(n - 1, amount, dp, coins);
        
        return (res >= (int)Math.pow(10,9)) ? -1 : res;
    }
    
    private int solve(int ind, int amount, int[][] dp, int[] coins) {
        if (ind == 0) {
            if (amount % coins[ind] == 0)
                return amount / coins[ind];
            else return (int)Math.pow(10, 9);
        }
        
        if (dp[ind][amount] != 0) return dp[ind][amount];
        
        int notpick = solve(ind - 1, amount, dp, coins);
        int pick = Integer. MAX_VALUE;
        if (coins[ind] <= amount) 
            pick = 1 + solve(ind, amount - coins[ind], dp, coins);
        return dp[ind][amount] = Math.min(pick, notpick);
    }
}

// TABULAR
