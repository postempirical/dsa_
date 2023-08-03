class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        
        // (1 2 3) (4 5 6 7) (k = 3)
        // (3 2 1) (7 6 5 4)
        // (4 5 6 7 1 2 3)
        
        reverse(0, len - k - 1, nums); // start to length - k th
        reverse(len - k, len - 1, nums); // length - kth to end
        reverse(0, len - 1, nums); // start to end
    }
    
    private void reverse(int i, int j, int[] nums) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
