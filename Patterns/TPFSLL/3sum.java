// two pointer
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // if i is 0 enter loop
            // otherwise only enter loop if val != prev val
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                // declare lo, hi
                int lo = i + 1;
                int hi = nums.length - 1;
                
                // sum is target to hit
                // b + c = -a
                // need lo+hi pair equalling -nums[i]
                int sum = 0 - nums[i];
                
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        // add to list and skip duplicate lo,hi vals
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while ((lo < hi) && (nums[lo] == nums[lo + 1])) lo++;
                        while ((lo < hi) && (nums[hi] == nums[hi - 1])) hi--;
                        lo++; hi--;
                    }
                    else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }
}

// using sets
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length == 0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for (int i = 0; i<nums.length - 2; i++) {
            int j = i + 1;
            int  k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum > 0) k--;
                else if (sum < 0) j++;
            }
        }
        return res;
    }
}
