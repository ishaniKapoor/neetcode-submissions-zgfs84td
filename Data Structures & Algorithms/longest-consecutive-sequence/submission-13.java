class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);

        int maxLen = 0;
        for(int num: nums){
            if (!set.contains(num - 1)){
                int currNum = num;
                int currCount = 1;
                while (set.contains(currNum + 1)){
                    currCount++;
                    currNum++;
                }
                maxLen = Math.max(currCount, maxLen);
            }
        }
        return maxLen;
    }
}
