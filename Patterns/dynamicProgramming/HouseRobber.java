// MEMOIZED
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int index = nums.length - 1;
        return solve(index, nums, dp);
    }
    
    private int solve (int index, int[] nums, int[] dp) {
        // base case
        if (index == 0) return nums[index]; // ind-1 not picked so pick this
        if (index < 0) return 0; // 1 - 2 will become -1 so return 0
        if (dp[index] != -1) return dp[index];
        
        // if picking, select it and go to index - 2
        // else just go to index - 1
        int pick = nums[index] + solve(index - 2, nums, dp);
        int notpick = solve(index - 1, nums, dp);
        
        return dp[index] = Math.max(pick, notpick);
    }
}

// TABULAR
class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        for (int i = 1; i < nums.length; i++) {
            int pick = nums[i];
            if (i > 1) pick += dp[i - 2];
            int notpick = dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[nums.length - 1];
    }
}
