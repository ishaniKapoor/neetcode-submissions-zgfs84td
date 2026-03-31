class Solution {
    public int climbStairs(int n) {
        if (n < 3) return n;
        int[] dp = new int[]{1, 2};
        int i = 2;
        while (i < n){
            int temp = dp[1];
            dp[1] = dp[1] + dp[0];
            dp[0] = temp;
            i++;
        }
        return dp[1];
    }
}
