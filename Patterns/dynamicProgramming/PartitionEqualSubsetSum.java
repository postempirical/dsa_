// MEMOIZE (TLE)
class Solution {
    public boolean canPartition(int[] nums) {
        // find total sum
        int sum = 0;
        for (int num : nums) sum += num;
        
        // if target is odd, subsets cannot be made
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];
        return solve(nums.length - 1, target, dp, nums);
    }
    
    private boolean solve(int ind, int target,int[][] dp, int[] nums) {
        if (target == 0) return true; // target achieved
        if (ind == 0) return nums[0] == target; // true only if that index contains target
        
        if (dp[ind][target] != 0) return dp[ind][target] == 0 ? false : true;
        
        boolean notpick = solve(ind - 1, target, dp, nums);
        boolean pick = false;
        if (target >= nums[ind]) 
            pick = solve(ind - 1, target - nums[ind], dp, nums);
        
        dp[ind][target] = notpick || pick ? 1 : 0;
        return pick || notpick;
    }
}


// TABULAR
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) sum += nums[i];

        if (sum % 2 == 1) return false;

        int k = sum / 2; // target to hit
        boolean dp[][] = new boolean[nums.length][k + 1];

        for(int i = 0; i < nums.length; i++)
            dp[i][0] = true;

        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int ind = 1; ind < nums.length; ind++) {
            for(int target = 1; target <= k; target++) {

                boolean notpick = dp[ind - 1][target];

                boolean pick = false;
                if(nums[ind] <= target)
                    pick = dp[ind - 1][target - nums[ind]];

                dp[ind][target] = notpick||pick;
            }
        }
        return dp[nums.length - 1][k];
    }
}
