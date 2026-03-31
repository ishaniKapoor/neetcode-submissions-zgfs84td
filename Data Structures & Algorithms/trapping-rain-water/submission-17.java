class Solution {
    public int trap(int[] height) {
        /**
            Sliding Window
            - left and right
            - leftMax and Rightmax
            - maxarea

            O(n), O(1)
        */
        int left = 0, right = height.length - 1; // 0, 2, 0, 3, 1, 0
        int leftMax = height[left], rightMax = height[right]; // 0 , 1
        int maxArea = 0;
        while (left < right){
            if (height[left] < height[right]){
                maxArea += leftMax - height[left]; // 0
                left++; // 1
                leftMax = Math.max(leftMax, height[left]); //
            } else {
                maxArea += rightMax - height[right];
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }
        return maxArea;
    }
}
