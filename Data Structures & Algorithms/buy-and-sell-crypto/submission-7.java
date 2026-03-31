class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = l + 1;
        while (r < prices.length){
            if (prices[l] < prices[r]){
                int profit = prices[r] - prices[l];
                maxProfit = Math.max(maxProfit, profit);
                r++;
            } else {
                l++; r = l + 1;
            }
        }
        return maxProfit;
    }
}
