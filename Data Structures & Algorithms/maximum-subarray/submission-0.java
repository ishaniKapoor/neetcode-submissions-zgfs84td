class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curr = 0;
        for (int n : nums){
            curr = Math.max(curr, 0);
            curr += n;
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }
}
