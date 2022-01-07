// tc = 2^e * k
class Solution {
    public void findCombinations(int ind, int[] arr, int target, 
                                 List<List<Integer>> ans, 
                                 ArrayList<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
  
      public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        findCombinations(0, candidates, target, ans, ds); 
        return ans; 
    }
    
}
