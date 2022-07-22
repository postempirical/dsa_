// COMBINATIONS
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // start from 1 (given in question)
        backtrack(1, list, res, n, k);
        return res;
    }
    
    private void backtrack(int start, List<Integer> list, List<List<Integer>> res, int n, int k) {
        if (list.size() == k) res.add(new ArrayList<>(list));
        else if (list.size() > k) return;
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(i + 1, list, res, n, k);
            list.remove(list.size() - 1);
        }
    }
}


// COMBINATION SUM 1
class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0, target, list, arr, res);
        return res;
    }
    
    public void solve(int index, int target, List<Integer> list, int[] arr, List<List<Integer>> res) {
        // if viewed all indices and target gets 0
        if (index == arr.length) {
            if (target == 0) res.add(new ArrayList<>(list));
            return;
        }
        
        // keep decreasing target till value is smaller
        // call on same index with decreased target
        // else momve to next ind after backtracking 
        if (arr[index] <= target) {
            list.add(arr[index]);
            solve(index, target - arr[index], list, arr, res);
            list.remove(list.size() - 1);
        }
        solve(index + 1, target, list, arr, res);    
    }
}


// COMBINATION SUM 2
class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        solve(0, target, list, arr, res);
        return res;
    }
    
    public void solve(int ind, int target, List<Integer> list, int[] arr, List<List<Integer>> res) {
        // base condition
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        // looping for each index
        for (int i = ind; i < arr.length; i++) {
            // if its same as prev val, skip
            // if i is first val then dont skip
            // [1,1,2,4,5] we will miss 114 for t=6
            // so amke sure i is more than index
            if (i > ind && arr[i] == arr[i - 1]) continue;
            
            // sorted array so break asap
            if (arr[i] > target) break;
            
            list.add(arr[i]);
            solve(i + 1, target - arr[i], list, arr, res);
            list.remove(list.size() - 1);
        }
    }
}


// COMBINATION SUM 3
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(res, new ArrayList<>(), k, n, 1);
        return res;
    }
    
    private void solve(List<List<Integer>> res, List<Integer> list, int k, int n, int start){
        if(list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return; 
        }
        
        for(int i = start; i <= 9 && i <= n; i++){
            list.add(i);
            solve(res, list, k, n - i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
