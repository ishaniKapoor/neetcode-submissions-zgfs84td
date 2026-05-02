class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
            [1, 2, 4, 6] 
            48, 24, 12, 8

            Prefix and postfix
            int pre = 1
            int[] prefix

            int postfix = 1
        */

        int[] prefix = new int[nums.length];
        Arrays.fill(prefix, 1);
        int pre = 1;
        for (int i = 0; i < nums.length; i++){
            prefix[i] = pre;
            pre *= nums[i];
        }

        int post = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            prefix[i] *= post;
            post *= nums[i];
        }

        return prefix;
    }
}  
