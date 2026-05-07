class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while (l < r){
            int currArea = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, currArea);
            if (heights[l] < heights[r]){
                int lastHeight = heights[l];
                while (l < r && heights[l] <= lastHeight) l++;
            }
            else {
                int lastHeight = heights[r];
                while (l < r && heights[r] <= lastHeight) r--;
            }
        }
        return maxArea;
    }
}
