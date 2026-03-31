class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int p : piles){
            r = Math.max(p, r);
        }
        int res = r;

        while (l <= r){
            int k = (l + r) / 2;
            long hours = 0;
            for (int p : piles){
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
