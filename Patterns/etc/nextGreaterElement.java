// NGE 1
// brute
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        // run j from end
        // if n[j] equals n[i], exit j loop and value will be 1
        // as we need to find next greater on the RIGHT side
        for (int i = 0; i < nums1.length; i++) {
            int value = -1;
            for (int j = nums2.length - 1; j >= 0 && nums2[j] != nums1[i]; j--) {
                if (nums2[j] > nums1[i]) {
                    value = nums2[j];
                }
            }
            ans[i] = value;
        }
        return ans;
    }
}

// optimised
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
	    Stack<Integer> st = new Stack<>();
	    HashMap<Integer, Integer> map = new HashMap<>();
        
        // if num > peek, map(peek, num) {peeks next greater is num}
        // else insert num into stack
        for (int num : nums2) {
            while (!st.isEmpty() && num > st.peek()) 
                map.put(st.pop(), num);
            st.add(num);
        }
        
        int i = 0;
        // if map value exists, return it, else return -1
        for(int num : nums1) 
            ans[i++] = map.getOrDefault(num, -1);
        
        return ans;
    }
}


// NGE 2
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int len = nums.length;
        int[] ans = new int[len];
        
        for (int i = 2 * len - 1; i >= 0; i--) {
            // pop all values smaller than current num
            while (!st.isEmpty() && st.peek() <= nums[i % len]) st.pop();
            // only first half is neede
            if (i < len) {
                if (!st.isEmpty()) ans[i] = st.peek();
                else ans[i] = -1;
            }
            st.add(nums[i % len]);
        }
        return ans;
    }
}

