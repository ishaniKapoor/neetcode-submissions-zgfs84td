class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> combo = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int otherNum = target - nums[i];
            if (combo.containsKey(otherNum)){
                return new int[]{combo.get(otherNum), i};
            }
            combo.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
