class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // insert any value in nearest
        // it will get corrected in the end
        int nearest = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
                
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == target) return target;

                // need to inc val as on lo-- it will keep going farther
                if (sum < target) lo++;
                // similar for hi
                else hi--;

                // compare abs diff and update result
                if (Math.abs(sum - target) < Math.abs(nearest - target))
                    nearest = sum;
            }
        }
        return nearest;
    }
}
