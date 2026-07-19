class Solution {
    public boolean isValidSudoku(char[][] board) {
        /**
            make 9 different hashsets for each row, col, box

            store based on idx

            box idx = row / 3 * 3 + col / 3

            if not '.' then check if in any row, col, box
                                    if yes return false
                                    if not add
            return true
        **/

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                int boxIdx = (row / 3) * 3 + (col / 3);

                if (board[row][col] != '.'){
                    if (rows[row].contains(board[row][col]) ||
                    cols[col].contains(board[row][col]) ||
                    boxes[boxIdx].contains(board[row][col])){
                        return false;
                    } else {
                        rows[row].add(board[row][col]);
                        cols[col].add(board[row][col]);
                        boxes[boxIdx].add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
}
