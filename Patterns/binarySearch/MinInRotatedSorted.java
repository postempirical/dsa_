class Solution {
    public int findMin(int[] nums) {
        int start = 0, len = nums.length, end = len - 1;
        int res = nums[start];
        int prev, next;
        
        while(start <= end) {
            // if already sorted, return start
            if(nums[start] <= nums[end]) return nums[start];
            
            int mid = start + (end - start) / 2;
            prev = (mid + len - 1) % len;
            next = (mid + 1) % len;
            
            // min element will be less than both its neighbours
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) return nums[mid];
            else if(nums[mid] >= nums[start]) start = mid + 1;
            else end = mid - 1;
        }
        return res;
    }
}
