class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // max of piles values is the sequence of rates, 
        // we do binary search instead of 
        // picking from 1 and increasing till we find minimum rate
        int l = 0;
        int r = 0;
        for(int p: piles){
            r = Math.max(p, r);
        }
        int res = r;
        while (l <= r){
            int hours = 0;
            int k = (l + r) / 2;
            for (int p: piles){
                hours += Math.ceil((double)p / k);
            }
            if (hours <= h){
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}
