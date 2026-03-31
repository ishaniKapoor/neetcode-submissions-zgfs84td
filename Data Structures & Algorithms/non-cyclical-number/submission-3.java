class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        while (!seen.contains(n)){
            seen.add(n);
            n = helper(n);
            if (n == 1) return true;
        }
        return false;
    }

    private int helper(int n){
        int res = 0;
        while (n > 0){
            int digit = n % 10;
            digit = digit*digit;
            res += digit;
            n /= 10;
        }
        return res;
    }
}
