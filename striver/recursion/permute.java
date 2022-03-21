// https://leetcode.com/problems/permutations
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(ans, list, nums);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) 
            ans.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (list.contains(nums[i])) continue;
                list.add(nums[i]);
                solve(ans, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}


// https://leetcode.com/problems/permutations-ii/
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        solve(ans, list, nums, used);
        return ans;
    }
    public void solve(List<List<Integer>> ans, 
                      List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) 
            ans.add(new ArrayList<>(list));
        else {
            for (int i = 0; i < nums.length; i++) {
								// if already used skip this
                if (used[i]) continue; 
								// if equal to prev and prev is not used skip
								// as prev will be marked used later on
                if (i > 0 && nums[i] == nums[i - 1] && 
                    !used[i - 1]) continue;
                used[i] = true;
                list.add(nums[i]);
                solve(ans, list, nums, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
// tc = n! * n, sc = n + n
class Solution {
    public void recur(int[] nums, List<List<Integer>> ans, 
                      ArrayList<Integer> ds, 
                      boolean freq[]) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                ds.add(nums[i]);
                freq[i] = true;
                recur(nums, ans, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;         
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        recur(nums, ans, ds, freq);
        return ans;
    }
}


// tc = n! * n, sc = no extra space
class Solution {
    private void recurPermute(int index, int[] nums, List<List<Integer>> ans) {
        if(index == nums.length) {
            // copy the ds to ans
            List<Integer> ds = new ArrayList<>();
            for(int i = 0;i<nums.length;i++) {
                ds.add(nums[i]); 
            }
            ans.add(new ArrayList<>(ds)); 
            return; 
        }
        for(int i = index;i<nums.length;i++) {
            swap(i, index, nums); 
            recurPermute(index+1, nums, ans); 
            swap(i, index, nums); 
        }
    }
    private void swap(int i, int j, int[] nums) {
        int t = nums[i]; 
        nums[i] = nums[j]; 
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        recurPermute(0, nums, ans);
        return ans; 
    }
}
