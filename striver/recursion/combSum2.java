// tc = 2^n * k
class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int ind = 0;
        solve(ind, target, list, arr, ans);
        return ans;
    }
    
    public void solve(int ind, int target, List<Integer> list, int[] arr, List<List<Integer>> ans) {
        // base cond
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        // looping for each ind
        for (int i = ind; i < arr.length; i++) {
            // if its same as prev val, skip
            // if i is first val then dont skip
            // [1,1,2,4,5] we will miss 114 for t=6
            // so amke sure i is more than index
            if (i > ind && arr[i] == arr[i - 1]) continue;
            
            // sorted array so break asap
            if (arr[i] > target) break;
            
            list.add(arr[i]);
            solve(i + 1, target - arr[i], list, arr, ans);
            list.remove(list.size() - 1);
        }
    }
}
