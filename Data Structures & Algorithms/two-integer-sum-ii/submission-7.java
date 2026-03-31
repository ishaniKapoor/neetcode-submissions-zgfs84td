class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int L = 0, R = numbers.length - 1;
        while (L < R){
            int sum = numbers[L] + numbers[R];
            if (sum > target){
                R--;
            } else if (sum < target){
                L++;
            } else {
                return new int[]{L+ 1, R+ 1};
            }
        }
        return new int[]{-1, -1};
    }
}
