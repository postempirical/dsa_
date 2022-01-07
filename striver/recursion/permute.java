// https://leetcode.com/problems/permutations
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
