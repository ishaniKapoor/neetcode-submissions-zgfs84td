class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r){
            while (l < r && !isAlphaNum(s.charAt(l))) l++;
            while (r > l && !isAlphaNum(s.charAt(r))) r--;
            if (l < r && isAlphaNum(s.charAt(l)) && isAlphaNum(s.charAt(r))
            && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    boolean isAlphaNum(Character c){
        return (c >= 'a' && c <= 'z' ||
                c >= 'A' && c <= 'Z' ||
                c >= '0' && c <= '9');
    }
}
