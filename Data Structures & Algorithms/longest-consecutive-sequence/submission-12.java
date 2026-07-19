class Solution {
    public int longestConsecutive(int[] nums) {
        /**
            hashSet to remove duplicates and put into order
            if there's not a number one less than start here
            keep going until no more num + 1
        **/

        HashSet<Integer> set = new HashSet<>();
        for (int num: nums){
            set.add(num);
        }

        int maxLen = 0;
        for (int num: nums){
            if (!set.contains(num - 1)){
                int currNum = num;
                int currCount = 1;
                while (set.contains(currNum + 1)){
                    currNum++;
                    currCount++;
                }
                maxLen = Math.max(currCount, maxLen);
            }
        }
        return maxLen;
    }
}
