class Solution {
    public int firstMissingPositive(int[] nums) {
        // set useless neg vals to zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) nums[i] = 0;
        }
        
        // map indices and range 
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int index = val - 1;
            
            // value must be in range
            if (val >= 1 && val <= nums.length) {
                if (nums[index] > 0) nums[index] *= -1;
                if (nums[index] == 0) nums[index] = -1 * (nums.length + 1);
            }
        }
            
        // if pos val exists means it isnt in the input
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] >= 0) return i;
        }
        return nums.length + 1;
    }
}


// other less optimisedd soln
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int first = 1;
        while(set.contains(first)){
            first++;
        }
        return first;
    }
}

