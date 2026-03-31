class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0, r = 0;
        for (int pile: piles){
            r = Math.max(pile, r);
        }
        int res = r;
        while (l <= r){
            int k = (l + r) / 2;
            int hours = 0;
            for (int pile: piles){
                hours += Math.ceil((double)pile / k);
            }
            if (hours <= h){
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }
}
