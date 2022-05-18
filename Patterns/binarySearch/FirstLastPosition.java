class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchFirst(nums, target);
        res[1] = searchLast(nums, target);
        return res;
    }
    
    // search first occurrence
    private int searchFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    // search last occurrence
    private int searchLast(int[] nums, int target){
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] <= target) start = mid + 1;
            else end = mid - 1;
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }
}
