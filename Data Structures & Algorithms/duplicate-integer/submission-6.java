class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            if (count.containsKey(n)){
                count.put(n, count.get(n) + 1);
                if (count.get(n) > 1) return true;
            } else count.put(n, count.getOrDefault(n, 0) + 1);
        }
        return false;
    }
}