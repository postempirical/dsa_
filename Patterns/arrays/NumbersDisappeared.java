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
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer> res = new ArrayList();
      
      for(int num : nums){
        int index = Math.abs(num) - 1;
        if(nums[index] > 0) nums[index] = -nums[index];          
      }
      
      for(int i = 0; i < nums.length; i++){
        if(nums[i] > 0) res.add(i + 1);      
      }
      return res;
    }
}
