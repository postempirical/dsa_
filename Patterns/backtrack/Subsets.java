// SUBSET 1
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, nums, res);
        return res;
    }
    
    public void backtrack(int index, List<Integer> list, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(index + 1, list, nums, res);
        list.remove(list.size() - 1);
        backtrack(index + 1, list, nums, res);
      
//       APPROACH 2
//       ans.add(new ArrayList<>(list));
//         for (int i = ind; i < nums.length; i++) {
//             list.add(nums[i]);
//             solve(i + 1, list, nums, ans);
//             list.remove(list.size() - 1);
//         }
    }
} 

// SUBSETS 2
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, list, nums, res);
        return res;
    }
    
    private void backtrack(int index, List<Integer> list, int[] nums, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        backtrack(index + 1, list, nums, res);
        list.remove(list.size() - 1);
        // skip duplicates
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) index += 1;
        backtrack(index + 1, list, nums, res);
      
//       APPROACH 2
//       ans.add(new ArrayList<>(list));
//         for (int i = ind; i < nums.length; i++) {
//             if(i > ind && nums[i] == nums[i - 1]) continue;
//             list.add(nums[i]);
//             solve(i + 1, list, nums, ans);
//             list.remove(list.size() - 1);
    }
}
