class Solution {
    public int[] searchRange(int[] nums, int target) {
      int n = nums.length;
      int start = binarySearch(nums, target, n);
      if (start == n || nums[start] != target) return new int[]{-1, -1};

      return new int[]{start, binarySearch(nums, target + 1, n) - 1};
    }

    private int binarySearch(int[] nums, int target, int n){
        int l = 0, r = n;
        while (l < r){
            int m = l + (r - l) / 2;
            if (nums[m] >= target){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}