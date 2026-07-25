class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int maxArea = 0;
        while (l < r){
            if (height[l] < height[r]){
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                maxArea += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(height[r], maxRight);
                maxArea += maxRight - height[r];
            }
        }
        return maxArea;
    }
}
