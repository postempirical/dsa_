class Solution {
    public int maxArea(int[] height) {
        int res = 0, area = 0;
        int left = 0, right = height.length - 1;
        
        // area will be LENGTH(right - left) - MINIMUM HEIGHT
        while (left < right) {
            area = (right - left) * Math.min(height[right], height[left]);
            res = Math.max(res, area);
            
            // update depending upon the lesser value
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }
}
