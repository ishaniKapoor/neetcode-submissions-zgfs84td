class Solution {
    public int maxProfit(int[] prices) {
        // two pointers to the l = 0, r = 1
        // keep track of the max profit as you go
        // if pointer to l < pointer to r, change maxP
        // else l = r, r++
        // O(n), O(1)
        //10, 3, 5, 1, 7, 1
        //10
        int l = 0, r = 1;
        int maxProfit = 0;

        while (r < prices.length){
            if (prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(profit, maxProfit);
            } else {
                l = r;
            }
            r++;
        }
        return maxProfit;
    }
}
