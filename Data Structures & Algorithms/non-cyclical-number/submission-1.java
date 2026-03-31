class Solution {
    public boolean isHappy(int n) {

        Set<Integer> sums = new HashSet<>();
        int currentSum = helper(n);

        while (currentSum != 1){
            if (sums.contains(currentSum)) return false;
            sums.add(currentSum);
            currentSum = helper(currentSum);
        }
        return true;

    }

    private int helper(int n){
        int sum = 0;
        while (n > 0){
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
