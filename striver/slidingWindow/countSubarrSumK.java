// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // in the start we have a dummy val 0 with 1 freq
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // add remaining sum freq to result
            // because if rem sum appeared x times
            // this means k was achieved x times too
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            if (map.containsKey(sum)) 
                map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return ans;
    }
}
