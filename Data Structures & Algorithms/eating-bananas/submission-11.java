class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = 0;
        for (int p: piles) r = Math.max(r, p);

        int min = r;
        while(l <= r){
            int mid = l + (r - l) / 2;

            int hours = 0;
            for (int pile: piles){
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h){
                min = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return min;
    }
}
