class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, total = 0;
        int min = nums.length + 1;
        for (int r = 0; r < nums.length; r++){
            total += nums[r];
            while (total >= target){
                min = Math.min(min, r - l + 1);
                total -= nums[l];
                l += 1;
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }
}