class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(ans, new ArrayList<>(), k, n, 1);
        return ans;
    }
    
    private void solve(List<List<Integer>> ans,List<Integer> tmp, int k, int n, int start){
        if(tmp.size() == k && n == 0) {
            ans.add(new ArrayList<>(tmp));
            return; 
        }
        
        for(int i = start; i <= 9 && i <= n; i++){
            tmp.add(i);
            solve(ans, tmp, k, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
