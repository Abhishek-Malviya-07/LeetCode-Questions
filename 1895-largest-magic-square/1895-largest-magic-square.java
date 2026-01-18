class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        int[][] sumR = new int[m][n + 1];
        int[][] sumC = new int[m + 1][n];
        int[][] sumD1 = new int[m + 1][n + 1];
        int[][] sumD2 = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumR[i][j + 1] = sumR[i][j] + grid[i][j];
                sumC[i + 1][j] = sumC[i][j] + grid[i][j];
                sumD1[i + 1][j + 1] = sumD1[i][j] + grid[i][j];
                sumD2[i + 1][j] = sumD2[i][j + 1] + grid[i][j];
            }
        }

        for (int k = Math.min(m, n); k > 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (check(grid, sumR, sumC, sumD1, sumD2, i, j, k)) return k;
                }
            }
        }
        return 1;
    }

    private boolean check(int[][] g, int[][] sR, int[][] sC, int[][] sD1, int[][] sD2, int r, int c, int k) {
        int target = sR[r][c + k] - sR[r][c];

        for (int i = r + 1; i < r + k; i++) {
            if (sR[i][c + k] - sR[i][c] != target) return false;
        }

        for (int j = c; j < c + k; j++) {
            if (sC[r + k][j] - sC[r][j] != target) return false;
        }

        if (sD1[r + k][c + k] - sD1[r][c] != target) return false;

        if (sD2[r + k][c] - sD2[r][c + k] != target) return false;

        return true;
    }
}