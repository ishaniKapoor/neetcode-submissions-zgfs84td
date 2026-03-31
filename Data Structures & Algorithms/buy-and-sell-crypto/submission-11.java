class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int maxResult = 0;
        while(r < prices.length){
            if (prices[l] < prices[r]){
                maxResult = Math.max(maxResult, prices[r] - prices[l]);
            } else l = r;
            r++;
        }
        return maxResult;
    }
}
