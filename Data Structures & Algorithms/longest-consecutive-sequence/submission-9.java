class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        // 2, 3, 4, 5, 10, 20
        int longest = 0;
        for (int i = 0; i < nums.length; i++){
            if (!set.contains(nums[i] - 1)){
                int currCount = 1, currNum = nums[i];
                while (set.contains(currNum + 1)) {
                    currCount++; currNum++;
                }   
                longest = Math.max(longest, currCount);
            }
        }
        return longest;
    }
}
