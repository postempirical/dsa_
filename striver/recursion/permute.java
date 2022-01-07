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
