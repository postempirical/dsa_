class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int ind = 0;
        solve(ind, list, nums, ans);
        return ans;
    }
    
    public void solve(int ind, List<Integer> list, int[] nums, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = ind; i < nums.length; i++) {
            list.add(nums[i]);
            solve(i + 1, list, nums, ans);
            list.remove(list.size() - 1);
        }
    }
}
