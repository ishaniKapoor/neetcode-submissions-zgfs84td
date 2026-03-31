class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashSet<Character> count = new HashSet<>();
       int l = 0, res = 0;
       for (int r = 0; r < s.length(); r++){
            while (count.contains(s.charAt(r))){
                count.remove(s.charAt(l));
                l++;
            }
            count.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
       }
       return res;
    }
}
