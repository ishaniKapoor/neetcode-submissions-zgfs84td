class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num: nums1){
            set.add(num);
        }

        for (int num: nums2){
            if (set.contains(num)){
                res.add(num);
                set.remove(num);
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
}