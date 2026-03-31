class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0, prefix = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num: nums){
            prefix += num;
            int diff = prefix - k;
            res += map.getOrDefault(diff, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }
        return res;
    }
}