class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        // add to set and also get max 
        // need max for loop range 1 to max
        int max = nums[0];
        for(int num : nums) {
            distinct.add(num);
            if (num > max) max = num;
        }
        max = nums.length > max ? nums.length :  max;
        for (int i = 1; i <= max; i++) {
            if (!distinct.contains(i)) ans.add(i);
        }
        return ans;
    }
}

// get o(1) space solution
