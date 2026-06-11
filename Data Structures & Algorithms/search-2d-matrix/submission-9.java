class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /*
            10
            if target is in range of l and r then binary search on that int[]
            1  2  4  8
            10 11 12 13
            14 20 30 40
        */

        int l = 0, r = (matrix[0].length * matrix.length)- 1; // l = 0, r = 3

        while (l <= r){
            int mid = l + (r - l) / 2;
            int row = mid / matrix[0].length;
            int col = mid % matrix[0].length;
            if (matrix[row][col] < target) l = mid + 1;
            else if (matrix[row][col] > target) r = mid - 1;
            else return true;
        }
        return false;
    }
}
