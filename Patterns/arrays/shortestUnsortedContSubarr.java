class Solution {
    public int findUnsortedSubarray(int[] nums) {
        // go from left to right
        // if ith value is smaller than any value on left
        // mark end on it as that value is out of place
        
        // for already sorted array end - start + 1 will become -1+0+1 = 0
        int end = -1; 
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < max) end = i;
            else max = nums[i];
        }
        
        // go from right to left
        // if ith index is greater than any value on right
        // mark start on it as that value is out of place
        int start = 0;
        int min = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min) start = i;
            else min = nums[i];
        }
        return end - start + 1;
    }
}
