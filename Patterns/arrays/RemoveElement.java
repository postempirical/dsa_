// REMOVE ELEMENT (IN PLACE)
class Solution {
    public int removeElement(int[] nums, int val) {
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[begin] = nums[i];  
                begin++;
            }
        }
        return begin;
    }
}


// REMOVE DUPLICATES (IN PLACE)
class Solution {
    public int removeDuplicates(int[] nums) {
        int begin = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[begin++] = nums[i];
            }
        }
        return begin;
    }
}
