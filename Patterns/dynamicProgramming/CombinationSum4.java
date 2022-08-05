class Solution {
    public int combinationSum4(int[] nums, int target) {
        // like coin change 2
        // only difference is that permutations have to start from 0
        // to take other rearrangements
        Integer[][] dp = new Integer[nums.length][target + 1];
        return solve(0, target, nums, dp);
    }
    
    private int solve(int ind, int target, int[] nums, Integer[][] dp) {
        if (ind == nums.length || target <= 0) {
            if (target == 0) return 1;
            else return 0;
        }
        
        if (dp[ind][target] != null) return dp[ind][target];
        
        int pick = solve(0, target - nums[ind], nums, dp);
        int notpick = solve(ind + 1, target, nums, dp);
        
        return dp[ind][target] = pick + notpick;
    }
}
