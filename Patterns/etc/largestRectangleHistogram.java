class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        int[] area = new int[heights.length];
        int[] width = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        
        nextSmallerLeft(left, st, heights);
        st.clear();
        nextSmallerRight(right, st, heights);

        int max = 0;
        for(int i = 0; i < heights.length; i++){
            width[i] = right[i] - left[i] - 1;
            area[i] = width[i] * heights[i];
            if(area[i]>max) max=area[i];
        }
        return max;
    }
    
    private void nextSmallerLeft(int[] left, Stack<Integer> st, int[] heights) {
        for(int i = 0; i < heights.length; i++) {
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            if(st.size() == 0)
                left[i] = -1;
            else if(heights[st.peek()] < heights[i])
                left[i] = st.peek();
            st.push(i);
        }
    }
    
    private void nextSmallerRight(int[] right, Stack<Integer> st, int[] heights) {
        for(int i = heights.length - 1; i >= 0; i--) {
            while(st.size() != 0 && heights[st.peek()] >= heights[i])
                st.pop();
            if(st.size() == 0) 
                right[i] = heights.length;
            else if(heights[st.peek()] < heights[i]) 
                right[i] = st.peek();
            st.push(i);
        }
    }
}
