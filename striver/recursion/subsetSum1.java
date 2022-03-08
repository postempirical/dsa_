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
						// subset2 no duplicates
					  // if(i > ind && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            solve(i + 1, list, nums, ans);
            list.remove(list.size() - 1);
        }
    }
}


// pick not pick approach for ss1
public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
        if(nums.length == start){
            result.add(new ArrayList<>(tempList));    
            return;
        }
        tempList.add(nums[start]);
        backtrack(result, tempList, nums, start+1);
        tempList.remove(tempList.size()-1);
        backtrack(result, tempList, nums, start+1);
    }
