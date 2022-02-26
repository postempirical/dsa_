class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length < 4){  //corner case
            return res;
        }
        
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++){
            if(i > 0 && nums[i - 1] == nums[i]){   //avoid duplicated
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){   //avoid duplicated
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int curr = nums[i] + nums[j] + nums[left] + nums[right];
                    if(curr == target){
                        List<Integer> t = helper(nums, i, j, left, right);
                        res.add(new ArrayList<Integer>(t));
                        left++; right--;
                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                        while(left < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }
                    else if(curr > target) right--;
                    else left++;
                }
            }
        }
        return res;
    }
    
    private List<Integer> helper(int[] nums, int i, int j, int k, int l){
        List<Integer> t = new ArrayList<>();
        t.add(nums[i]); t.add(nums[j]); t.add(nums[k]); t.add(nums[l]);
        return t;
    }
}



//         Arrays.sort(nums);
//         List<List<Integer>> res = 
//             new ArrayList<>();
//         if (nums == null || nums.length == 0) return res;
    
//         for (int i = 0; i < nums.length - 3; i++) {
//             if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
//                 for (int j = i + 1; j < nums.length - 2; j++) {
//                     if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
//                         int lo = j + 1, hi = nums.length - 1;
//                         int sum = 0 - (nums[i] + nums[j]);
//                         while (lo < hi) {
//                             if (nums[lo] + nums[hi] == sum) {
//                                 res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
//                                 while ((lo < hi) && (nums[lo] == nums[lo + 1])) lo++;
//                                 while ((lo < hi) && (nums[hi] == nums[hi - 1])) hi--;
//                                 lo++; hi--;
//                             }
//                             else if (nums[lo] + nums[hi] < sum) lo++;
//                             else hi--;
//                         }
//                     }
//                     while ((j + 1 < nums.length) && (nums[j + 1] == nums[j])) j++;
//                 }
//             }
//             while ((i + 1 < nums.length) && (nums[i + 1] == nums[i])) i++;
//         }
//         return res;
