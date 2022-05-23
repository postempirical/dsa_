class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            
            // if left half is sorted
            if (nums[left] <= nums[mid]) {
                // if value lies in the left left half, 
                // discard right half, else vice versa
                if (target >= nums[left] && target <= nums[mid])
                    right = mid - 1;
                else left = mid + 1;
            }
            
            // similarly if right half is sorted
            if (nums[mid] <= nums[right]) {
                if (target >= nums[mid] && target <= nums[right])
                    left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }
}
