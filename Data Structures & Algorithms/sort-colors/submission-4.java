class Solution {
    public void sortColors(int[] nums) {
        /*
            one pass

            three pointers: you are assigning like put all 0s in the beginning, 2s in the end and rest in the middle
            so if mid is 0, swap with mid
            if mid is 1, increase mid
            if mid is 2, swap mid with high

        */
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high){
            if (nums[mid] == 0){
                int temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
    }
}