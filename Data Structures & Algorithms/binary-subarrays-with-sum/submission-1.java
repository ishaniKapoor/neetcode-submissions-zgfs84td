class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countAtMost(nums, goal) - countAtMost(nums, goal - 1);
    }

    public int countAtMost(int[] nums, int k){
        if (k < 0) return 0;
        int l = 0, sum = 0, count = 0;
        for (int r = 0; r < nums.length; r++){
            sum += nums[r];
            while (sum > k){
                sum -= nums[l++];
            }
            count += (r - l + 1);
        }
        return count;
    }
}