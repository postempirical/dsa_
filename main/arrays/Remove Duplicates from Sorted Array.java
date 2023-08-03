class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        // as soon as start and end have different values, make next of start the current end value
        // keep pushing end forward till differnt values are found 
        for (int end = 1; end < nums.length; end++) {
            if (nums[start] != nums[end]) {
                nums[start + 1] = nums[end];
                start++;
            }
        }
        return start + 1;
    }
}

// 1 1 2 2 2 3 3
// s e e
// 1 2 2 2 3 3
//   s e e e
// 1 2 3 3
//     s e x
