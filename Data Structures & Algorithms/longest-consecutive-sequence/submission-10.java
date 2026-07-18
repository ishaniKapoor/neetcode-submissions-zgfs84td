class Solution {
    public int longestConsecutive(int[] nums) {
        /**
            can't sort because O(n)
            battle is trying to figure out where to start
            if there isn't a number one less than this current one, start
            skip if double

            visually:
            moving across the array to look for where to start found nothing less
            than zero so start there
            0, look through array for 0 + 1, then 1 + 1, ...

            algorithm:
            hashset for entire array
            need indx so for (int i = 0; ...)
            if num - 1 not in nums then start here
        **/

        HashSet<Integer> res = new HashSet<>();
        for (int num: nums) res.add(num);
        int maxLen = 0;
        for (int num: nums){
            if (!res.contains(num - 1)){
                int curr = 1;
                int currNum = num;
                while (res.contains(currNum + 1)) {
                    curr++;
                    currNum++;
                }
                maxLen = Math.max(maxLen, curr);
            }
        }
        return maxLen;
    }
}
