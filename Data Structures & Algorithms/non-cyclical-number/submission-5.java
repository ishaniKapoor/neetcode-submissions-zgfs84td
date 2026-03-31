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

    public int helper(int n){
        int temp = n;
        int sum = 0;
        while (temp > 0){
            int digit = temp % 10;
            sum += digit * digit;
            temp /= 10;
        }
        return sum;
    }
}
