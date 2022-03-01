// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // in the start we have a dummy val 0 with 1 freq
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            // add remaining sum freq to result
            // because if rem sum appeared x times
            // this means k was achieved x times too
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            if (map.containsKey(sum)) 
                map.put(sum, map.get(sum) + 1);
            else map.put(sum, 1);
        }
        return ans;
    }
}


// longest subarr of sum k
// here instead of count we need max length of subarr


static int lenOfLongSubarr(int[] arr, int n, int k)
{
			 // HashMap to store (sum, index) tuples
			 HashMap<Integer, Integer> map = new HashMap<>();
			 int sum = 0, maxLen = 0;

			 // traverse the given array
			 for (int i = 0; i < n; i++) {
						// accumulate sum
						sum += arr[i];

						// when subarray starts from index '0'
						if (sum == k)
								maxLen = i + 1;

						// make an entry for 'sum' if it is
						// not present in 'map'
						if (!map.containsKey(sum)) {
								map.put(sum, i);
						}

						// check if 'sum-k' is present in 'map'
						// or not
						if (map.containsKey(sum - k)) {
								// update maxLength
								if (maxLen < (i - map.get(sum - k)))
										maxLen = i - map.get(sum - k);
						}
			 }
			 return maxLen;            
}
