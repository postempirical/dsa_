class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // if cell already colored, simply return it
        // image[sr][sc] will be the source color
        if (image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void fill(int[][] image, int sr, int sc, int source, int newColor) {
        if (sr < 0 || sr >= image.length || 
            sc < 0 || sc >= image[0].length || 
            image[sr][sc] != source) 
            return;
        image[sr][sc] = newColor;
        fill(image, sr + 1, sc, source, newColor);
        fill(image, sr - 1, sc, source, newColor);
        fill(image, sr, sc + 1, source, newColor);
        fill(image, sr, sc - 1, source, newColor);
    }
}
