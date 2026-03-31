class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0];
        int currMax = 0, currMin = 0;
        int total = 0;

        for (int n : nums){
            currMax = Math.max(currMax + n, n);
            currMin = Math.min(currMin + n, n);
            total += n;
            globalMax = Math.max(globalMax, currMax);
            globalMin = Math.min(globalMin, currMin);
        }

        return globalMax > 0 ? 
        Math.max(globalMax, total - globalMin) : globalMax;
    }
}