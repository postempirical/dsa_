class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int begin = 0, end = 0;
        int sum = 0, min = Integer.MAX_VALUE;
        
        while (end < nums.length) {
            sum += nums[end];
            
            if (sum >= target) {
                while (sum >= target) {
                    min = Math.min(min, end - begin + 1);
                    sum -= nums[begin];
                    begin++;
                }
            }
            
            end++;
        }
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}
