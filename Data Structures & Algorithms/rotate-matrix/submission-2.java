class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);

        //transpose
        for (int i = 0; i < matrix.length; i++){
            for (int j = i; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverse(int[][] matrix){
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = tmp;
        }
    }
}
