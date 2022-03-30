// brute
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[] = new int [2];        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (x + nums[j] == target) {
                    res[0] = i; res[1] = j;   
                }
            }
        }
        return res;
    }
}

// map
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res  = new int[2];
        
        // create map of value, index
        Map<Integer, Integer> map = new HashMap<>();
        
        // loop and check if key - val is already in map
        // val + (key - val) = key
        // since index is asked in ques we check for mapkey
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            else map.put(nums[i], i);
        }
        return res;
    }
}
