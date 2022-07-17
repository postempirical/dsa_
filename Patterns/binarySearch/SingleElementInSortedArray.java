class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        // start + 1 for edge case if index 0 is result
        while (start + 1 < end) { 
            int mid = start + (end - start) / 2;
            // if no pair on left or right, return result
            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1])
                return nums[mid];
            
            // if mid is in in index
            // and its the second pair
            // the answer is on the left half
            // else go to the right half
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid - 1])
                    end = mid;
                else start = mid;
            }
            
            // similarly if mid is in odd index
            // and its the second pair
            // answer is in the right half
            // else go to the left half
            else {
                if (nums[mid] == nums[mid - 1])
                    start = mid + 1;
                else end = mid - 1;
            }
        }
        return nums[start]; // or end
    }
}
