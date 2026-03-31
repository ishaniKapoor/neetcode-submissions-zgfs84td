class Solution {
    public int lengthOfLongestSubstring(String s) {
        // zxyzxyz , 3
        // sliding window
        // left, right pointer, hashset 
        // O(n), O(n)
        if (s.length() == 0) return 0;

        int longest = 0;
        int l = 0;
        HashSet<Character> set = new HashSet<>(); // zxy
        for (int r = 0; r < s.length(); r++){
            while (set.contains(s.charAt(r))){ 
                set.remove(s.charAt(l)); // yz
                l++; // 2
            }
            set.add(s.charAt(r)); // yzx
            longest = Math.max(longest, (r - l + 1)); // 3
        }
        return longest;
    }
}
