class Solution {
    int m, n;
    boolean findAndCrush(int[][] board){
        boolean complete = true;
        //vertical
        for (int r = 1; r < m - 1; r++){
            for (int c = 0; c < n; c++){
                if (board[r][c] == 0) continue; 
                if (Math.abs(board[r][c]) == Math.abs(board[r + 1][c]) &&
                Math.abs(board[r][c]) == Math.abs(board[r - 1][c])){
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r + 1][c] = -Math.abs(board[r + 1][c]);
                    board[r - 1][c] = -Math.abs(board[r - 1][c]);
                    complete = false;
                }
            }
        }

        //horizontal
        for (int r = 0; r < m; r++){
            for (int c = 1; c < n - 1; c++){
                if (board[r][c] == 0) continue;
                if (Math.abs(board[r][c]) == Math.abs(board[r][c + 1]) &&
                Math.abs(board[r][c]) == Math.abs(board[r][c - 1])){
                    board[r][c] = -Math.abs(board[r][c]);
                    board[r][c + 1] = -Math.abs(board[r][c + 1]);
                    board[r][c - 1] = -Math.abs(board[r][c - 1]);
                    complete = false;
                }
            }
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] < 0) board[r][c] = 0;
            }
        }
        return complete;
    }

    void drop(int[][] board){
        for (int c = 0; c < board[0].length; c++){
            int lowestZero = board.length - 1;
            for (int r = board.length - 1; r >= 0; r--){
                if (board[r][c] != 0){
                    int temp = board[r][c];
                    board[r][c] = board[lowestZero][c];
                    board[lowestZero][c] = temp;
                    lowestZero--;
                }
            }
        }
    }

    public int[][] candyCrush(int[][] board) {
        m = board.length; n = board[0].length;
        while (!findAndCrush(board)){
            drop(board);
        }
        return board;
    }
}