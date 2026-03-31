class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;
        for (int num: nums){
            res += count.getOrDefault(num, 0);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        return res;
    }
}