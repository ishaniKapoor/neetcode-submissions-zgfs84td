class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /**
            -1 0 1 2 -1 -4

            sort
            -4 -1 -1 0 1 2

            for loop and two indices 
            how to check if already seen it?
            check if i and j and k not equal and if they are then move forward?
            if equal to 0, add to res
        **/
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++){
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++; j--;
                    while (i < j && nums[i] == nums[i - 1])i++;
                    while (i < j && nums[j] == nums[j + 1])j--;
                } 
                else if (sum < 0) i++;
                else j--;
            }
        }
        return res;
    }
}
