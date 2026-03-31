class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[0], rightMax = height[height.length - 1];
        int maxArea = 0;
        while (l < r){
            if (leftMax < rightMax){
                l++;
                leftMax = Math.max(leftMax, height[l]);
                maxArea += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                maxArea += rightMax - height[r];
            }
        }
        return maxArea;
    }
}
