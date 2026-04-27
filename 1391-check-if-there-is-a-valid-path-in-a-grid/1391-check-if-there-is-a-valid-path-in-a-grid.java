class Solution {
   
    int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
   
    int[][] pipe = {
        {},
        {2, 3}, 
        {0, 1},
        {2, 1}, 
        {3, 1}, 
        {2, 0}, 
        {3, 0}  
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            if (r == m - 1 && c == n - 1) return true;

            int streetType = grid[r][c];
            for (int dirIdx : pipe[streetType]) {
                int nr = r + move[dirIdx][0];
                int nc = c + move[dirIdx][1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                    if (canConnect(dirIdx, grid[nr][nc])) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return false;
    }

    private boolean canConnect(int dirFrom, int nextStreet) {
        int needed;
        if (dirFrom == 0) needed = 1;
        else if (dirFrom == 1) needed = 0;
        else if (dirFrom == 2) needed = 3;
        else needed = 2;

        for (int d : pipe[nextStreet]) {
            if (d == needed) return true;
        }
        return false;
    }
}