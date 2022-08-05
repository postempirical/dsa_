// MEMOIZE (TLE)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n][amount + 1];
        int res = solve(n - 1, amount, dp, coins);
        
        return res;
    }
    
    private int solve(int ind, int amount, int[][] dp, int[] coins) {
        if (ind == 0) {
            if (amount % coins[ind] == 0) return 1;
            else return 0;
        }
        
        if (dp[ind][amount] != 0) return dp[ind][amount];
        
        int notpick = solve(ind - 1, amount, dp, coins);
        
        int pick = 0;
        if (coins[ind] <= amount) 
            pick = solve(ind, amount - coins[ind], dp, coins);
        
        return dp[ind][amount] = pick + notpick;
    }
}


// MEMOIZE NON TLE
class Solution {
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return solve(coins, amount, 0, dp);
    }
    
    private int solve(int[] nums, int target, int ind, Integer[][] dp) {
        if (ind == nums.length || target <= 0) {
            if (target == 0) return 1;
            else return 0;
        }
        
        if (dp[ind][target] != null) return dp[ind][target];
        
        int pick = solve(nums, target - nums[ind], ind, dp);
        int notpick = solve(nums, target, ind + 1, dp);
        
        return dp[ind][target] = pick + notpick;
    }
}


// TABULAR
class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount + 1];
    
    
        //Initializing base condition
        for(int i = 0;i <= amount; i++){
            if(i % coins[0]==0)
                dp[0][i] = 1;
            // Else condition is automatically fulfilled,
            // as dp array is initialized to zero
        }

        for(int ind = 1; ind < coins.length; ind++){
            for(int target = 0; target <= amount; target++){
                int notpick = dp[ind - 1][target];

                int pick = 0;
                if(coins[ind] <= target)
                    pick = dp[ind][target - coins[ind]];

                dp[ind][target] = notpick + pick;
            }
        }

        return dp[coins.length - 1][amount];
    }
}
