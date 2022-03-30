class Solution {
    public int[] sortedSquares(int[] nums) {
        // insert in res from end
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        
        int left = 0;
        int right = nums.length - 1;
      
        // insert larger absolute value's square in the end
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                res[index] = nums[right] * nums[right];
                right--;
            } else {
                res[index] = nums[left] * nums[left];
                left++;
            }
            index--;
        }
        return res;
    }
}
