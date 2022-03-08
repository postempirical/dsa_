// tc = 2^t * k
class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int ind = 0;
        solve(ind, target, list, arr, ans);
        return ans;
    }
    
    public void solve(int ind, int target, List<Integer> list, int[] arr, List<List<Integer>> ans) {
        // if viewed all indices and targets gets 0
        if (ind == arr.length) {
            if (target == 0) ans.add(new ArrayList<>(list));
        return;
        }
        
        // keep dec target til val is smaller
        // call on same ind with decreased target
        // else momve to next ind after backtracking 
        if (arr[ind] <= target) {
            list.add(arr[ind]);
            solve(ind, target - arr[ind], list, arr, ans);
            list.remove(list.size() - 1);
        }
        solve(ind + 1, target, list, arr, ans);    
    }
}
