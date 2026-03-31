class Solution {
    public int findMin(int[] nums) {
        // brute force 
        // binary: search for an element
        // mid = l + (r - l) / 2 
        // two pointers l and r 
        // while l < r create a new mid value
        // when to use l<r and l <= r
        // check if nums at mid < r, l = mid + 1
        // else r = mid;
        // nums[l]
        // O(logn), O(1)
        // 3, 4, 5, 6, 1, 2
        int l = 0, r = nums.length - 1; // l = 4, r = 5
        while (l <= r){
            int mid = (r + l) / 2; // 4
            if (nums[mid] > nums[r]){ // 
                l = mid + 1; //
            } else if (nums[mid] < nums[r]){
                r = mid; // 4
            } else if (nums[l] == nums[r]) 
                return nums[l];
        }
        return nums[l];
    }
}
