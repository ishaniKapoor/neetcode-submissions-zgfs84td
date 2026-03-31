class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> sub = new HashSet<>();
        int l = 0;
        int maxSubstring = 0;
        for (int r= 0; r < s.length(); r++){
            while (sub.contains(s.charAt(r))){
                sub.remove(s.charAt(l));
                l++;
            }
            sub.add(s.charAt(r));
            maxSubstring = Math.max(maxSubstring, r - l+ 1);
        }
        return maxSubstring;
    }
}
