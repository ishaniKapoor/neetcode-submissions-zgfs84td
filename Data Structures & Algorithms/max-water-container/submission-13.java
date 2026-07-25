class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;
        while (l < r){
            int curr = (r - l) * Math.min(heights[l], heights[r]);
            max = Math.max(curr, max);
            if (heights[l] < heights[r]) l++;
            else r--;
        }
        return max;
    }
}
