class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[ROWS][COLS];

        if (grid[0][0] == 1 || grid[ROWS - 1][COLS - 1] == 1) return -1;

        int[][] neighbors = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

        q.add(new int[]{0, 0});
        visit[0][0] = true;

        int length = 1;
        while (!q.isEmpty()){
            int queueLen = q.size();
            for (int i = 0; i < queueLen; i++){
                int[] pair = q.poll();
                int r = pair[0], c = pair[1];
                if (r == ROWS - 1 && c == COLS - 1) return length;
                
                for (int[] dir: neighbors){
                    int newR = dir[0] + r;
                    int newC = dir[1] + c;

                    if (newR < 0 || newC < 0 || newR >= ROWS || newC >= COLS
                    || grid[newR][newC] == 1 || visit[newR][newC]) continue;

                    q.offer(new int[]{newR, newC});
                    visit[newR][newC] = true;
                }
            }
            length++;
        }
        return -1;
    }
}