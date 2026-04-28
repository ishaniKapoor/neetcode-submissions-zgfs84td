class Solution {
    public boolean hasDuplicate(int[] nums) {
        // 1, 2, 3, 3
        HashSet<Integer> set = new HashSet<>(); // 1 2 3
        for (int n: nums){
            if (set.contains(n)) return true;
            else set.add(n);
        }
        return false;
    }
}