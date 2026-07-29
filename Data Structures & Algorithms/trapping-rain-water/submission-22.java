class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int maxLeft = height[l], maxRight = height[r];
        int max = 0;
        while (l < r){
            if (height[l] < height[r]){
                l++;
                maxLeft = Math.max(height[l], maxLeft);
                max += maxLeft - height[l];
            } else {
                r--;
                maxRight = Math.max(height[r], maxRight);
                max += maxRight - height[r];
            }
        }
        return max;
    }
}
