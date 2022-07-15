class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea = -1;
        
        // for each cell with value=1, we look upward (north)
        // the number of continuous '1' is the height of cell
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') heights[j] = 0;
                else heights[j]++;
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    
    
    // largest rectangle area code from leetcode 84
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
