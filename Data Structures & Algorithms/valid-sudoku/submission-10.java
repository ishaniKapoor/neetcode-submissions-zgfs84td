class Solution {
    public boolean isValidSudoku(char[][] board) {
        /**
            make 9 hashsets each because of duplicate checks
            one (9) for rows, one (9) for cols, one (9) for a box
            each size should be 9
            idx of each should be calculated row, col, or 
            row / 3 *3 + col / 3
            if at any point curr char exists in hashsets already then return
            false 
            else add to all three corresponding ones
        **/

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++){
            for (int col = 0; col < 9; col++){
                int boxIdx = (row / 3) * 3 + (col / 3);
                if (board[row][col] != '.'){
                    if (rows[row].contains(board[row][col]) ||
                        cols[col].contains(board[row][col]) || 
                        boxes[boxIdx].contains(board[row][col])) 
                        return false;
                    else {
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
