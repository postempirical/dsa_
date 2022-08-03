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
