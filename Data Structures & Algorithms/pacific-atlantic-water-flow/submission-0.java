class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for (int c = 0; c < COLS; c++){
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        for (int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    public void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        ocean[row][col] = true;
        for (int[] d : directions){
            int nr = row + d[0], nc = col + d[1];
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length 
            && !ocean[nr][nc] && heights[nr][nc] >= heights[row][col]){
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
