class Solution {
    public boolean check(int[] nums) {
        int flag = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            // this anomaly can appear only once
            if (nums[i] > nums[(i + 1) % len]) 
                flag++;
            if (flag > 1) return false;
        }
        return true;
    }
}
