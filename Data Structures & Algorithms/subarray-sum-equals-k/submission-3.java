class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currSum = 0;
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        for (int i = 0; i < nums.length; i++){
            currSum += nums[i];
            int diff = currSum - k;
            res += prefix.getOrDefault(diff, 0);
            prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        }
        return res;
    }
}