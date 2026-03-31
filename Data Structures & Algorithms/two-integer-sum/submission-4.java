class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (sum.containsKey(complement)){
                return new int[]{sum.get(complement), i};
            }
            sum.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
