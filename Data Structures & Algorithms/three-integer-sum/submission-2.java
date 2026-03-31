class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // assign a result List<List<Integer>>
        // sort the num list
        // for loop: every num in nums with index
        // if current number > 0 break
        // if i > 0 and prev number same, continue
        // assign two pointer l and right, l = index + 1, r = nums.length - 1
        // while l < r
        // check the current sum of all three
        // if sum is greater than 0, r--
        // if sum is less than 0, l++
        // if sum == , res.append( new list with the three numbers)
        // remove duplicates : while (nums[l] == nums[l - 1] and l < r) l++
        // return res

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int curr = nums[i] + nums[r] + nums[l];
                if (curr > 0){
                    r--;
                } else if (curr < 0){
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;
                    while (nums[l] == nums[l - 1] && l < r){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
