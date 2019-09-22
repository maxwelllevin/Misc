class Solution {
    
    private int calculateArea(int i, int j, int[] height) {
        return (j - i) * Math.min(height[i], height[j]);
    }
    
    public int maxArea(int[] height) {
        int largestArea = -1;
        int i = 0, j = height.length - 1;
        while (i < j) {
            largestArea = Math.max(largestArea, calculateArea(i, j, height));
            if (height[i] <= height[j]) i++;
            else j--;
        }
        return largestArea;
    }
}
