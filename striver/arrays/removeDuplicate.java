
// [1] tc -> n, sc -> on
class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> duplicate = new HashSet<>();
        for (Integer i : nums) {
            if (duplicate.contains(i)) return i;
            duplicate.add(i);
        }
        return -1;
    }
}


// [2] tc -> n, sc -> o1
class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];
        
        do {
        slow = nums[slow];
        fast = nums[nums[fast]];
        } while (slow != fast);
    
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
        
