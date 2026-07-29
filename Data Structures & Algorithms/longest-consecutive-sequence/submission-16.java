class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            int currNum = nums[i];
            int currCount = 1;
            if (!set.contains(currNum - 1)){
                while (set.contains(currNum + 1)){
                    currNum++;currCount++;
                }
            }
            max = Math.max(max, currCount);
        }
        return max;
    }
}
