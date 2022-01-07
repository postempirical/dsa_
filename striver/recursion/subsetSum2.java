// tc = 2^n * n
class Solution {
    public void findSubsets(int ind, int[] nums, 
                            List<List<Integer>> ans, ArrayList<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findSubsets(i + 1, nums, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        findSubsets(0, nums, ans, ds);
        return ans;
    }
}
