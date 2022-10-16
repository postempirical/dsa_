class Solution {
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        
        while (i < nums.length) {
            int start = nums[i];
            // keep inc i as long an increasing sequence is there
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            
            // if start and nums[i] are same, range has only one value
            if (start != nums[i]) res.add(""+start+"->"+nums[i]);
            else res.add(""+start);
            
            i++;
        }
        return res;
    }
}
