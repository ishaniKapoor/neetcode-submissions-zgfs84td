class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return helper(0, nums);
    }

    private List<List<Integer>> helper(int i, int[] nums){
        if (i == nums.length){
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> perms = helper(i + 1, nums);
        for (List<Integer> p: perms){
            for (int k = 0; k < p.size() + 1; k++){
                List<Integer> pCopy = new ArrayList<>();
                pCopy.addAll(p);
                pCopy.add(k, nums[i]);
                res.add(pCopy);
            }
        }
        return res;
        
    }
}
