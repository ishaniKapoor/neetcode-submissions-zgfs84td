class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            if (count.containsKey(num)) {
                count.put(num, count.getOrDefault(num, 0) + 1);
                if (count.get(num) > 1) return true;
            }
            count.put(num, 1);
        }
        return false;
    }
}