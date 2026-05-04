class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                int boxIndex = (r / 3)*3 + (c / 3);

                if (board[r][c] == '.') continue;

                if (rows[r].contains(board[r][c]) || cols[c].contains(board[r][c])
                || boxes[boxIndex].contains(board[r][c])) return false;
                else {
                    rows[r].add(board[r][c]);
                    cols[c].add(board[r][c]);
                    boxes[boxIndex].add(board[r][c]);
                }
            }
        }
        return true;
    }
}
