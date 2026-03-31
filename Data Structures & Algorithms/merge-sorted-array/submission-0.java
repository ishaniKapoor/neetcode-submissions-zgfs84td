class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /*
            we wanna work backwards
            assign two variables i and j with end of nums1 and nums2
            assign a variable k with the elem where we can start assigning
            while i and j are greater than 0
                check if nums1[i] > nums2[j] place nums1[k--] = nums1[i--];
                else nums1[k--] = nums2[j--]
            now add the remaining elements in nums2 
            while j >= 0 nums1[k--] = nums2[j--]

        */

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}