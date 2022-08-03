// NORMAL APPROACH USUALLY TLE
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length, currSum = 0;
        return solve(n - 1, target, currSum, nums);
    }
    
    private int solve(int ind, int target, int currSum, int[] nums) {
        if (ind < 0) {
            if (target == currSum) return 1;
            else return 0;
        }
        
        int pos = solve(ind - 1, target, currSum - nums[ind], nums);
        int neg = solve(ind - 1, target, currSum + nums[ind], nums);
        return pos + neg;
    }
}


// LIKE PARTITONS WITH GIVEN DIFFERENCE
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        // PARTITION WITH GIVEN DIFFERENCE APPROACH
        int total = 0;
        for (int num : nums) total += num;
        
        // edge cases
        if (total - target < 0 || (total - target) % 2 != 0) return 0;
        
        // s1 + s2 = total
        // s1 = total - s2
        // s1 - s2 = target
        // total - s2 - s2 = target
        // s2 = (total - target) / 2
        
        int s2 = (total - target) / 2;
        int n = nums.length;
        int dp[][] = new int[n][s2 + 1];
        
        return solve(n - 1, s2, nums, dp);
    }
    
    private int solve(int ind, int newTarget, int[] nums, int[][] dp) {
        if (ind == 0) {
            if(newTarget == 0 && nums[0] == 0) return 2; 
            if(newTarget == 0 || newTarget == nums[0]) return 1;
            return 0;
        }
        
        if (dp[ind][newTarget] != 0)
        return dp[ind][newTarget];
        
        int notpick = solve(ind - 1, newTarget, nums, dp);

        int pick = 0;
        if(nums[ind] <= newTarget)
            pick = solve(ind - 1, newTarget - nums[ind], nums, dp);

        return dp[ind][newTarget] = notpick + pick;
    }
}
