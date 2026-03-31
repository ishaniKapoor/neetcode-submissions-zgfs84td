class Solution {
    
    int[] prefix;
    public Solution(int[] w) {
        prefix = new int[w.length + 1];
        for (int i = 0; i < w.length; i++){
            prefix[i + 1] = prefix[i] + w[i];
        }
    }

    public int pickIndex() {
        double target = prefix[prefix.length - 1] * Math.random();
        int l = 0, r = prefix.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (prefix[mid] > target) r = mid;
            else l = mid + 1;
        }
        return l - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */