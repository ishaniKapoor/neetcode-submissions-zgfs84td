class Solution {
    public void sortColors(int[] nums) {
        int[] counts = {0, 0, 0};
        for (int num: nums){
            counts[num] += 1;
        }
        int i = 0;
        for (int n = 0; n < counts.length; n++){
            for (int j = 0; j < counts[n]; j++){
                nums[i] = n;
                i++;
            }
        }
    }
}