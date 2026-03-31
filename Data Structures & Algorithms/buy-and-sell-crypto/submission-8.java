class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int l = 0, r = 1;
        while (r < prices.length){
            if (prices[l] >= prices[r]){
                l = r; 
            } else if (prices[l] < prices[r]){
                int currProfit = prices[r] - prices[l];
                maxProfit = Math.max(currProfit, maxProfit);
            }
            r++;
        }
        return maxProfit;
    }
}
