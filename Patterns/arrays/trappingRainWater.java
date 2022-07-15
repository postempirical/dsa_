class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++)
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) 
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        
        int[] water = new int[len];
        int totalWater = 0;
        for (int i = 0; i < len; i++) {
            water[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
            totalWater += water[i];
        }
        return totalWater;
    }
}
