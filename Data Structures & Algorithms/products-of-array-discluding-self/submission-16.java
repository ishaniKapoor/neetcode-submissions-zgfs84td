class Solution {
    public int[] productExceptSelf(int[] nums) {
        /**
            1 [1, 2, 4, 6]
            pre fix = 1
            first pass multiplies with pre fix
            pre fix = 2
            res = [1, 1, 2, 8]
            post fix = 48
            res = [48, 24, 12, 8]
        **/

        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = res.length - 1; i >= 0; i--){
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }
}  
