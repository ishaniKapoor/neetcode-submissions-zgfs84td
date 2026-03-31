class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int maxArea = 0;
        while (l < r){
            int curr = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, curr);
            if (heights[r] < heights[l]) r--;
            else l++;
        }
        return maxArea;
    }
}
