class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> seen = new HashSet<>();
        for (int num: nums1){
            seen.add(num);
        }

        List<Integer> res = new ArrayList<>();
        for (int num: nums2){
            if (seen.contains(num)){
                res.add(num);
                seen.remove(num);
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}