class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int maxArea = 0;
        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                int area = 0;
                if (grid[r][c] == 1){
                    area = dfs(grid, r, c);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c){
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length ||
        grid[r][c] == 0) return 0;

        grid[r][c] = 0;
        return 1 + dfs(grid, r + 1, c) + 
        dfs(grid, r - 1, c) + 
        dfs(grid, r, c + 1) + 
        dfs(grid, r, c - 1);
    }
}
