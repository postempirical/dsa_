class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        // will store the second highest value 13[2]
        int second = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            // [1]32
            // stack will take care of 32 pattern
            // so if we get a value < second, whole 132 pattern is satisfied
            if (nums[i] < second) return true;
            // like next smaller element
            // stack top will have the max element
            // popped values will update second for every number greater than max
            while (!st.isEmpty() && nums[i] > st.peek())
                second = st.pop();
            st.push(nums[i]);
        }
        return false;
    }
}
