class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1; // value in the first half
            else start = mid + 1; // value in the second half
        }
        return start; // 
    }
}

// like ceil of element in array
