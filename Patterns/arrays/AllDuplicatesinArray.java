class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // when find a number i, flip number at pos i-1 to neg 
        // if the number at position i-1 is already neg
        // then i is the number that occurs twice.
        List<Integer> res = new ArrayList();
        for(int num : nums) {
            int index = Math.abs(num) - 1;
            if(nums[index] < 0) res.add(Math.abs(num));
            nums[index] = -nums[index];
        }
         return res;
    }
}
