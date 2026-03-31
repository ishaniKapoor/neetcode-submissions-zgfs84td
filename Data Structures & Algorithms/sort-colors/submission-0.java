class Solution {
    public void sortColors(int[] nums) {
        int[] count = {0, 0, 0}; // counting array
        for (int num: nums){
            count[num] += 1; //counts frequency of number at each index
        }

        int index = 0;
        for (int i = 0; i < count.length; i++){
            for (int j = 0; j < count[i]; j++){
                nums[index] = i;
                index++;
            }
        }
    }
}