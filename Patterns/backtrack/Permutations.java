// PERMUTATIONS 1
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(res, list, nums);
        return res;
    }
    
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
        // add to answer only when all values processed
        if (list.size() == nums.length) 
            res.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue; // IMPORTANT
                list.add(nums[i]);
                backtrack(res, list, nums); // NO i + 1
                list.remove(list.size() - 1);
            }
        }
    }
}


// PERMUTATIONS 2
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(res, list, nums, used);
        return res;
    }
    public void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) 
            res.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue; 
                if (i > 0 && nums[i] == nums[i - 1] && 
                    used[i - 1]) continue;
                used[i] = true;
                list.add(nums[i]);
                backtrack(res, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
