class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        
        Arrays.sort(arr); // 2 consecutive elements will give min diff
        
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear(); // clear previous values from res
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else if (diff == min) 
                res.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return res;
    }
}
