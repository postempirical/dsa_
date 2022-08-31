// https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // add an empty prifix for value 0, making its count 1
        // [1 1 1 4 -2 1] k = 3
        // here at ind = 2 we get a subarr
        // so we need sum(3) - k = 0 in map already for our algo to work
        map.put(0, 1); 
        
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            // if prefix - k is present
            // increase count by how many times we found prefix - k ie its freq
            if (map.containsKey(prefix - k))
                count += map.get(prefix - k);
            
            // if prefix - k is not present
            // increase freq of prefixSum
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}


// LONGEST SUBARRAY OF SIZE K
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
