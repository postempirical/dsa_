class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
      
        // iterate slow fast till they meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow!=fast);
        
        // reset fast
        fast = nums[0];
        
        // again make them meet
        // make fast move 1 step now
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
