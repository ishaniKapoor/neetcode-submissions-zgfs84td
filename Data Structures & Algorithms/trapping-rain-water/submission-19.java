class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int maxArea = 0;
        while (l < r){
            if (height[l] < height[r]){
                leftMax = Math.max(height[l], leftMax);
                maxArea += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(height[r], rightMax);
                maxArea += rightMax - height[r];
                r--;
            }
        }
        return maxArea;
    }
}
