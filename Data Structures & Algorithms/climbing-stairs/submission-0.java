class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n + 1];
        return memoization(n, cache);
    }

    public int memoization(int n, int[] cache){
        if (n <= 2){
            return n;
        }
        if (cache[n] != 0){
            return cache[n];
        }
        cache[n] = memoization(n - 1, cache) + memoization(n - 2, cache);
        return cache[n];
    }
}
